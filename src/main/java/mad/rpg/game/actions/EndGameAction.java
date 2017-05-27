package mad.rpg.game.actions;

import mad.rpg.game.Messages;
import mad.rpg.game.context.Context;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;

public class EndGameAction implements Action {

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printMessage(Messages.EXIT_GAME);
    }

}
