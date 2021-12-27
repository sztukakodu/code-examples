package pl.sztukakodu.lazyinit.service.ports;

import pl.sztukakodu.lazyinit.domain.Player;

import java.util.Set;

public interface CreateTeamService {
    void createTeam(String name, Set<Player> players);
}
