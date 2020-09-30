package pl.dworld.done.tasks.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dworld.done.tasks.domain.Task;

import java.time.LocalDate;
import java.util.List;

public interface TasksJpaRepository extends JpaRepository<Task, Long> {

    List<Task> findByPriorityIsTrueOrDueDateLessThanEqual(LocalDate dueDate);

    List<Task> findByProjectIsNull();

    List<Task> findByProjectEquals(Long projectId);
}
