package mad.rpg.characters.stats;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ExperienceCoefficientTest {

    private static final BigDecimal DEFAULT_STAT_VALUE = BigDecimal.ZERO;
    private static final BigDecimal STAT_VALUE = new BigDecimal("1");
    private static final BigDecimal MODIFICATION_STAT_VALUE = new BigDecimal("0.5");

    Stat<BigDecimal> experienceCoefficient;

    @Before
    public void setUp() throws Exception {
        experienceCoefficient = new ExperienceCoefficient(DEFAULT_STAT_VALUE, STAT_VALUE);
    }

    @Test
    public void should_getExperieneCoefficientType_when_getStatTypeCalled() throws Exception {
        StatType type = experienceCoefficient.getType();

        assertThat(type).isEqualTo(StatType.EXPERIENCE_COEFFICIENT);
    }

    @Test
    public void should_getDefaultExperienceCoefficient_when_getDefaultValueCalled() throws Exception {
        BigDecimal defaultValue = experienceCoefficient.getDefaultValue();

        assertThat(defaultValue).isEqualTo(DEFAULT_STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_addStatValueCalled() throws Exception {
        experienceCoefficient.addValue(MODIFICATION_STAT_VALUE);
        BigDecimal experienceCoefficientValue = experienceCoefficient.getValue();

        assertThat(experienceCoefficientValue).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_removeStatValueCalled() throws Exception {
        experienceCoefficient.removeValue(MODIFICATION_STAT_VALUE);
        BigDecimal experienceCoefficientValue = experienceCoefficient.getValue();

        assertThat(experienceCoefficientValue).isEqualTo(STAT_VALUE);
    }
}
