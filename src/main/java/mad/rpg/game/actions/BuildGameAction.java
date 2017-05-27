package mad.rpg.game.actions;

import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.world.model.World;
import mad.rpg.world.model.WorldBuilder;

public class BuildGameAction implements Action {

    private WorldBuilder worldBuilder;

    public BuildGameAction(WorldBuilder worldBuilder) {
        this.worldBuilder = worldBuilder;
    }

    @Override
    public void process(Context context) {
        World world = worldBuilder.build();
        context.withWorld(world);
        context.addEvent(EventType.GAME_BUILT);
    }

}
