package home.nikolabojanic.sprint.support;
import home.nikolabojanic.sprint.model.Sprint;
import home.nikolabojanic.sprint.web.dto.SprintDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class SprintToSprintDto implements Converter<Sprint, SprintDto> {
    @Override
    public SprintDto convert(Sprint sprint) {
        SprintDto dto = new SprintDto();
        dto.setId(sprint.getId());
        dto.setName(sprint.getName());
        dto.setTotalPoints(sprint.getTotalPoints());
        return dto;
    }
    public List<SprintDto> convert(List<Sprint> sprints){
        List<SprintDto> dtos = new ArrayList<>();
        for(Sprint sprint : sprints){
            dtos.add(convert(sprint));
        }
        return dtos;
    }
}