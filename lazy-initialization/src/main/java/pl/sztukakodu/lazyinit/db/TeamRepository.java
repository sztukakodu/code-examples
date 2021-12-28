package pl.sztukakodu.lazyinit.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sztukakodu.lazyinit.domain.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {
    @Query("SELECT t FROM Team t JOIN FETCH t.players")
    List<Team> findAllWithPlayers();
}
