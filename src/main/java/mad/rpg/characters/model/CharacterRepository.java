package mad.rpg.characters.model;

import mad.rpg.characters.stats.StatType;
import mad.rpg.utils.FileDeserializationException;
import mad.rpg.utils.FileSerializationException;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    CharacterRepository add(Character player) throws FileDeserializationException, FileSerializationException;

    Boolean hasCharacters() throws FileDeserializationException;

    List<Character> characters() throws FileDeserializationException;

    CharacterRepository updateStat(Character player, StatType statType) throws FileDeserializationException, FileSerializationException;

}
