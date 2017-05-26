package mad.rpg.characters.stats;

public class AttackDamage implements Stat<Integer> {

    private Integer defaultStatValue;
    private Integer statValue;

    public AttackDamage(Integer defaultStatValue, Integer statValue) {
        this.defaultStatValue = defaultStatValue;
        this.statValue = statValue;
    }

    @Override
    public StatType getType() {
        return StatType.ATTACK_DAMAGE;
    }

    @Override
    public Integer getDefaultValue() {
        return defaultStatValue;
    }

    @Override
    public Integer getValue() {
        return statValue;
    }

    @Override
    public void addValue(Integer addValue) {
        if(addValue == null){
            return;
        }
        statValue += addValue;
    }

    @Override
    public void removeValue(Integer removeValue) {
        if(removeValue == null){
            return;
        }
        statValue -= removeValue;
    }

}
