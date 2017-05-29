package mad.rpg.characters.actions;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.model.Character;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.Choices;
import mad.rpg.game.Commands;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.Input;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChooseCharacterAction implements Action {

    private CharacterRepository playerRepository;

    public ChooseCharacterAction(CharacterRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printLine(Messages.CHOOSE_YOUR_CHARACTER);
        UtilLocator.locate().output().printLine(Choices.CREATE_A_CHARACTER_CHOICE);

        List<Character> characters = new ArrayList<>();
        try {
            Boolean hasCharacters = playerRepository.hasCharacters();
            if(hasCharacters){
                characters = playerRepository.characters();
            }
        } catch (FileDeserializationException e) {
            UtilLocator.locate().output().printLine(e.getMessage());
            UtilLocator.locate().output().printLine(Messages.UNHANDLED_OPERATION);
            context.addEvent(EventType.EXIT_REQUESTED);
            return;
        }

        List<Info> names = characters
                .stream()
                .map(player -> player.getInfo(InfoType.NAME).get())
                .collect(Collectors.toList());

        for (int i = 0; i < names.size(); i++) {
            UtilLocator.locate().output().printLine((i + 1) + ". " + names.get(i).getValue());
        }

        String receivedInput = UtilLocator.locate().input().choice(0, characters.size(), Arrays.asList(Commands.CREATE_CHARACTER, Commands.EXIT));

        if(receivedInput.equals(Commands.EXIT)){
            context.addEvent(EventType.EXIT_REQUESTED);
            return;
        }

        if(receivedInput.equals(Commands.CREATE_CHARACTER)){
            context.addEvent(EventType.CHARACTER_CREATION_REQUEST);
            return;
        }

        Integer choice = Integer.parseInt(receivedInput);
        Character player = characters.get(choice - 1);

        if(player == null){
            UtilLocator.locate().output().printMessage(Messages.CHARACTER_NOT_FOUND);
            return;
        }

        context.withPlayer(player);
        UtilLocator.locate().output().printLine(String.format(Messages.CHARACTER_SELECTED, player.getInfo(InfoType.NAME).get().getValue(), player.getStat(StatType.HEALTH).get().getValue(), player.getStat(StatType.ATTACK_DAMAGE).get().getValue(), player.getStat(StatType.EXPERIENCE).get().getValue()));
        context.addEvent(EventType.CHARACTER_SELECTED);
    }

}
