package lld.game.service;

import lld.game.entity.Player;

import java.util.Random;

public class ArenaRuleExecutor {
    private Random random = new Random();



    public int toss(){
        return random.nextInt(2);
    }
    public int diceRoll(){
        return random.nextInt(6)+1;
    }

    public int attack(Player p) {
        int diceRollValue = this.diceRoll();
        int attack = p.getAttack();

        int finalAttack = attack*diceRollValue;

        return finalAttack;
    }

    public int defend(Player p) {
        int diceRollValue = this.diceRoll();

        int defend = p.getStrength();
        int finalDefend = defend*diceRollValue;

        return finalDefend;
    }

}
