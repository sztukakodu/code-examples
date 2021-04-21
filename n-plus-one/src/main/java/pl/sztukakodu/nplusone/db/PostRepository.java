package pl.sztukakodu.nplusone.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sztukakodu.nplusone.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p JOIN FETCH p.comments")
    List<Post> findAllJoinComments();


}
