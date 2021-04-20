package pl.sztukakodu.nplusone.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sztukakodu.nplusone.application.PostsService;
import pl.sztukakodu.nplusone.domain.Post;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
class PostsController {

    private final PostsService postsService;

    @PostMapping
    public void init() {
        postsService.init(10, 25);
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable Long id) {
        return postsService.getById(id);
    }
}
