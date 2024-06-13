package lld.game.service;

import lld.game.entity.Player;
import lld.game.exception.PlayerNotFoundException;
import lld.game.repository.PlayerRepository;
import lld.game.repository.PlayerRepositoryImpl;

import java.util.List;
import java.util.Objects;

public class PlayerService {

    PlayerRepository playerRepository = new PlayerRepositoryImpl();

    public void addPlayer(Player p) {
        if(Objects.nonNull(p)){
            playerRepository.addPlayer(p);
        }
        else {
            throw new PlayerNotFoundException("null object is passed");
        }
    }

    public Player searchPlayer(Integer id) {
           Player p = playerRepository.searchPlayer(id);
           if(Objects.isNull(p)){
               throw new PlayerNotFoundException("Player is not present in player list");
           }
           return p;

    }

    public void deletePlayer(Player p) {
        if(Objects.nonNull(p)) {
            Player player = playerRepository.searchPlayer(p.getId());
            if(Objects.nonNull(player)){
                playerRepository.deletePlayer(p);
            }
            else {
                throw new PlayerNotFoundException("Player not found");
            }
        }
    }

    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    public void setPlayerAbilities(Player p, int health, int strength, int attack) {
        if(Objects.nonNull(p)) {
            playerRepository.setAbilities(p,health,strength,attack);
        }
    }

    public int updateHealth(Player p, int damage) {
        if(Objects.nonNull(p)){
           return playerRepository.updateHealth(p,damage);
        }
        throw  new PlayerNotFoundException("Player not found");
    }




}
