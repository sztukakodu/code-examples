package pl.sztukakodu.nplusone.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sztukakodu.nplusone.domain.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(attributePaths = {"post"})
    List<Comment> findAllBy();

    @EntityGraph(attributePaths = {"post"})
    Page<Comment> findAllBy(Pageable pageable);

}
