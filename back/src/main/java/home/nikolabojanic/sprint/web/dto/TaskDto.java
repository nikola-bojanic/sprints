package home.nikolabojanic.sprint.web.dto;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
public class TaskDto {
    private Long id;
    @NotBlank
    @Length(max = 40)
    private String name;
    private String employee;
    @Min(value = 0)
    @Max(value = 20)
    private Integer points;
    private Long sprintId;
    private Long stateId;
    private String sprintName;
    private String stateName;
    public TaskDto() {
    }
    public TaskDto(Long id, String name, String employee, Integer points, Long sprintId, Long stateId, String sprintName, String stateName) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.points = points;
        this.sprintId = sprintId;
        this.stateId = stateId;
        this.sprintName = sprintName;
        this.stateName = stateName;
    }
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
    public Long getSprintId() {
        return sprintId;
    }
    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }
    public Long getStateId() {
        return stateId;
    }
    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
    public String getSprintName() {
        return sprintName;
    }
    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}