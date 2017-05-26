package mad.rpg.characters.stats;

public interface Stat<T> {

    StatType getType();

    T getDefaultValue();

    T getValue();

    void addValue(T addValue);

    void removeValue(T removeValue);

}
