package pl.dworld.done.tasks.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dworld.done.tasks.db.ProjectsJpaRepository;
import pl.dworld.done.tasks.domain.Project;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectsService {
    private final ProjectsJpaRepository repository;

    public Project addProjects(String name) {
        return repository.save(new Project(name));
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Optional<Project> getById(Long id) {
        return repository.findById(id);
    }
}
