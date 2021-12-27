package pl.sztukakodu.lazyinit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.lazyinit.db.TeamRepository;
import pl.sztukakodu.lazyinit.domain.Player;
import pl.sztukakodu.lazyinit.domain.Team;
import pl.sztukakodu.lazyinit.service.ports.CreateTeamService;
import pl.sztukakodu.lazyinit.service.ports.ReadTeamUseCase;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
class TeamService implements CreateTeamService, ReadTeamUseCase {
    private final TeamRepository teamRepository;

    @Override
    public void createTeam(String name, Set<Player> players) {
        // TODO-Darek:
    }

    @Override
    public Optional<Team> findByName(String name) {
        // TODO-Darek:
        return null;
    }
}
