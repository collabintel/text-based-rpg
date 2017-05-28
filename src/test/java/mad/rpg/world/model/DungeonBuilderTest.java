package mad.rpg.world.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DungeonBuilderTest {

    WorldBuilder worldBuilder;

    @Before
    public void setUp() throws Exception {
        worldBuilder = new DungeonBuilder();
    }

    @Test
    public void should_buildDungeon_when_buildCalled() throws Exception {
        World world = worldBuilder.build();

        Location[][] locations = world.locations();


        assertThat(locations.length).isGreaterThanOrEqualTo(5).isLessThanOrEqualTo(10);
        for (Location[] locationArray : locations) {
            assertThat(locationArray.length).isGreaterThanOrEqualTo(5).isLessThanOrEqualTo(10);
            assertThat(locationArray).doesNotContainNull();
        }
    }
}
