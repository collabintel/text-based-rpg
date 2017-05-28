package mad.rpg.characters.stats;

import java.math.BigDecimal;

public class ExperienceCoefficient implements Stat<java.math.BigDecimal> {

    private BigDecimal defaultStatValue;
    private BigDecimal statValue;

    public ExperienceCoefficient(BigDecimal defaultStatValue, BigDecimal statValue) {
        this.defaultStatValue = defaultStatValue;
        this.statValue = statValue;
    }

    @Override
    public StatType getType() {
        return StatType.EXPERIENCE_COEFFICIENT;
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
        // Do Nothing
    }

    @Override
    public void removeValue(BigDecimal removeValue) {
        // Do Nothing
    }
}
