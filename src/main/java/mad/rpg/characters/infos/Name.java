package mad.rpg.characters.infos;

public class Name implements Info<String> {

    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public InfoType getType() {
        return InfoType.NAME;
    }

    @Override
    public String getValue() {
        return name;
    }
}
