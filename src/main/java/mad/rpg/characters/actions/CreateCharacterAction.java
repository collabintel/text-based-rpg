package mad.rpg.characters.actions;

import mad.rpg.characters.infos.Info;
import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.infos.Name;
import mad.rpg.characters.model.CharacterRepository;
import mad.rpg.characters.model.Player;
import mad.rpg.characters.stats.AttackDamage;
import mad.rpg.characters.stats.Health;
import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.Input;
import mad.rpg.utils.Output;
import mad.rpg.utils.UtilLocator;

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

        playerRepository.add(new Player(infos, stats));

        context.addEvent(EventType.CHARACTER_CREATED);
        UtilLocator.locate().output().printLine(Messages.CHARACTER_ADDED);
    }


}
