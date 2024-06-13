package lld.game.repository;

import lld.game.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRepositoryImpl implements PlayerRepository{

    Map<Integer, Player> playerMap;

    public PlayerRepositoryImpl() {
        this.playerMap = new HashMap<>();
    }
    @Override
    public void addPlayer(Player p) {
        playerMap.put(p.getId(),p);
    }

    @Override
    public Player searchPlayer(Integer id) {
        return playerMap.get(id);
    }

    @Override
    public void deletePlayer(Player p) {
        playerMap.remove(p.getId());
    }

    @Override
    public List<Player> getAllPlayers() {
        return (List<Player>) playerMap.values();
    }

    @Override
    public void setAbilities(Player p, int health, int strength, int attack) {
        playerMap.get(p.getId()).setAttack(attack);
        playerMap.get(p.getId()).setHealth(health);
        playerMap.get(p.getId()).setStrength(strength);
    }

    @Override
    public int updateHealth(Player p, int damage) {
        int existingHealth = playerMap.get(p.getId()).getHealth();

        playerMap.get(p.getId()).setHealth(existingHealth - damage);

        return playerMap.get(p.getId()).getHealth();
    }
}
