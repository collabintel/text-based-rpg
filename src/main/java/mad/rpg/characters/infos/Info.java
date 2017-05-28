package mad.rpg.characters.infos;

import java.io.Serializable;

public interface Info<T> extends Serializable {

    InfoType getType();

    T getValue();
}
