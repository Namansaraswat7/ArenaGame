package lld.game;

import lld.game.entity.Player;
import lld.game.service.ArenaRuleExecutor;
import lld.game.service.ArenaService;
import lld.game.service.PlayerService;

public class GameController {
    public static void main(String[] args) {

        ArenaService gameArena = new ArenaService();

        Player p1 = new Player(1,"Goku",100,5,5);
        Player p2 = new Player(2,"Vgeta",100,5,1);

        PlayerService playerService = new PlayerService();

        playerService.addPlayer(p1);
        playerService.addPlayer(p2);

        gameArena.setPlayerService(playerService);

        Player p =  gameArena.playMatch(p1,p2);

        System.out.println(p.getName() + " has won the match");

   }

}
