package pl.dworld.done.tasks.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dworld.done.tasks.domain.Project;

public interface ProjectsJpaRepository extends JpaRepository<Project, Long> {
}
