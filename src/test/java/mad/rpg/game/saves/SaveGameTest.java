package mad.rpg.game.saves;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class SaveGameTest {

    SaveGame saveGame;

    Context context;

    @Before
    public void setUp() throws Exception {
        context = new GameContext();
        saveGame = new SaveGame(context);
    }

    @Test
    public void should_itemsOfSaveGameNotEmpty_when_instantiated() throws Exception {
        Context actualContext = saveGame.context();
        Date date = saveGame.date();

        assertThat(actualContext).isEqualTo(context);
        assertThat(date).isNotNull();
    }
}
