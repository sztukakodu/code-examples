package pl.sztukakodu.lazyinit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sztukakodu.lazyinit.db.TeamRepository;
import pl.sztukakodu.lazyinit.domain.Player;
import pl.sztukakodu.lazyinit.domain.Team;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@AllArgsConstructor
class AppConfiguration {
    private final TeamRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        repository.save(new Team(
            "FC Bayern",
            Set.of(
                new Player("Robert Lewandowski", "Poland"),
                new Player("Manuel Neuer", "Germany"),
                new Player("Thomas Muller", "Germany")
            )
        ));
        repository.save(new Team(
            "Paris Saint Germain",
            Set.of(
                new Player("Kylian Mbappe", "France"),
                new Player("Lionel Messi", "Argentina"),
                new Player("Neymar Junior", "Brazil")
            )
        ));
    }
}
