package lld.game.service;

import lld.game.entity.Player;
import lld.game.exception.ArenaException;

import java.util.Objects;

public class ArenaService {

    ArenaRuleExecutor arenaRuleExecutor = new ArenaRuleExecutor();

    PlayerService playerService = null;

    public ArenaService() {
        this.playerService = new PlayerService();
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player playMatch(Player p1, Player p2) {

        if(Objects.isNull(p1) || Objects.isNull(p2) || Objects.equals(p1,p2)) {
            throw new ArenaException("Players present in arena are either null or equal, hence Match can not be started");
        }

        if(p1.getHealth() == 0 || p1.getStrength() == 0 || p1.getAttack() == 0 || p2.getHealth() == 0 || p2.getStrength() == 0 || p2.getAttack() == 0) {
            throw new ArenaException("Match cannot be started because either P1 or P2 has one of its attributes set to 0");
        }

        Player tossWinner = arenaRuleExecutor.toss() == 1 ? p1 : p2;

        Player firstPlayer = tossWinner;
        Player secondPlayer = tossWinner == p1 ? p2 : p1;

        boolean turn = true;

        while(firstPlayer.getHealth()>0 && secondPlayer.getHealth()>0) {

            int firstPlayerAttack = 0;
            int secondPlayerDefence = 0;
            int firstPlayerDefence = 0;
            int secondPlayerAttack = 0;
            int healthReduceP1 = -1;
            int healthReduceP2 = -1;
            if(turn == true) {
                firstPlayerAttack = arenaRuleExecutor.attack(firstPlayer);
                secondPlayerDefence = arenaRuleExecutor.defend(secondPlayer);
                turn = false;
                healthReduceP1 = -1;
            }
            else {
                secondPlayerAttack = arenaRuleExecutor.attack(secondPlayer);
                firstPlayerDefence = arenaRuleExecutor.defend(firstPlayer);
                turn = true;
                healthReduceP2 = -1;
            }

            if(turn == false) {
                healthReduceP2 = firstPlayerAttack - secondPlayerDefence;
                if(healthReduceP2 > 0)
                    playerService.updateHealth(secondPlayer,healthReduceP2);
            }
            else {
                healthReduceP1 = secondPlayerAttack - firstPlayerDefence;
                if(healthReduceP1 > 0)
                    playerService.updateHealth(firstPlayer,healthReduceP1);
            }
        }

        if(firstPlayer .getHealth() <= 0)
            return secondPlayer;
        else
            return firstPlayer;
    }
}
