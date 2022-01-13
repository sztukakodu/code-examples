package pl.sztukakodu.lazyinit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {
    @Query("SELECT b FROM Blogpost b JOIN FETCH b.comments")
    List<Blogpost> findAllWithComments();
}
