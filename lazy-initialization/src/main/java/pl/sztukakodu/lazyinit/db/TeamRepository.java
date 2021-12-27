package pl.sztukakodu.lazyinit.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sztukakodu.lazyinit.domain.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
}
