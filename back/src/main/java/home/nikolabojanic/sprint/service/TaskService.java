package home.nikolabojanic.sprint.service;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.web.dto.TaskDto;
import org.springframework.data.domain.Page;
import java.util.Optional;
public interface TaskService {
    Page<Task> getAll(String taskName, Long sprintId, int pageSize, int pageNo);
    Optional<Task> getOne(Long id);
    Task delete(Long id);
    Task save(TaskDto taskDto);
    Task changeState(Long id);
}