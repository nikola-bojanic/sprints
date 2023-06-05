package home.nikolabojanic.sprint.service;
import home.nikolabojanic.sprint.model.Task;
import org.springframework.data.domain.Page;
public interface TaskService {
    Page<Task> getAll(String taskName, Long sprintId, int pageSize, int pageNo);
    Task getOne(Long id);
    Task delete(Long id);
    Task save(Task task);
    Task changeState(Long id);
}