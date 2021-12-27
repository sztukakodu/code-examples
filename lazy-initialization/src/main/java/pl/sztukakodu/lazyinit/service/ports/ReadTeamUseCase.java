package pl.sztukakodu.lazyinit.service.ports;

import pl.sztukakodu.lazyinit.domain.Team;

import java.util.Optional;

public interface ReadTeamUseCase {
    Optional<Team> findByName(String name);
}
