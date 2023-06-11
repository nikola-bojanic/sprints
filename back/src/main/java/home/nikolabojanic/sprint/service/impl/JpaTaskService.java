package home.nikolabojanic.sprint.service.impl;
import home.nikolabojanic.sprint.model.Sprint;
import home.nikolabojanic.sprint.model.State;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.repository.SprintRepository;
import home.nikolabojanic.sprint.repository.StateRepository;
import home.nikolabojanic.sprint.repository.TaskRepository;
import home.nikolabojanic.sprint.service.TaskService;
import home.nikolabojanic.sprint.support.TaskDtoToTask;
import home.nikolabojanic.sprint.web.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class JpaTaskService implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private SprintRepository sprintRepository;
    @Autowired
    private TaskDtoToTask toModel;
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
    public Optional <Task> getOne(Long id) {
        return taskRepository.findById(id);
    }
    @Override
    public Task delete(Long id) {
        Optional<Task> existing = taskRepository.findById(id);
        if(existing.isPresent()){
            Task task = existing.get();
            Sprint sprint = task.getSprint();
            sprint.removeTask(task.getId());
            State state = task.getState();
            state.removeTask(task.getId());
            stateRepository.save(state);
            sprintRepository.save(sprint);
            taskRepository.delete(existing.get());
            return task;
        }
        return null;
    }
    @Override
    public Task save(TaskDto dto) {
        Task task = null;
        if(dto.getId() == null){
            dto.setStateId(1L);
        }
        if(dto.getId() != null){
            Optional<Task> existing = getOne(dto.getId());
            if(existing.isPresent()){
                Task change = existing.get();
                Sprint oldSprint = change.getSprint();
                oldSprint.removeTask(dto.getId());
                sprintRepository.save(oldSprint);
            }
        }
        task = toModel.convert(dto);
        Sprint sprint = task.getSprint();
        sprint.addTask(task);
        Task save = taskRepository.save(task);
        sprintRepository.save(sprint);
        return save;
    }
    @Override
    public Task changeState(Long id) {
        Optional<Task> existing = getOne(id);
        if(existing.isPresent()) {
            Task task = existing.get();
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