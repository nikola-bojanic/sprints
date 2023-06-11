package home.nikolabojanic.sprint.service.impl;
import home.nikolabojanic.sprint.model.State;
import home.nikolabojanic.sprint.repository.StateRepository;
import home.nikolabojanic.sprint.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class JpaStateService implements StateService {
    @Autowired
    private StateRepository stateRepository;
    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }
    @Override
    public State getOne(Long id) {
        Optional<State> existing = stateRepository.findById(id);
        if(!existing.isPresent()){
            return null;
        }else{
            return existing.get();
        }
    }
}