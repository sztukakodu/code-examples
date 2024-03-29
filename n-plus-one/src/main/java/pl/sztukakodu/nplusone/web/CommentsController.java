package pl.sztukakodu.nplusone.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sztukakodu.nplusone.application.CommentsService;
import pl.sztukakodu.nplusone.domain.Comment;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
class CommentsController {

    private final CommentsService service;

    @GetMapping
    public List<Comment> getAll() {
        return service.getAll();
    }

    @GetMapping("/page")
    public Page<Comment> getPaged(Pageable pageable) {
        return service.getPage(pageable);
    }


}
