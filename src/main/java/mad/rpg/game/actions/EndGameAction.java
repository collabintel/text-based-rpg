package mad.rpg.game.actions;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.utils.Output;

public class EndGameAction implements Action {

    @Override
    public void process(Context context) {
        Output.getInstance().printMessage(Messages.EXIT_GAME);
    }

}
