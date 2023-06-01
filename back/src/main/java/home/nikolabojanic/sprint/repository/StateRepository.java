package home.nikolabojanic.sprint.repository;
import home.nikolabojanic.sprint.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
