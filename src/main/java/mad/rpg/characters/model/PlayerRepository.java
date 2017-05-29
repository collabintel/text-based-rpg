package mad.rpg.characters.model;

import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.FileNames;
import mad.rpg.game.saves.SaveGame;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.FileSerializationException;
import mad.rpg.utils.UtilLocator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerRepository implements CharacterRepository {

    @Override
    public CharacterRepository add(Character player) throws FileDeserializationException, FileSerializationException {
        List<Character> characters = new ArrayList<>();
        if(hasCharacters()){
            characters = characters();
        }
        characters.add(player);
        UtilLocator.locate().fileSerializer().write(characters, FileNames.CHARACTER);
        return this;
    }

    @Override
    public Boolean hasCharacters() throws FileDeserializationException {
        Boolean fileExists = UtilLocator.locate().fileUtil().exists(FileNames.CHARACTER);
        return fileExists ? UtilLocator.locate().fileDeserializer().read(List.class, FileNames.CHARACTER).size() > 0 : false;
    }

    @Override
    public List<Character> characters() throws FileDeserializationException {
        return UtilLocator.locate().fileDeserializer().read(List.class, FileNames.CHARACTER);
    }

    @Override
    public CharacterRepository updateStat(Character player, StatType statType) throws FileDeserializationException, FileSerializationException {
        List<Character> characters = new ArrayList<>();
        if(hasCharacters()){
            characters = characters();
        }
        characters
                .stream()
                .filter(character -> character.id().equals(player.id()))
                .forEach(character -> {
                    Optional<Stat> stat = character.getStat(statType);
                    if(stat.isPresent()){
                        stat.get().removeValue(stat.get().getValue());
                        stat.get().addValue(player.getStat(statType).get().getValue());
                    }
                });
        UtilLocator.locate().fileSerializer().write(characters, FileNames.CHARACTER);
        return this;
    }

}
