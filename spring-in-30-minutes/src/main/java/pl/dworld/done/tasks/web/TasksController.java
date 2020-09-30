package pl.dworld.done.tasks.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dworld.done.tasks.application.TasksService;
import pl.dworld.done.tasks.domain.Task;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
class TasksController {
    private final TasksService tasksService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody CreateTaskCommand command) {
        tasksService.addTask(
            command.title,
            command.dueDate,
            command.projectId,
            command.priority
        );
    }

    @GetMapping
    public List<Task> getAll() {
        return tasksService.getAll();
    }

    @GetMapping("/inbox")
    public List<Task> getInbox() {
        return tasksService.getInbox();
    }

    @GetMapping("/priority")
    public List<Task> getPriority() {
        return tasksService.getPriority();
    }

    @GetMapping(params = "project")
    public List<Task> getByProjectId(@RequestParam("project") Long projectId) {
        return tasksService.getByProjectId(projectId);
    }

    @Data
    @Builder
    static class CreateTaskCommand {
        String title;
        LocalDate dueDate;
        Long projectId;
        Boolean priority;
    }

}
