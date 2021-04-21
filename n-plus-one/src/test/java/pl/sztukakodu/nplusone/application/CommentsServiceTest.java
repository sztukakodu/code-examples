package pl.sztukakodu.nplusone.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sztukakodu.nplusone.domain.Comment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest("hibernate.query.interceptor.error-level=EXCEPTION")
class CommentsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    CommentsService service;

    @Test
    public void shouldThrowNPlusOneException() {
        // given
        postsService.init(10, 25);

        // when
        List<Comment> all = service.getAll();
        
        // then
        assertEquals(10, all.size());
    }

}
