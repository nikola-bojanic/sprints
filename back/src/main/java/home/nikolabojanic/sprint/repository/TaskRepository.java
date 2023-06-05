package home.nikolabojanic.sprint.repository;
import home.nikolabojanic.sprint.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE" +
            "(t.name LIKE :taskName) AND" +
            "(t.sprint.id = :sprintId)")
    Page<Task> find(@Param("taskName") String taskName, @Param("sprintId") Long sprintId, Pageable pageable);
    Page<Task> findByNameLike(String taskName, Pageable pageable);
    Page<Task> findBySprintIdEquals(Long sprintId, Pageable pageable);
}