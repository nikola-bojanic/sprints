package home.nikolabojanic.sprint.service.impl;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.repository.StateRepository;
import home.nikolabojanic.sprint.repository.TaskRepository;
import home.nikolabojanic.sprint.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
@Service
public class JpaTaskService implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StateRepository stateRepository;
    @Override
    public Page<Task> getAll(String taskName, Long sprintId, int pageNo, int pageSize) {
        if(taskName == null && sprintId == null){
            return taskRepository.findAll(PageRequest.of(pageNo, pageSize));
        } else if (taskName == null) {
            return taskRepository.findBySprintIdEquals(sprintId, PageRequest.of(pageNo, pageSize));
        }else if (sprintId == null){
            return taskRepository.findByNameLike("%" + taskName + "%", PageRequest.of(pageNo, pageSize));
        }else {
            return taskRepository.find("%" + taskName + "%", sprintId, PageRequest.of(pageNo, pageSize));
        }
    }
    @Override
    public Task getOne(Long id) {
        Optional<Task> existing = taskRepository.findById(id);
        if(!existing.isPresent()){
            return null;
        }else{
            return existing.get();
        }
    }
    @Override
    public Task delete(Long id) {
        Optional<Task> existing = taskRepository.findById(id);
        if(existing.isPresent()){
            Task task = existing.get();
            taskRepository.delete(existing.get());
            return task;
        }
        return null;
    }
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
    @Override
    public Task changeState(Long id) {
        Task task = getOne(id);
        if(task != null) {
            if (task.getState().getId() == 3) {
                return null;
            } else {
                task.setState(stateRepository.getOne(task.getState().getId() + 1));
            }
            return taskRepository.save(task);
        }
        return null;
    }
}