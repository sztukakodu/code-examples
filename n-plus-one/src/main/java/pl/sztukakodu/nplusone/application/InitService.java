package pl.sztukakodu.nplusone.application;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.nplusone.db.PostRepository;
import pl.sztukakodu.nplusone.domain.Comment;
import pl.sztukakodu.nplusone.domain.Post;

@Service
@AllArgsConstructor
public class InitService {
    private final PostRepository repository;

    public void init(int posts, int comments) {
        Faker faker = new Faker();
        for (int i = 0; i < posts; i++) {
            var post = new Post();
            post.setContent(faker.lorem().paragraph());
            for (int j = 0; j < comments; j++) {
                var comment = new Comment();
                comment.setComment(faker.chuckNorris().fact());
                post.addComment(comment);
            }
            repository.save(post);
        }
    }

    public void clear() {
        repository.deleteAll();
    }
}
