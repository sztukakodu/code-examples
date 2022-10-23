package pl.sztukakodu.springrest.courses;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
class CoursesController {

    private final CoursesRepository repository;

    // TODO-Darek: add nice response envelope
    @GetMapping
    public List<Course> index() {
        return repository.index();
    }

    @PutMapping("/{id}")
    public String update() {
        return "not yet implemented";
    }
}
