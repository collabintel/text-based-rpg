package mad.rpg.characters.stats;

import java.io.Serializable;

public interface Stat<T> extends Serializable {

    StatType getType();

    T getDefaultValue();

    T getValue();

    void addValue(T addValue);

    void removeValue(T removeValue);

}
