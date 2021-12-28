package pl.sztukakodu.lazyinit.service.ports;

import pl.sztukakodu.lazyinit.domain.Team;

import java.util.List;

public interface ReadTeamUseCase {
    List<Team> getAll();
}
