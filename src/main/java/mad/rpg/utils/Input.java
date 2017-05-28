package mad.rpg.utils;

import mad.rpg.game.Commands;
import mad.rpg.game.Messages;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    private Scanner scanner;

    protected Input() {
        scanner = new Scanner(System.in);
    }

    public String receiveInput() {
        String input;
        while (true){
            input = scanner.nextLine();
            if(!input.equals("")){
                break;
            }
            UtilLocator.locate().output().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }
    public String receiveInput(List<String> commands) {
        String input;
        while (true){
            input = scanner.nextLine().toLowerCase();
            Boolean isCommand = false;
            for (String command : commands) {
                if(command.equals(input)){
                    isCommand = true;
                }
            }
            if (isCommand){
                break;
            }
            UtilLocator.locate().output().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }

    public Integer choice(Integer minRange, Integer maxRange) {
        Integer result;
        while (true){
            String input = scanner.nextLine();
            Boolean isNumber = Pattern.matches("[0-9]+", input);
            if(isNumber){
                result = Integer.parseInt(input);
                if(result >= minRange && result <= maxRange){
                    break;
                }
            }
            UtilLocator.locate().output().printMessage(Messages.INVALID_COMMAND);
        }
        return result;
    }

    public String choice(int minRange, int maxRange, List<String> commands) {
        String input;
        while (true){
            input = scanner.nextLine().toLowerCase();
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
            UtilLocator.locate().output().printMessage(Messages.INVALID_COMMAND);
        }
        return input;
    }

    public Boolean prompt() {
        Boolean promptCondition;
        while (true){
            String input = scanner.nextLine();
            if(input.toLowerCase().equals(Commands.YES_WORD) || input.toLowerCase().equals(Commands.YES_LETTER)){
                promptCondition = true;
                break;
            } else if(input.toLowerCase().equals(Commands.NO_WORD) || input.toLowerCase().equals(Commands.NO_LETTER)){
                promptCondition = false;
                break;
            }
            UtilLocator.locate().output().printMessage(Messages.INVALID_COMMAND);
        }
        return promptCondition;
    }

}
