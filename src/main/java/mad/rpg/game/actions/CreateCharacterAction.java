package mad.rpg.game.actions;

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
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.Input;
import mad.rpg.utils.Output;

import java.util.ArrayList;
import java.util.List;

public class CreateCharacterAction implements Action {

    private CharacterRepository playerRepository;

    public CreateCharacterAction(CharacterRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void process(Context context) {
        Output.getInstance().printLine(Messages.CREATE_YOUR_CHARACTER);

        List<Info> infos = new ArrayList<>();

        Output.getInstance().printLine(InfoType.NAME + ":");
        String nameInput = Input.getInstance().receiveInput();
        infos.add(new Name(nameInput));

        List<Stat> stats = new ArrayList<>();

        Output.getInstance().printLine(StatType.ATTACK_DAMAGE + ":");
        Integer attackDamageInput = Input.getInstance().choice(1, 100);
        stats.add(new AttackDamage(attackDamageInput, attackDamageInput));

        Output.getInstance().printLine(StatType.HEALTH + ":");
        Integer healthInput = Input.getInstance().choice(1, 100);
        stats.add(new Health(healthInput, healthInput));

        Output.getInstance().printLine(Messages.SAVE_CHARACTER_PROMPT);
        Boolean saveCharacterPrompt = Input.getInstance().prompt();

        if(!saveCharacterPrompt){
            context.addEvent(EventType.CHARACTER_NOT_CREATED);
            Output.getInstance().printLine(Messages.CHARACTER_NOT_ADDED);
            return;
        }

        playerRepository.add(new Player(infos, stats));

        context.addEvent(EventType.CHARACTER_CREATED);
        Output.getInstance().printLine(Messages.CHARACTER_ADDED);
    }


}
