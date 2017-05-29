package mad.rpg.world.actions;

import mad.rpg.characters.model.HostileCharacter;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.Commands;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.UtilLocator;
import mad.rpg.world.model.Directions;
import mad.rpg.world.model.World;

import java.util.ArrayList;
import java.util.List;

public class ExploreAction implements Action {

    @Override
    public void process(Context context) {
        if(context.getLastEvent().equals(EventType.GAME_BUILT)){
            UtilLocator.locate().output().printLine(Messages.YOU_HAVE_ENTERED_THE_DUNGEON);
        }
        World world = context.getWorld();
        List<String> commands = new ArrayList<>();
        commands.add(Commands.EXIT);
        commands.add(Commands.SAVE_GAME);
        commands.add(Commands.GO_NORTH);
        commands.add(Commands.GO_SOUTH);
        commands.add(Commands.GO_EAST);
        commands.add(Commands.GO_WEST);
        if(context.events().get(context.events().size() - 2).equals(EventType.SAVE_GAME)) {
            UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_IN_ROOM, world.currentLocationIndex()));
        }
        while(true){
            UtilLocator.locate().output().printLine(Messages.WHERE_DO_YOU_WANT_TO_GO_NOW);
            String input = UtilLocator.locate().input().receiveInput(commands);
            if(input.equals(Commands.EXIT)){
                context.addEvent(EventType.EXIT_REQUESTED);
                return;
            }
            if(input.equals(Commands.SAVE_GAME)){
                context.addEvent(EventType.SAVE_GAME);
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
            if(world.currentLocation().hostile().isPresent()){
                HostileCharacter hostileCharacter = world.currentLocation().hostile().get();
                Integer hostileHealth = (Integer) hostileCharacter.getStat(StatType.HEALTH).get().getValue();
                if(hostileHealth > 0){
                    UtilLocator.locate().output().printLine(Messages.ENEMY_FOUND_IN_THE_ROOM);
                    context.addEvent(EventType.ENEMY_FOUND_IN_ROOM);
                    return;
                }
            }
        }
    }

}
