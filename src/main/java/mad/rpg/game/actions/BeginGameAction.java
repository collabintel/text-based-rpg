package mad.rpg.game.actions;

import mad.rpg.game.context.Context;
import mad.rpg.game.Messages;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;

public class BeginGameAction implements Action {

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printMessage(Messages.WELCOME_GAME);
    }

}
