package pl.sztukakodu.springrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/courses")
class CoursesController {

    private final Map<Long, Course> courses = Map.of(
        1L, new Course("Szkoła Springa"),
        2L, new Course("Szkoła Monitoringu"),
        3L, new Course("Kurs Współbieżności")
    );

    @GetMapping
    public Map<Long, Course> index() {
        return courses;
    }

    @PutMapping("/{id}")
    public String update() {
        return "not yet implemented";
    }
}
