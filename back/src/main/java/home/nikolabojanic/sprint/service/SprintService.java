package home.nikolabojanic.sprint.service;
import home.nikolabojanic.sprint.model.Sprint;
import java.util.List;
public interface SprintService {
    List<Sprint> getAll();
    Sprint getOne(Long id);
}