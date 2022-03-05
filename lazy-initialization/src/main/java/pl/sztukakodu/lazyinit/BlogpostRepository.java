package pl.sztukakodu.lazyinit;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {
    @Query("SELECT b FROM Blogpost b JOIN FETCH b.comments WHERE b.id = :id")
    Blogpost getByIdWithComments(@Param("id") Long id);

    @EntityGraph(attributePaths = {"comments"})
    Blogpost getBlogpostGraphById(Long id);

    @EntityGraph("Blogpost.comments")
    Blogpost getBlogpostNamedGraphById(Long id);
}
