package mad.rpg.characters.stats;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttackDamageTest {

    private static final Integer DEFAULT_STAT_VALUE = 100;
    private static final Integer STAT_VALUE = 100;
    private static final Integer MODIFICATION_STAT_VALUE = 50;

    Stat<Integer> attackDamage;

    @Before
    public void setUp() throws Exception {
        attackDamage = new AttackDamage(DEFAULT_STAT_VALUE, STAT_VALUE);
    }

    @Test
    public void should_getAttackDamageType_when_getStatType() throws Exception {
        StatType statType = attackDamage.getType();
        assertThat(statType).isEqualTo(StatType.ATTACK_DAMAGE);
    }

    @Test
    public void should_getDefaultAttackDamage_when_getDefaultStatValue() throws Exception {
        Integer defaultStatValue = attackDamage.getDefaultValue();
        assertThat(defaultStatValue).isEqualTo(DEFAULT_STAT_VALUE);
    }

    @Test
    public void should_getCurrentAttackDamage_when_getStatValue() throws Exception {
        Integer statValue = attackDamage.getValue();
        assertThat(statValue).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_addToCurrentAttackDamage_when_addSomeStatValue() throws Exception {
        attackDamage.addValue(MODIFICATION_STAT_VALUE);
        assertThat(attackDamage.getValue()).isEqualTo(STAT_VALUE + MODIFICATION_STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_addNullStatValue() throws Exception {
        attackDamage.addValue(null);
        assertThat(attackDamage.getValue()).isEqualTo(STAT_VALUE);
    }

    @Test
    public void should_removeFromCurrentAttackDamage_when_removeSomeStatValue() throws Exception {
        attackDamage.removeValue(MODIFICATION_STAT_VALUE);
        assertThat(attackDamage.getValue()).isEqualTo(STAT_VALUE - MODIFICATION_STAT_VALUE);
    }

    @Test
    public void should_doNothing_when_removeNullStatValue() throws Exception {
        attackDamage.removeValue(null);
        assertThat(attackDamage.getValue()).isEqualTo(STAT_VALUE);
    }
}
