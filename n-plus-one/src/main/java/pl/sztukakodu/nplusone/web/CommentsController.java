package pl.sztukakodu.nplusone.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Comment> getAll(@RequestParam(defaultValue = "false") boolean eager) {
        if (eager) {
            return service.getAllEager();
        } else {
            return service.getAll();
        }
    }

    @GetMapping("/paged")
    public Page<Comment> getPage(Pageable pageable) {
        return service.getPage(pageable);
    }

}
