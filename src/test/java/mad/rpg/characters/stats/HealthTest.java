package mad.rpg.characters.stats;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthTest {

    private static final Integer DEFAULT_STAT_VALUE = 100;
    private static final Integer STAT_VALUE = 100;
    private static final Integer MODIFICATION_STAT_VALUE = 50;

    Stat<Integer> health;

    @Before
    public void setUp() throws Exception {
        health = new Health(DEFAULT_STAT_VALUE, STAT_VALUE);
    }

    @Test
    public void should_returnHealthType_when_getStatType() throws Exception {
        StatType statType = health.getType();
        assertThat(statType).isEqualTo(StatType.HEALTH);
    }

    @Test
    public void should_returnDefaultHealth_when_getDefaultStatValue() throws Exception {
        Integer defaultStatValue = health.getDefaultValue();
        assertThat(defaultStatValue).isEqualTo(DEFAULT_STAT_VALUE);
    }

    @Test
    public void should_returnCurrentHealth_when_getStatValue() throws Exception {
        Integer statValue = health.getValue();
        assertThat(statValue).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_addToCurrentHealth_when_addSomeStatValue() throws Exception {
        health.addValue(MODIFICATION_STAT_VALUE);
        assertThat(health.getValue()).isEqualTo(STAT_VALUE + MODIFICATION_STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_addNullStatValue() throws Exception {
        health.addValue(null);
        assertThat(health.getValue()).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_removeFromCurrentHealth_when_removeSomeStatValue() throws Exception {
        health.removeValue(MODIFICATION_STAT_VALUE);
        assertThat(health.getValue()).isEqualTo(STAT_VALUE - MODIFICATION_STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_removeNullStatValue() throws Exception {
        health.removeValue(null);
        assertThat(health.getValue()).isEqualTo(STAT_VALUE);
    }

}
