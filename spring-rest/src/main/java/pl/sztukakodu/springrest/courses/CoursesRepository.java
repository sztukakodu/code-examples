package pl.sztukakodu.springrest.courses;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class CoursesRepository {
    private final Sequence sequence = new Sequence();

    private final List<Course> courses = List.of(
        new Course(sequence.next(), "Szkoła Springa"),
        new Course(sequence.next(), "Szkoła Monitoringu"),
        new Course(sequence.next(), "Kurs Współbieżności")
    );

    public List<Course> index() {
        return List.copyOf(courses);
    }
}
