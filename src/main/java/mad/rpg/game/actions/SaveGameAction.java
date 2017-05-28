package mad.rpg.game.actions;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.game.saves.SaveGame;
import mad.rpg.game.saves.SaveGameRepository;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.FileSerializationException;
import mad.rpg.utils.UtilLocator;

public class SaveGameAction implements Action {

    private SaveGameRepository saveGameRepository;

    public SaveGameAction(SaveGameRepository saveGameRepository) {
        this.saveGameRepository = saveGameRepository;
    }

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printLine(Messages.DO_YOU_WANT_TO_SAVE_THIS_GAME);
        Boolean prompt = UtilLocator.locate().input().prompt();
        if(prompt){
            SaveGame saveGame = new SaveGame(context);
            try {
                saveGameRepository.saveGame(saveGame);
            } catch (FileDeserializationException e) {
                UtilLocator.locate().output().printLine(e.getMessage());
            } catch (FileSerializationException e) {
                UtilLocator.locate().output().printLine(e.getMessage());
            }
        }
        context.addEvent(context.events().get(context.events().size() - 2));
    }

}
