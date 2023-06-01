package home.nikolabojanic.sprint.model;
import javax.persistence.*;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String employee;
    @Column
    private Integer points;
    @ManyToOne
    private Sprint sprint;
    @ManyToOne
    private State state;
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
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Sprint getSprint() {
        return sprint;
    }
    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}