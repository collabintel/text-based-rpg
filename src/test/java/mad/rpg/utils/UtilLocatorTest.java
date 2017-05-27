package mad.rpg.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilLocatorTest {

    @Test
    public void should_getSameInputInstance_when_inputCalledMoreThanOnce() throws Exception {
        Input inputOne = UtilLocator.locate().input();
        Input inputTwo = UtilLocator.locate().input();

        assertThat(inputOne).isEqualTo(inputTwo);
    }

    @Test
    public void should_getSameOutputInstance_when_outputCalledMoreThanOnce() throws Exception {
        Output outputOne = UtilLocator.locate().output();
        Output outputTwo = UtilLocator.locate().output();

        assertThat(outputOne).isEqualTo(outputTwo);
    }

}
