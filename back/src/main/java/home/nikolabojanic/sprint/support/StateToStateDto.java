package home.nikolabojanic.sprint.support;
import home.nikolabojanic.sprint.model.State;
import home.nikolabojanic.sprint.web.dto.StateDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class StateToStateDto implements Converter<State, StateDto> {
    @Override
    public StateDto convert(State state) {
        StateDto dto = new StateDto();
        dto.setId(state.getId());
        dto.setName(state.getName());
        return dto;
    }
    public List<StateDto> convert(List<State> states){
        List<StateDto> dtos = new ArrayList<>();
        for(State state : states){
            dtos.add(convert(state));
        }
        return dtos;
    }
}