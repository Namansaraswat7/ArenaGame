package lld.game.repository;

import lld.game.entity.Player;

import java.util.List;

public interface PlayerRepository {

    void addPlayer(Player p);

    Player searchPlayer(Integer id);

    void deletePlayer(Player p);

    List<Player> getAllPlayers();

    void setAbilities(Player p, int health, int strength, int attack);

    int updateHealth(Player p,int damage);

}
