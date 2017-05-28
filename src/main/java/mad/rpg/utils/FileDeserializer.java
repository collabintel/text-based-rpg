package mad.rpg.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileDeserializer {

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
