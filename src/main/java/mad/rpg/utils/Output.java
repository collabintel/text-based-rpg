package mad.rpg.utils;

public class Output {

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
