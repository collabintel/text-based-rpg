package mad.rpg.utils;

import java.io.File;

public class FileUtil {

    public Boolean exists(String filename){
        String baseDir = baseDir();
        File file = new File(baseDir + "/" + filename);

        return file.exists() && !file.isDirectory();
    }

    public String baseDir(){
        String applicationDir = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        if (applicationDir.endsWith(".jar"))
        {
            return new File(applicationDir).getParent();
        }
        return null;
    }

}
