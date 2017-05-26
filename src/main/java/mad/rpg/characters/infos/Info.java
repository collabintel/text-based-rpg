package mad.rpg.characters.infos;

public interface Info<T> {

    InfoType getType();

    T getValue();
}
