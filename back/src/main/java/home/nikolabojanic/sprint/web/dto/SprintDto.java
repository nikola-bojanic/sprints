package home.nikolabojanic.sprint.web.dto;
public class SprintDto {
    private Long id;
    private String name;
    private String totalPoints;
    public SprintDto() {
    }
    public SprintDto(Long id, String name, String totalPoints) {
        this.id = id;
        this.name = name;
        this.totalPoints = totalPoints;
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
    public String getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }
}