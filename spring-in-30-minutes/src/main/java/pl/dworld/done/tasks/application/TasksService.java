package pl.dworld.done.tasks.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dworld.done.tasks.db.ProjectsJpaRepository;
import pl.dworld.done.tasks.db.TasksJpaRepository;
import pl.dworld.done.tasks.domain.Project;
import pl.dworld.done.tasks.domain.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksJpaRepository repository;
    private final ProjectsJpaRepository projectsRepository;

    public List<Task> getAll() {
        return repository.findAll();
    }

    public List<Task> getPriority() {
        LocalDate now = LocalDate.now();
        return repository.findByPriorityIsTrueOrDueDateLessThanEqual(now);
    }

    public List<Task> getInbox() {
        return repository.findByProjectIsNull();
    }

    public List<Task> getByProjectId(Long projectId) {
        return repository.findByProjectEquals(projectId);
    }

    public void addTask(String title, LocalDate dueDate, Long projectId, Boolean priority) {
        Optional<Project> project = Optional.ofNullable(projectId).flatMap(projectsRepository::findById);
        Task.TaskBuilder builder = Task
            .builder()
            .title(title)
            .dueDate(dueDate)
            .priority(priority != null && priority);
        project.ifPresent(builder::project);
        repository.save(builder.build());
    }
}
