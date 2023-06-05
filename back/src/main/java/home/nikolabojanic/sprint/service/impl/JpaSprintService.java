package home.nikolabojanic.sprint.service.impl;
import home.nikolabojanic.sprint.model.Sprint;
import home.nikolabojanic.sprint.repository.SprintRepository;
import home.nikolabojanic.sprint.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class JpaSprintService implements SprintService {
    @Autowired
    private SprintRepository sprintRepository;
    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }
    @Override
    public Sprint getOne(Long id) {
        Optional<Sprint> existing = sprintRepository.findById(id);
        if(!existing.isPresent()){
            return null;
        }else {
            return existing.get();
        }
    }
}