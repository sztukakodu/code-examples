package pl.sztukakodu.lazyinit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.lazyinit.db.TeamRepository;
import pl.sztukakodu.lazyinit.domain.Team;
import pl.sztukakodu.lazyinit.service.ports.ReadTeamUseCase;

import java.util.List;

@Service
@AllArgsConstructor
class TeamService implements ReadTeamUseCase {
    private final TeamRepository teamRepository;

    @Override
    public List<Team> getAll() {
        return teamRepository.findAllWithPlayers();
    }
}
