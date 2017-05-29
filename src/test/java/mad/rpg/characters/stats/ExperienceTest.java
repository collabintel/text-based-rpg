package mad.rpg.characters.stats;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ExperienceTest {

    private static final BigDecimal DEFAULT_STAT_VALUE = BigDecimal.ZERO;
    private static final BigDecimal STAT_VALUE = new BigDecimal("20");
    private static final BigDecimal MODIFICATION_STAT_VALUE = new BigDecimal("0.5");

    Stat<BigDecimal> experience;

    @Before
    public void setUp() throws Exception {
        experience = new Experience(DEFAULT_STAT_VALUE, STAT_VALUE);
    }

    @Test
    public void should_returnExperienceType_when_getStatType() throws Exception {
        StatType statType = experience.getType();
        assertThat(statType).isEqualTo(StatType.EXPERIENCE);
    }

    @Test
    public void should_getDefaultExperience_when_getDefaultStatValue() throws Exception {
        BigDecimal defaultStatValue = experience.getDefaultValue();
        assertThat(defaultStatValue).isEqualTo(DEFAULT_STAT_VALUE);
    }

    @Test
    public void should_getCurrentExperience_when_getStatValue() throws Exception {
        BigDecimal statValue = experience.getValue();
        assertThat(statValue).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_addToCurrentExperience_when_addSomeStatValue() throws Exception {
        experience.addValue(MODIFICATION_STAT_VALUE);
        assertThat(experience.getValue()).isEqualTo(BigDecimal.ZERO.add(STAT_VALUE).add(MODIFICATION_STAT_VALUE));
    }

    @Test
    public void should_doNothing_when_addNullStatValue() throws Exception {
        experience.addValue(null);
        assertThat(experience.getValue()).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_removeFromCurrentExprience_when_removeSomeStatValue() throws Exception {
        experience.removeValue(MODIFICATION_STAT_VALUE);
        assertThat(experience.getValue()).isEqualTo(STAT_VALUE.subtract(MODIFICATION_STAT_VALUE));
    }

    @Test
    public void should_doNothing_when_removeNullStatValue() throws Exception {
        experience.removeValue(null);
        assertThat(experience.getValue()).isEqualTo(STAT_VALUE);
    }
}
