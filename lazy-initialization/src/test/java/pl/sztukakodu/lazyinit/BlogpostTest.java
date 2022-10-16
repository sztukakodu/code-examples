package pl.sztukakodu.lazyinit;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BlogpostTest {

    @Autowired
    BlogpostRepository repository;

    @BeforeEach
    public void setup() {
        Set<Comment> comments = Set.of(
            new Comment(1L, "Frodo Baggins", "One To Rule Them All!")
        );
        Blogpost blogpost = new Blogpost(1L, "Atlas Shrugged", "Who is John Galt?", comments);
        repository.save(blogpost);
    }

    @Test
    void throwsLazyInitException() {
        // when
        Blogpost blogpost = repository.findById(1L).get();

        // then
        assertThrows(
            LazyInitializationException.class,
            () -> blogpost.getComments().size()
        );
    }

    @Test
    @Transactional
    void fetchesBlogpostWithCommentsInTransaction() {
        // when
        Blogpost blogpost = repository.getById(1L);

        // then
        assertEquals(1, blogpost.getComments().size());
    }

    @Test
    void fetchesBlogpostWithCommentsInSingleCall() {
        // when
        Blogpost blogpost = repository.getByIdWithComments(1L);

        // then
        assertEquals(1, blogpost.getComments().size());
    }

    @Test
    void fetchesBlogpostWithCommentsGraph() {
        // when
        Blogpost blogpost = repository.getBlogpostGraphById(1L);

        // then
        assertEquals(1, blogpost.getComments().size());
    }

    @Test
    void fetchesBlogpostWithCommentsNamedGraph() {
        // when
        Blogpost blogpost = repository.getBlogpostNamedGraphById(1L);

        // then
        assertEquals(1, blogpost.getComments().size());
    }

    @Test
    void fetchesCommentsEagerly() {
        // when
        Blogpost blogpost = repository.findById(1L).get();

        // then
        assertEquals(1, blogpost.getComments().size());
    }
}
