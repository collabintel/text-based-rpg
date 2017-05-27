package mad.rpg.world.actions;

import mad.rpg.game.Commands;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.Input;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;
import mad.rpg.world.model.Directions;
import mad.rpg.world.model.World;

import java.util.ArrayList;
import java.util.List;

public class ExploreAction implements Action {

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printLine(Messages.YOU_HAVE_ENTERED_THE_DUNGEON);
        World world = context.getWorld();
        List<String> commands = new ArrayList<>();
        commands.add(Commands.EXIT);
        commands.add(Commands.GO_NORTH);
        commands.add(Commands.GO_SOUTH);
        commands.add(Commands.GO_EAST);
        commands.add(Commands.GO_WEST);
        while(true){
            String input = UtilLocator.locate().input().receiveInput(commands);
            if(input.equals(Commands.EXIT)){
                context.addEvent(EventType.EXIT_REQUESTED);
                return;
            }
            if(input.equals(Commands.GO_NORTH)){
                Boolean result = world.changeLocation(Directions.NORTH);
                if(result){
                    UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_IN_ROOM, world.currentLocationIndex()));
                }
            }
            if(input.equals(Commands.GO_SOUTH)){
                Boolean result = world.changeLocation(Directions.SOUTH);
                if(result){
                    UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_IN_ROOM, world.currentLocationIndex()));
                }
            }
            if(input.equals(Commands.GO_EAST)){
                Boolean result = world.changeLocation(Directions.EAST);
                if(result){
                    UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_IN_ROOM, world.currentLocationIndex()));
                }
            }
            if(input.equals(Commands.GO_WEST)){
                Boolean result = world.changeLocation(Directions.WEST);
                if(result){
                    UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_IN_ROOM, world.currentLocationIndex()));
                }
            }
        }
    }

}
