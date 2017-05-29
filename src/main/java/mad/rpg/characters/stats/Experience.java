package mad.rpg.characters.stats;

import java.math.BigDecimal;

public class Experience implements Stat<BigDecimal> {

    private BigDecimal defaultStatValue;
    private BigDecimal statValue;

    public Experience(BigDecimal defaultStatValue, BigDecimal statValue) {
        this.defaultStatValue = defaultStatValue;
        this.statValue = statValue;
    }

    @Override
    public StatType getType() {
        return StatType.EXPERIENCE;
    }

    @Override
    public BigDecimal getDefaultValue() {
        return defaultStatValue;
    }

    @Override
    public BigDecimal getValue() {
        return statValue;
    }

    @Override
    public void addValue(BigDecimal addValue) {
        if(addValue == null){
            return;
        }
        statValue = statValue.add(addValue);
    }

    @Override
    public void removeValue(BigDecimal removeValue) {
        if(removeValue == null){
            return;
        }
        statValue = statValue.subtract(removeValue);
    }

}
