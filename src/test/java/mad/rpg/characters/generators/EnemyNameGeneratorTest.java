package mad.rpg.characters.generators;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnemyNameGeneratorTest {

    EnemyNameGenerator enemyNameGenerator;

    @Before
    public void setUp() throws Exception {
        enemyNameGenerator = new EnemyNameGenerator();
    }

    @Test
    public void should_generateRandomName_when_generateNameCalled() throws Exception {
        String name = enemyNameGenerator.generateName();

        assertThat(name).isNotBlank();
    }
}
