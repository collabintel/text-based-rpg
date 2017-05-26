package mad.rpg.game;

import mad.rpg.game.states.*;

public class Application {

    public static void main(String[] args) {
        GameStateMachineBuilder
                .getInstance()
                .build()
                .run();
    }

}
