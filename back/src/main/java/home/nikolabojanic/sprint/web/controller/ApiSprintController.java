package home.nikolabojanic.sprint.web.controller;
import home.nikolabojanic.sprint.service.SprintService;
import home.nikolabojanic.sprint.support.SprintToSprintDto;
import home.nikolabojanic.sprint.web.dto.SprintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "api/sprints", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiSprintController {
    @Autowired
    private SprintService sprintService;
    @Autowired
    private SprintToSprintDto toDto;
    @GetMapping
    public ResponseEntity<List<SprintDto>> getSprints(){
        return new ResponseEntity<>(toDto.convert(sprintService.getAll()), HttpStatus.OK);
    }
}