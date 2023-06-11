package home.nikolabojanic.sprint.model;
import javax.persistence.*;
import java.util.List;
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String totalPoints;
    @OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER)
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
    public String getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }
    public void addTask(Task task) {
        this.tasks.add(task);
        this.setTotalPoints(Integer.parseInt(this.getTotalPoints()) + task.getPoints() + "");
    }
    public void removeTask(Long id) {
        for(Task task : this.tasks) {
            if (task.getId() ==  id){
                this.tasks.remove(task);
                this.setTotalPoints(Integer.parseInt(this.getTotalPoints()) - task.getPoints() + "");
                return;
            }
        }
    }
}