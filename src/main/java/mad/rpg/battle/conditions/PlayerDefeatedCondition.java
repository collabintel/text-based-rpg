package mad.rpg.battle.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;

public class PlayerDefeatedCondition implements Condition {

    @Override
    public Boolean test(Context context) {
        return context.getLastEvent().equals(EventType.PLAYER_DEFEATED);
    }

}
