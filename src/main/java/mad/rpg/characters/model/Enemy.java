package mad.rpg.characters.model;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;

import java.util.List;
import java.util.Optional;

public class Enemy implements HostileCharacter {

    private List<Info> infos;
    private List<Stat> stats;

    public Enemy(List<Info> infos, List<Stat> stats) {
        this.infos = infos;
        this.stats = stats;
    }

    @Override
    public List<Info> getInfos() {
        return infos;
    }

    @Override
    public List<Stat> getStats() {
        return stats;
    }

    @Override
    public Optional<Info> getInfo(InfoType infoType) {
        return infos
                .stream()
                .filter(info -> info
                        .getType()
                        .equals(infoType))
                .findFirst();
    }

    @Override
    public Optional<Stat> getStat(StatType statType) {
        return stats
                .stream()
                .filter(stat -> stat
                        .getType()
                        .equals(statType))
                .findFirst();
    }

}
