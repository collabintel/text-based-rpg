package mad.rpg.utils;

public class UtilLocator {

    private Input input;
    private Output output;
    private FileSerializer fileSerializer;
    private FileDeserializer fileDeserializer;
    private FileUtil fileUtil;

    public UtilLocator() {
        input = new Input();
        output = new Output();
        fileSerializer = new FileSerializer();
        fileDeserializer = new FileDeserializer();
        fileUtil = new FileUtil();
    }

    private static final class UtilLocatorNested {
        private static final UtilLocator INSTANCE = new UtilLocator();
    }

    public static UtilLocator locate() {
        return UtilLocatorNested.INSTANCE;
    }

    public Input input() {
        return input;
    }

    public Output output() {
        return output;
    }

    public FileSerializer fileSerializer() { return fileSerializer; }

    public FileDeserializer fileDeserializer() { return fileDeserializer; }

    public FileUtil fileUtil() { return fileUtil; }

}
