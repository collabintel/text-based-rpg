//package mad.rpg.game.events;
//
//import mad.rpg.game.context.Context;
//import mad.rpg.game.context.GameContext;
//import mad.rpg.utils.Input;
//import mad.rpg.utils.Output;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Output.class, Input.class})
//public class ChooseCharacterEventTest {
//
//    @Mock
//    private Output output;
//
//    @Mock
//    private Input input;
//
//    private Action chooseCharacterEvent;
//
//    private Context gameContext;
//
//    @Before
//    public void setUp() throws Exception {
//        PowerMockito.mockStatic(Output.class);
//        PowerMockito.when(Output.getInstance()).thenReturn(output);
//        PowerMockito.mockStatic(Input.class);
//        PowerMockito.when(Input.getInstance()).thenReturn(input);
//        chooseCharacterEvent = new ChooseCharacterAction();
//        gameContext = new GameContext();
//    }
//
//}
