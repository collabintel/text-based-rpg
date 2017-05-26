package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;

public class NoCondition implements Condition {

    @Override
    public Boolean test(Context context) {
        return true;
    }

}
