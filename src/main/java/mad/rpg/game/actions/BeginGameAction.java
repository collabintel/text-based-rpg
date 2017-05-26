package mad.rpg.game.actions;

import mad.rpg.game.context.Context;
import mad.rpg.game.Messages;
import mad.rpg.utils.Output;

public class BeginGameAction implements Action {

    @Override
    public void process(Context context) {
        Output.getInstance().printMessage(Messages.WELCOME_GAME);
    }

}
