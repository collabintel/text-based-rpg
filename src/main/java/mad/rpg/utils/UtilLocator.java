package mad.rpg.utils;

public class UtilLocator {

    private Input input;
    private Output output;

    public UtilLocator() {
        input = new Input();
        output = new Output();
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

}
