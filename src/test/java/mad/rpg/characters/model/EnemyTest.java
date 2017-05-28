package mad.rpg.characters.model;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.infos.Name;
import mad.rpg.characters.stats.AttackDamage;
import mad.rpg.characters.stats.Health;
import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyTest {

    private static final String ENEMY_NAME = "ENEMY_NAME";
    private static final Integer HEALTH = 100;
    private static final Integer ATTACK_DAMAGE = 50;

    private List<Info> infos;

    private List<Stat> stats;

    private HostileCharacter enemy;

    @Before
    public void setUp() throws Exception {
        infos = new ArrayList<>();
        infos.add(new Name(ENEMY_NAME));

        stats = new ArrayList<>();
        stats.add(new Health(HEALTH, HEALTH));
        stats.add(new AttackDamage(ATTACK_DAMAGE, ATTACK_DAMAGE));

        enemy = new Enemy(infos, stats);
    }

    @Test
    public void should_getSameInfos_when_getInfos() throws Exception {
        List<Info> actualInfos = enemy.getInfos();
        assertThat(actualInfos).isEqualTo(infos);
    }

    @Test
    public void should_getSameStats_when_getStats() throws Exception {
        List<Stat> actualStats = enemy.getStats();
        assertThat(actualStats).isEqualTo(stats);
    }

    @Test
    public void should_getSpecificInfo_when_getInfoCalled() throws Exception {
        Optional<Info> info = enemy.getInfo(InfoType.NAME);
        assertThat(info.get().getValue()).isEqualTo(ENEMY_NAME);
    }

    @Test
    public void should_getSpecificStat_when_getStatCalled() throws Exception {
        Optional<Stat> health = enemy.getStat(StatType.HEALTH);
        assertThat(health.get().getValue()).isEqualTo(HEALTH);
    }

}
