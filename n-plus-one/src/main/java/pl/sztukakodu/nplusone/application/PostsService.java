package pl.sztukakodu.nplusone.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.nplusone.db.PostRepository;
import pl.sztukakodu.nplusone.domain.Post;

import java.util.List;

@Service
@AllArgsConstructor
public class PostsService {
    private final PostRepository repository;

    public List<Post> findAll(boolean eager) {
        if(eager) {
            return repository.findAllEager();
        } else {
            return repository.findAll();
        }
    }
}
