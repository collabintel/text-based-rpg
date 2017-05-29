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

    @Test
    public void should_getSameFileUtilInstance_when_fileUtilCalledMoreThanOnce() throws Exception {
        FileUtil fileUtilOne = UtilLocator.locate().fileUtil();
        FileUtil fileUtilTwo = UtilLocator.locate().fileUtil();

        assertThat(fileUtilOne).isEqualTo(fileUtilTwo);
    }

    @Test
    public void should_getSameFileSerializerInstance_when_fileSerializerCalledMoreThanOnce() throws Exception {
        FileSerializer fileSerializerOne = UtilLocator.locate().fileSerializer();
        FileSerializer fileSerializerTwo = UtilLocator.locate().fileSerializer();

        assertThat(fileSerializerOne).isEqualTo(fileSerializerTwo);
    }

    @Test
    public void should_getSameFileDeserializerInstance_when_fileDeserializerCalledMoreThanOnce() throws Exception {
        FileDeserializer fileDeserializerOne = UtilLocator.locate().fileDeserializer();
        FileDeserializer fileDeserializerTwo = UtilLocator.locate().fileDeserializer();

        assertThat(fileDeserializerOne).isEqualTo(fileDeserializerTwo);
    }
}
