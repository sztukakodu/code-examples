package pl.sztukakodu.nplusone.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sztukakodu.nplusone.application.PostsService;
import pl.sztukakodu.nplusone.domain.Post;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
class PostsController {

    private final PostsService postsService;

    @GetMapping
    public List<Post> getPosts(@RequestParam(defaultValue = "false") boolean eager) {
        return postsService.findAll(eager);
    }
}
