package home.nikolabojanic.sprint.model;
import javax.persistence.*;
import java.util.List;
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "state", fetch = FetchType.EAGER)
    private List<Task> tasks;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public void removeTask(Long id) {
        for(Task task : this.tasks) {
            if (task.getId() ==  id){
                this.tasks.remove(task);
                return;
            }
        }
    }
}