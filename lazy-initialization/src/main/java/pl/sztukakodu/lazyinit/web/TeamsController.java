package pl.sztukakodu.lazyinit.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sztukakodu.lazyinit.domain.Team;
import pl.sztukakodu.lazyinit.service.ports.ReadTeamUseCase;

import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
class TeamsController {
    private final ReadTeamUseCase readTeam;

    @RequestMapping
    public List<Team> getAll() {
        return readTeam.getAll();
    }

}
