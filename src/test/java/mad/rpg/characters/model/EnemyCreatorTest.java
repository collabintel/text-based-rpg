package mad.rpg.characters.model;

import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.stats.StatType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyCreatorTest {

    HostileCharacterCreator enemyCreator;

    @Before
    public void setUp() throws Exception {
        enemyCreator = new EnemyCreator();
    }

    @Test
    public void should_createEnemy_when_createCalled() throws Exception {
        HostileCharacter enemy = enemyCreator.create();

        assertThat(enemy).isNotNull().isInstanceOf(Enemy.class);
        assertThat(enemy.getInfo(InfoType.NAME).get().getValue().toString()).isNotBlank();
        assertThat((Integer) enemy.getStat(StatType.ATTACK_DAMAGE).get().getValue()).isGreaterThanOrEqualTo(25).isLessThanOrEqualTo(50);
        assertThat((Integer) enemy.getStat(StatType.HEALTH).get().getValue()).isGreaterThanOrEqualTo(50).isLessThanOrEqualTo(75);
        assertThat((BigDecimal) enemy.getStat(StatType.EXPERIENCE_COEFFICIENT).get().getValue()).isGreaterThanOrEqualTo(BigDecimal.ZERO).isLessThanOrEqualTo(new BigDecimal("2"));
    }
}
