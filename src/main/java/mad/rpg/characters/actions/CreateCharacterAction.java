package mad.rpg.characters.actions;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.infos.Name;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.model.Player;
import mad.rpg.characters.stats.*;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateCharacterAction implements Action {

    private CharacterRepository playerRepository;

    public CreateCharacterAction(CharacterRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void process(Context context) {
        UtilLocator.locate().output().printLine(Messages.CREATE_YOUR_CHARACTER);

        List<Info> infos = new ArrayList<>();

        UtilLocator.locate().output().printLine(InfoType.NAME + ":");
        String nameInput = UtilLocator.locate().input().receiveInput();
        infos.add(new Name(nameInput));

        List<Stat> stats = new ArrayList<>();

        stats.add(new Experience(BigDecimal.ZERO, BigDecimal.ZERO));

        UtilLocator.locate().output().printLine(StatType.ATTACK_DAMAGE + ":");
        Integer attackDamageInput = UtilLocator.locate().input().choice(1, 100);
        stats.add(new AttackDamage(attackDamageInput, attackDamageInput));

        UtilLocator.locate().output().printLine(StatType.HEALTH + ":");
        Integer healthInput = UtilLocator.locate().input().choice(1, 100);
        stats.add(new Health(healthInput, healthInput));

        UtilLocator.locate().output().printLine(Messages.SAVE_CHARACTER_PROMPT);
        Boolean saveCharacterPrompt = UtilLocator.locate().input().prompt();

        if(!saveCharacterPrompt){
            context.addEvent(EventType.CHARACTER_NOT_CREATED);
            UtilLocator.locate().output().printLine(Messages.CHARACTER_NOT_ADDED);
            return;
        }

        try {
            playerRepository.add(new Player(infos, stats));
        } catch (FileDeserializationException e) {
            UtilLocator.locate().output().printLine(e.getMessage());
            context.addEvent(EventType.CHARACTER_NOT_CREATED);
            UtilLocator.locate().output().printLine(Messages.CHARACTER_NOT_ADDED);
            return;
        } catch (FileSerializationException e) {
            UtilLocator.locate().output().printLine(e.getMessage());
            context.addEvent(EventType.CHARACTER_NOT_CREATED);
            UtilLocator.locate().output().printLine(Messages.CHARACTER_NOT_ADDED);
            return;
        }

        context.addEvent(EventType.CHARACTER_CREATED);
        UtilLocator.locate().output().printLine(Messages.CHARACTER_ADDED);
    }


}
