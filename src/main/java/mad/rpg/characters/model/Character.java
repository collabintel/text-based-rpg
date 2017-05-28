package mad.rpg.characters.model;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Character extends Serializable {

    List<Info> getInfos();

    List<Stat> getStats();

    Optional<Info> getInfo(InfoType infoType);

    Optional<Stat> getStat(StatType statType);
}
