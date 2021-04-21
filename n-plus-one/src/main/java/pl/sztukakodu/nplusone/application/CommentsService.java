package pl.sztukakodu.nplusone.application;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sztukakodu.nplusone.db.CommentsRepository;
import pl.sztukakodu.nplusone.domain.Comment;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentsService {
    private final CommentsRepository repository;

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public Page<Comment> getPage(Pageable pageable) {
        return repository.findAllBy(pageable);
    }
}
