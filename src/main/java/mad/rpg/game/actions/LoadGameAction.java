package mad.rpg.game.actions;

import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.model.Character;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.Commands;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.game.saves.SaveGame;
import mad.rpg.game.saves.SaveGameRepository;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.UtilLocator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class LoadGameAction implements Action {

    private SaveGameRepository saveGameRepository;
    private CharacterRepository characterRepository;

    public LoadGameAction(SaveGameRepository saveGameRepository, CharacterRepository characterRepository) {
        this.saveGameRepository = saveGameRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public void process(Context context) {
        List<SaveGame> saveGames = null;
        try {
            saveGames = saveGameRepository.savedGames();
            for (int i = 0; i < saveGames.size(); i++) {
                SaveGame saveGame = saveGames.get(i);
                Date date = saveGame.date();
                Character player = saveGame.context().getPlayer();
                String playerName = (String) player.getInfo(InfoType.NAME).get().getValue();
                Integer playerHealth = (Integer) player.getStat(StatType.HEALTH).get().getValue();
                UtilLocator.locate().output().printLine(String.format("%s. %s, health: %s, date: %s", i + 1, playerName, playerHealth, date));
            }

            List<String> commands = new ArrayList<>();
            commands.add(Commands.EXIT);
            String choice = UtilLocator.locate().input().choice(1, saveGames.size(), commands);
            if (choice.equals(Commands.EXIT)){
                context.addEvent(EventType.EXIT_REQUESTED);
                return;
            }

            SaveGame saveGame = saveGames.get(Integer.parseInt(choice) - 1);
            Context saveContext = saveGame.context();
            Character saveContextPlayer = saveContext.getPlayer();

            Boolean hasCharacters = characterRepository.hasCharacters();
            if(hasCharacters){
                characterRepository
                        .characters()
                        .stream()
                        .filter(character -> character.id().equals(saveContextPlayer.id()))
                        .findFirst()
                        .ifPresent(character -> {
                            saveContextPlayer.getStat(StatType.EXPERIENCE).get().removeValue(saveContextPlayer.getStat(StatType.EXPERIENCE).get().getValue());
                            saveContextPlayer.getStat(StatType.EXPERIENCE).get().addValue(character.getStat(StatType.EXPERIENCE).get().getValue());
                        });
            }

            context
                    .withPlayer(saveContextPlayer)
                    .withWorld(saveContext.getWorld());
            for (EventType eventType : saveContext.events()) {
                context.addEvent(eventType);
            }
            context.addEvent(context.events().get(context.events().size() - 2));
        } catch (FileDeserializationException e) {
            UtilLocator.locate().output().printLine(e.getMessage());
            context.addEvent(EventType.EXIT_REQUESTED);
        }
    }

}
