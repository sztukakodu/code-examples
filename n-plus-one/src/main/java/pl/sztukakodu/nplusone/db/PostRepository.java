package pl.sztukakodu.nplusone.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sztukakodu.nplusone.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
