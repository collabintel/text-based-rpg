package mad.rpg.utils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    private static final String MESSAGE = "MESSAGE";
    private static final String EXPECTED_MESSAGE = "# MESSAGE #\n";
    private static final String EXPECTED_MESSAGE_LINE = "MESSAGE\n";
    private static final String EXPECTED_MESSAGE_PROMPT = "MESSAGE\n > ";

    @Test
    public void should_printMessage_when_printMessageCalled() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Output.getInstance().printMessage(MESSAGE);

        String message = byteArrayOutputStream.toString();
        assertThat(message).isEqualTo(EXPECTED_MESSAGE);
    }

    @Test
    public void should_printLine_when_printLineCalled() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Output.getInstance().printLine(MESSAGE);

        String message = byteArrayOutputStream.toString();
        assertThat(message).isEqualTo(EXPECTED_MESSAGE_LINE);
    }

    @Test
    public void should_prompt_when_promptCalled() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Output.getInstance().prompt(MESSAGE);

        String message = byteArrayOutputStream.toString();
        assertThat(message).isEqualTo(EXPECTED_MESSAGE_PROMPT);
    }
}
