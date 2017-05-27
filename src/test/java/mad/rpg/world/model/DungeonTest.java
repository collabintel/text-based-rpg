package mad.rpg.world.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DungeonTest {

    World dungeon;

    Location[][] locations;

    Location startRoom;

    Location northRoom;

    Location eastRoom;

    Location lastEastRoom;

    @Before
    public void setUp() throws Exception {
        locations = new Room[3][2];
        startRoom = new Room(0, 0);
        locations[startRoom.getX()][startRoom.getY()] = startRoom;
        northRoom = new Room(0, 1);
        locations[northRoom.getX()][northRoom.getY()] = northRoom;
        eastRoom = new Room(1, 0);
        locations[eastRoom.getX()][eastRoom.getY()] = eastRoom;
        lastEastRoom = new Room(2, 0);
        locations[lastEastRoom.getX()][lastEastRoom.getY()] = lastEastRoom;
        locations[1][1] = new Room(1, 1);
        dungeon = new Dungeon(locations);
    }

    @Test
    public void should_getLocations_when_locationsCalled() throws Exception {
        Location[][] locations = dungeon.locations();

        assertThat(locations).isEqualTo(locations);
    }

    @Test
    public void should_getCurrentLocation_when_currentLocationCalled() throws Exception {
        Location location = dungeon.currentLocation();

        assertThat(location).isEqualTo(startRoom);
    }

    @Test
    public void should_changeCurrentLocationToNorthRoom_when_changeLocationWithNorthDirectionCalled() throws Exception {
        Boolean result = dungeon.changeLocation(Directions.NORTH);
        Location currentLocation = dungeon.currentLocation();

        assertThat(result).isEqualTo(true);
        assertThat(currentLocation).isEqualTo(northRoom);
    }

    @Test
    public void should_changeCurrentLocationToEastRoom_when_changeLocationWithEastDirectionsCalled() throws Exception {
        Boolean result = dungeon.changeLocation(Directions.EAST);
        Location currentLocation = dungeon.currentLocation();

        assertThat(result).isEqualTo(true);
        assertThat(currentLocation).isEqualTo(eastRoom);
    }

    @Test
    public void should_cantChangeCurrentLocationToWest_when_changeLocationWithWestDirectionsCalled() throws Exception {
        Boolean result = dungeon.changeLocation(Directions.WEST);
        Location currentLocation = dungeon.currentLocation();

        assertThat(result).isEqualTo(false);
        assertThat(currentLocation).isEqualTo(startRoom);
    }

    @Test
    public void should_changeCurrentLocationToEastRoomAndBack_when_changeLocationWithEastAndWestDirectionsCalled() throws Exception {
        Boolean resultEast = dungeon.changeLocation(Directions.EAST);
        Boolean resultWest = dungeon.changeLocation(Directions.WEST);
        Location currentLocation = dungeon.currentLocation();

        assertThat(resultEast).isEqualTo(true);
        assertThat(resultWest).isEqualTo(true);
        assertThat(currentLocation).isEqualTo(startRoom);
    }

    @Test
    public void should_cantChangeCurrentLocationToSouth_when_changeLocationWithSouthDirectionsCalled() throws Exception {
        Boolean result = dungeon.changeLocation(Directions.SOUTH);
        Location currentLocation = dungeon.currentLocation();

        assertThat(result).isEqualTo(false);
        assertThat(currentLocation).isEqualTo(startRoom);
    }

    @Test
    public void should_changeCurrentLocationTNorthRoomAndBack_when_changeLocationWithNorthAndSouthDirectionsCalled() throws Exception {
        Boolean resultNorth = dungeon.changeLocation(Directions.NORTH);
        Boolean resultSouth = dungeon.changeLocation(Directions.SOUTH);
        Location currentLocation = dungeon.currentLocation();

        assertThat(resultNorth).isEqualTo(true);
        assertThat(resultSouth).isEqualTo(true);
        assertThat(currentLocation).isEqualTo(startRoom);
    }

    @Test
    public void should_cantChangeCurrentLocationToNorthTwice_when_changeLocationWithNorthDirectionsCalledTwice() throws Exception {
        Boolean resultOne = dungeon.changeLocation(Directions.NORTH);
        Boolean resultTwo = dungeon.changeLocation(Directions.NORTH);
        Location currentLocation = dungeon.currentLocation();

        assertThat(resultOne).isEqualTo(true);
        assertThat(resultTwo).isEqualTo(false);
        assertThat(currentLocation).isEqualTo(northRoom);
    }

    @Test
    public void should_cantChangeCurrentLocationToEastThrice_when_changeLocationWithEastDirectionsCalledThrice() throws Exception {
        Boolean resultOne = dungeon.changeLocation(Directions.EAST);
        Boolean resultTwo = dungeon.changeLocation(Directions.EAST);
        Boolean resultThree = dungeon.changeLocation(Directions.EAST);
        Location currentLocation = dungeon.currentLocation();

        assertThat(resultOne).isEqualTo(true);
        assertThat(resultTwo).isEqualTo(true);
        assertThat(resultThree).isEqualTo(false);
        assertThat(currentLocation).isEqualTo(lastEastRoom);
    }

    @Test
    public void should_getOne_when_currentLocationIndexCalledInTheStartRoom() throws Exception {
        Integer index = dungeon.currentLocationIndex();

        assertThat(index).isEqualTo(1);
    }

    @Test
    public void should_getThree_when_currentLocationIndexCalledInTheLastEastRoom() throws Exception {
        dungeon.changeLocation(Directions.EAST);
        dungeon.changeLocation(Directions.EAST);
        Integer index = dungeon.currentLocationIndex();

        assertThat(index).isEqualTo(3);
    }

    @Test
    public void should_getFive_when_currentLocationIndexCalledInTheMiddleRoom() throws Exception {
        dungeon.changeLocation(Directions.EAST);
        dungeon.changeLocation(Directions.NORTH);
        Integer index = dungeon.currentLocationIndex();

        assertThat(index).isEqualTo(5);
    }
}
