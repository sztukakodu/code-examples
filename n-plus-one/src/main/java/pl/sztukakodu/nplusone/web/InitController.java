package pl.sztukakodu.nplusone.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sztukakodu.nplusone.application.InitService;
import pl.sztukakodu.nplusone.domain.Post;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/init")
class InitController {

    private final InitService service;

    @PostMapping
    public void init() {
        service.init(10, 25);
    }

}
