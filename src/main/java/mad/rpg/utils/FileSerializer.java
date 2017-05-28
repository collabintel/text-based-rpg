package mad.rpg.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileSerializer {

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
