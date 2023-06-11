package home.nikolabojanic.sprint.repository;
import home.nikolabojanic.sprint.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
    @Query("SELECT s FROM Sprint s WHERE" +
            "(s.id = :sprintId)")
    Sprint get(@Param("sprintId")Long id);
}
