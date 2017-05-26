package mad.rpg.utils;

public class Output {

    private static final class OutputNested {
        private static final Output INSTANCE = new Output();
    }

    public static Output getInstance() {
        return OutputNested.INSTANCE;
    }

    public void printMessage(String message) {
        System.out.println("# " + message + " #");
    }

    public void printLine(String line) {
        System.out.println(line);
    }

    public void prompt(String prompt) {
        System.out.println(prompt);
        System.out.print(" > ");
    }

}
