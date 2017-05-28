package mad.rpg.game.saves;

import mad.rpg.game.FileNames;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.FileSerializationException;
import mad.rpg.utils.UtilLocator;

import java.util.ArrayList;
import java.util.List;

public class SaveGameRepository {

    public List<SaveGame> savedGames() throws FileDeserializationException {
        return UtilLocator.locate().fileDeserializer().read(List.class, FileNames.SAVE_GAME);
    }

    public Boolean hasSavedGames() throws FileDeserializationException {
        Boolean fileExists = UtilLocator.locate().fileUtil().exists(FileNames.SAVE_GAME);
        return fileExists ? UtilLocator.locate().fileDeserializer().read(List.class, FileNames.SAVE_GAME).size() > 0 : false;
    }

    public void saveGame(SaveGame saveGame) throws FileDeserializationException, FileSerializationException {
        List<SaveGame> saveGames = new ArrayList<>();
        if(hasSavedGames()){
            saveGames = savedGames();
        }
        saveGames.add(saveGame);
        UtilLocator.locate().fileSerializer().write(saveGames, FileNames.SAVE_GAME);
    }

}
