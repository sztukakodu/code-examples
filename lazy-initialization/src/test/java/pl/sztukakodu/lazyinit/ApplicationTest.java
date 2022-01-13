package pl.sztukakodu.lazyinit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTest {

    @Autowired
    BlogpostRepository repository;

    @BeforeEach
    public void setup() {
        Set<Comment> comments = Set.of(
            new Comment(1L, "Frodo Baggins", "One To Rule Them All!")
        );
        Blogpost blogpost = new Blogpost(1L, "Who is John Galt?", "Lorem Ipsum", comments);
        repository.save(blogpost);
    }

    @Test
    void throwsLazyInitException() {
        // when
        Blogpost blogpost = repository.getById(1L);

        // then
        assertEquals(1, blogpost.getComments().size());
    }

}
