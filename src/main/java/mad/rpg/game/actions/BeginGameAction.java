package mad.rpg.game.actions;

import mad.rpg.game.Commands;
import mad.rpg.game.context.Context;
import mad.rpg.game.Messages;
import mad.rpg.game.events.EventType;
import mad.rpg.game.saves.SaveGameRepository;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.UtilLocator;

import java.util.ArrayList;
import java.util.List;

public class BeginGameAction implements Action {

    private SaveGameRepository saveGameRepository;

    public BeginGameAction(SaveGameRepository saveGameRepository) {
        this.saveGameRepository = saveGameRepository;
    }

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printMessage(Messages.WELCOME_GAME);
        try {
            if(saveGameRepository.hasSavedGames()){
                UtilLocator.locate().output().printLine(Messages.DO_YOU_WANT_TO_START_A_NEW_GAME_OR_LOAD_GAME);
                List<String> commands = new ArrayList<>();
                commands.add(Commands.EXIT);
                commands.add(Commands.NEW_GAME);
                commands.add(Commands.LOAD_GAME);
                String input = UtilLocator.locate().input().receiveInput(commands);
                if (input.equals(Commands.EXIT)){
                    context.addEvent(EventType.EXIT_REQUESTED);
                    return;
                }
                if (input.equals(Commands.LOAD_GAME)){
                    context.addEvent(EventType.LOAD_GAME);
                    return;
                }
            }
        } catch (FileDeserializationException e) {
            UtilLocator.locate().output().printLine(e.getMessage());
        }
        context.addEvent(EventType.NEW_GAME);
    }

}
