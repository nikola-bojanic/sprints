package home.nikolabojanic.sprint.support;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.web.dto.TaskDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class TaskToTaskDto implements Converter<Task, TaskDto> {
    @Override
    public TaskDto convert(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setEmployee(task.getEmployee());
        dto.setName(task.getName());
        dto.setPoints(task.getPoints());
        dto.setSprintId(task.getSprint().getId());
        dto.setSprintName(task.getSprint().getName());
        dto.setStateId(task.getState().getId());
        dto.setStateName(task.getState().getName());
        return dto;
    }
    public List<TaskDto> convert(List<Task> tasks){
        List<TaskDto> dtos = new ArrayList<>();
        for(Task task : tasks){
            dtos.add(convert(task));
        }
        return dtos;
    }
}