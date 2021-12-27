package pl.sztukakodu.lazyinit.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sztukakodu.lazyinit.domain.Team;
import pl.sztukakodu.lazyinit.service.ports.ReadTeamUseCase;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
class TeamController {
    private final ReadTeamUseCase readTeam;

    @RequestMapping
    public Optional<Team> getByName(@RequestParam String name) {
        return readTeam.findByName(name);
    }

    @PostMapping
    public void createTeam(@RequestBody CreateTeamRequest request) {
        // TODO-Darek:
    }

    record CreateTeamRequest(String name, Set<PlayerDto> player) {
    }

    record PlayerDto(String name, String country) {
    }
}
