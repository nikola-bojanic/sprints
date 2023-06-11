package home.nikolabojanic.sprint.service;
import home.nikolabojanic.sprint.model.State;
import java.util.List;
public interface StateService {
    List<State> getAll();
    State getOne(Long id);
}