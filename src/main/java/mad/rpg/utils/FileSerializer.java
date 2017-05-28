package mad.rpg.utils;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.Name;
import mad.rpg.characters.model.Enemy;
import mad.rpg.characters.model.Player;
import mad.rpg.characters.stats.AttackDamage;
import mad.rpg.characters.stats.Health;
import mad.rpg.characters.stats.Stat;
import mad.rpg.game.FileNames;
import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import mad.rpg.game.saves.SaveGame;
import mad.rpg.world.model.Dungeon;
import mad.rpg.world.model.Location;
import mad.rpg.world.model.Room;
import mad.rpg.world.model.World;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileSerializer {

    public static void main(String[] args) throws FileSerializationException {
        List<Info> infos = new ArrayList<>();
        infos.add(new Name("hede"));
        List<Stat> stats = new ArrayList<>();
        stats.add(new Health(10,10));
        stats.add(new AttackDamage(10,10));
        Location[][] locations = new Room[1][1];
        locations[0][0] = new Room(0,0, Optional.of(new Enemy(infos, stats)));
        World world = new Dungeon(locations);
        Context context = new GameContext();
        context.withPlayer(new Player(infos, stats));
        context.withWorld(world);
        context.addEvent(EventType.GAME_BUILT);
        List<SaveGame> saveGames = new ArrayList<>();
        saveGames.add(new SaveGame(context));
        new FileSerializer().write(saveGames, FileNames.SAVE_GAME);
    }

    protected FileSerializer() {
    }

    public void write(Object object, String filename) throws FileSerializationException {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            String baseDir = UtilLocator.locate().fileUtil().baseDir();
            fileOutputStream = new FileOutputStream(baseDir + "/" + filename);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (Exception ex) {
            throw new FileSerializationException(ex);
        } finally {
            if(fileOutputStream  != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new FileSerializationException(e);
                }
            }
            if(objectOutputStream  != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new FileSerializationException(e);
                }
            }
        }
    }

}
