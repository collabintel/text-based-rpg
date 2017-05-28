package mad.rpg.battle.actions;

import mad.rpg.characters.infos.InfoType;
import mad.rpg.characters.model.Character;
import mad.rpg.characters.model.HostileCharacter;
import mad.rpg.characters.stats.Stat;
import mad.rpg.characters.stats.StatType;
import mad.rpg.game.Commands;
import mad.rpg.game.Messages;
import mad.rpg.game.actions.Action;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;
import mad.rpg.utils.UtilLocator;
import mad.rpg.world.model.World;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightAction implements Action {

    Random random;

    public FightAction() {
        random = new Random();
    }

    @Override
    public void process(Context context) {
        World world = context.getWorld();
        HostileCharacter hostileCharacter = world.currentLocation().hostile().get();
        String enemyName = hostileCharacter.getInfo(InfoType.NAME).get().getValue().toString();
        String enemyHealth = hostileCharacter.getStat(StatType.HEALTH).get().getValue().toString();
        UtilLocator.locate().output().printLine(String.format(Messages.YOU_FACE_ENEMY_NAME, enemyName, enemyHealth));
        List<String> commands = new ArrayList<>();
        commands.add(Commands.EXIT);
        commands.add(Commands.FIGHT);
        commands.add(Commands.RUN_AWAY);
        commands.add(Commands.SAVE_GAME);
        while (true){
            UtilLocator.locate().output().printLine(Messages.DO_YOU_WANT_TO_FIGHT_OR_RUN_AWAY);
            String input = UtilLocator.locate().input().receiveInput(commands);
            if(input.equals(Commands.EXIT)){
                context.addEvent(EventType.EXIT_REQUESTED);
                return;
            }
            if(input.equals(Commands.SAVE_GAME)){
                context.addEvent(EventType.SAVE_GAME);
                return;
            }
            if(input.equals(Commands.RUN_AWAY)){
                UtilLocator.locate().output().printLine(String.format(Messages.YOU_RAN_AWAY_FROM_ENEMY, enemyName));
                context.addEvent(EventType.PLAYER_RAN_AWAY);
                return;
            }

            Character player = context.getPlayer();
            Integer maxPlayerAttackDamage = (Integer) player.getStat(StatType.ATTACK_DAMAGE).get().getValue();
            Integer maxHostileAttackDamage = (Integer) hostileCharacter.getStat(StatType.ATTACK_DAMAGE).get().getValue();

            Integer playerDamageDealt = random.nextInt(maxPlayerAttackDamage) + 1;
            Integer hostileDamageDealt = random.nextInt(maxHostileAttackDamage) + 1;

            UtilLocator.locate().output().printLine(String.format(Messages.YOU_LOST_HEALTH, hostileDamageDealt));
            UtilLocator.locate().output().printLine(String.format(Messages.YOU_DEALT_DAMAGE_TO_ENEMEY, playerDamageDealt));

            player.getStat(StatType.HEALTH).get().removeValue(hostileDamageDealt);
            hostileCharacter.getStat(StatType.HEALTH).get().removeValue(playerDamageDealt);

            Integer playerLastHealth = (Integer) player.getStat(StatType.HEALTH).get().getValue();
            Integer hostileLastHealth = (Integer) hostileCharacter.getStat(StatType.HEALTH).get().getValue();

            if(playerLastHealth <= 0){
                UtilLocator.locate().output().printLine(String.format(Messages.YOU_ARE_DEFEATED_BY_ENEMY, enemyName));
                context.addEvent(EventType.PLAYER_DEFEATED);
                return;
            }
            if(hostileLastHealth <= 0){
                BigDecimal experienceCoefficient = (BigDecimal) hostileCharacter.getStat(StatType.EXPERIENCE_COEFFICIENT).get().getValue();
                Stat experienceStat = player.getStat(StatType.EXPERIENCE).get();
                experienceStat.addValue(experienceCoefficient);
                String experience = experienceStat.getValue().toString();

                UtilLocator.locate().output().printLine(String.format(Messages.YOU_DEFEATED_ENEMY, enemyName));
                UtilLocator.locate().output().printLine(String.format(Messages.YOU_GAINED_EXPERIENCE, experienceCoefficient, experience));
                UtilLocator.locate().output().printLine(String.format(Messages.YOU_HAVE_HEALTH, playerLastHealth));
                context.addEvent(EventType.ENEMY_DEFEATED);
                return;
            }
        }
    }

}
