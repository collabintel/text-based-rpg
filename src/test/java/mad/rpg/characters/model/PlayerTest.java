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

public class PlayerTest {

    private static final String PLAYER_NAME = "PLAYER_NAME";
    private static final Integer HEALTH = 100;
    private static final Integer ATTACK_DAMAGE = 50;

    private List<Info> infos;

    private List<Stat> stats;

    private Character player;

    @Before
    public void setUp() throws Exception {
        infos = new ArrayList<>();
        infos.add(new Name(PLAYER_NAME));

        stats = new ArrayList<>();
        stats.add(new Health(HEALTH, HEALTH));
        stats.add(new AttackDamage(ATTACK_DAMAGE, ATTACK_DAMAGE));

        player = new Player(infos, stats);
    }

    @Test
    public void should_getSameInfos_when_getInfos() throws Exception {
        List<Info> actualInfos = player.getInfos();
        assertThat(actualInfos).isEqualTo(infos);
    }

    @Test
    public void should_getSameStats_when_getStats() throws Exception {
        List<Stat> actualStats = player.getStats();
        assertThat(actualStats).isEqualTo(stats);
    }

    @Test
    public void should_getSpecificInfo_when_getInfoCalled() throws Exception {
        Optional<Info> info = player.getInfo(InfoType.NAME);
        assertThat(info.get().getValue()).isEqualTo(PLAYER_NAME);
    }

    @Test
    public void should_getSpecificStat_when_getStatCalled() throws Exception {
        Optional<Stat> health = player.getStat(StatType.HEALTH);
        assertThat(health.get().getValue()).isEqualTo(HEALTH);
    }
}
