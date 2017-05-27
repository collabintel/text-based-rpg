package mad.rpg.world.model;

public class Room implements Location {

    private Integer x;
    private Integer y;

    public Room(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }
}
