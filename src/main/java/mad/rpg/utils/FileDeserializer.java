package mad.rpg.utils;

import mad.rpg.characters.infos.InfoType;
import mad.rpg.game.context.Context;

import java.io.*;
import java.util.List;

public class FileDeserializer {

    public static void main(String[] args) throws FileDeserializationException {
        List<Context> contexts = new FileDeserializer().read(List.class, "sav");
        String playerName = contexts.get(0).getPlayer().getInfo(InfoType.NAME).get().getValue().toString();
        System.out.println(playerName);
    }

    protected FileDeserializer() {
    }

    public <T> T read(Class<T> type, String filename) throws FileDeserializationException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        T result = null;

        try {
            String baseDir = UtilLocator.locate().fileUtil().baseDir();
            fileInputStream = new FileInputStream(baseDir + "/" + filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            result = (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new FileDeserializationException(e);
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new FileDeserializationException(e);
                }
            }
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new FileDeserializationException(e);
                }
            }
        }
        return result;
    }

}
