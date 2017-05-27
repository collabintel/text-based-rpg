package mad.rpg.utils;

import mad.rpg.game.Commands;
import mad.rpg.game.Messages;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    private static final class InputNested {
        private static final Input INSTANCE = new Input();
    }

    public static Input getInstance() {
        return InputNested.INSTANCE;
    }

    public String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true){
            input = scanner.nextLine();
            if(!input.equals("")){
                break;
            }
            Output.getInstance().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }
    public String receiveInput(List<String> commands) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true){
            input = scanner.nextLine();
            Boolean isCommand = false;
            for (String command : commands) {
                if(command.equals(input)){
                    isCommand = true;
                }
            }
            if (isCommand){
                break;
            }
            Output.getInstance().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }

    public Integer choice(Integer minRange, Integer maxRange) {
        Scanner scanner = new Scanner(System.in);
        Integer result = null;
        while (true){
            String input = scanner.nextLine();
            Boolean isNumber = Pattern.matches("[0-9]+", input);
            if(isNumber){
                result = Integer.parseInt(input);
                if(result >= minRange && result <= maxRange){
                    break;
                }
            }
            Output.getInstance().printMessage(Messages.INVALID_COMMAND);
        }
        return result;
    }

    public String choice(int minRange, int maxRange, List<String> commands) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true){
            input = scanner.nextLine();
            Boolean isCommand = false;
            for (String command : commands) {
                if(command.equals(input)){
                    isCommand = true;
                }
            }
            if (isCommand){
                break;
            }
            Boolean isNumber = Pattern.matches("[0-9]+", input);
            if(isNumber){
                Integer number = Integer.parseInt(input);
                if(number >= minRange && number <= maxRange){
                    break;
                }
            }
            Output.getInstance().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }

    public Boolean prompt() {
        Boolean promptCondition = null;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if(input.toLowerCase().equals(Commands.YES_WORD) || input.toLowerCase().equals(Commands.YES_LETTER)){
                promptCondition = true;
                break;
            } else if(input.toLowerCase().equals(Commands.NO_WORD) || input.toLowerCase().equals(Commands.NO_LETTER)){
                promptCondition = false;
                break;
            }
            Output.getInstance().printMessage(Messages.INVALID_COMMAND);
        }
        return promptCondition;
    }

}
