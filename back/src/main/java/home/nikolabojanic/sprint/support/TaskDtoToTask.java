package home.nikolabojanic.sprint.support;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.service.SprintService;
import home.nikolabojanic.sprint.service.StateService;
import home.nikolabojanic.sprint.service.TaskService;
import home.nikolabojanic.sprint.web.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class TaskDtoToTask implements Converter<TaskDto, Task> {
    @Autowired
    private TaskService taskService;
    @Autowired
    private SprintService sprintService;
    @Autowired
    private StateService stateService;
    @Override
    public Task convert(TaskDto taskDto) {
        Task task;
        if(taskDto.getId() != null){
            task = taskService.getOne(taskDto.getId()).get();
        }else{
            task = new Task();
        }
        if(task == null){
            return null;
        }
        else{
            task.setId(taskDto.getId());
            task.setEmployee(taskDto.getEmployee());
            task.setName(taskDto.getName());
            task.setPoints(taskDto.getPoints());
            task.setSprint(sprintService.getOne(taskDto.getSprintId()));
            task.setState(stateService.getOne(taskDto.getStateId()));
            return task;
        }
    }
}