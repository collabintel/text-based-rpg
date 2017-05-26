package mad.rpg.characters.infos;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    private static final String CHARACTER_NAME = "CHARACTER_NAME";

    private Info<String> name;

    @Before
    public void setUp() throws Exception {
        name = new Name(CHARACTER_NAME);
    }

    @Test
    public void should_getNameType_when_getInfoType() throws Exception {
        InfoType infoType = name.getType();
        assertThat(infoType).isEqualTo(InfoType.NAME);
    }

    @Test
    public void should_getName_when_getInfoValue() throws Exception {
        String infoValue = name.getValue();
        assertThat(infoValue).isEqualTo(CHARACTER_NAME);
    }
}
