package mad.rpg.characters.model;

import mad.rpg.characters.generators.EnemyNameGenerator;
import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.Name;
import mad.rpg.characters.stats.AttackDamage;
import mad.rpg.characters.stats.ExperienceCoefficient;
import mad.rpg.characters.stats.Health;
import mad.rpg.characters.stats.Stat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyCreator implements HostileCharacterCreator {

    private EnemyNameGenerator enemyNameGenerator;
    private Random random;

    public EnemyCreator() {
        enemyNameGenerator = new EnemyNameGenerator();
        random = new Random();
    }

    @Override
    public HostileCharacter create() {
        List<Info> infos = new ArrayList<>();
        infos.add(new Name(enemyNameGenerator.generateName()));
        List<Stat> stats = new ArrayList<>();
        Integer attackDamage = random.nextInt(26) + 25;
        stats.add(new AttackDamage(attackDamage, attackDamage));
        Integer health = random.nextInt(26) + 50;
        stats.add(new Health(health, health));
        BigDecimal experienceCoefficient = new BigDecimal(String.valueOf(random.nextDouble() * 2));
        experienceCoefficient = experienceCoefficient.setScale(2, RoundingMode.HALF_EVEN);
        stats.add(new ExperienceCoefficient(experienceCoefficient, experienceCoefficient));

        HostileCharacter enemy = new Enemy(infos, stats);
        return enemy;
    }

}
