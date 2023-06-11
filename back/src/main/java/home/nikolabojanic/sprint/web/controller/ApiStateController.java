package home.nikolabojanic.sprint.web.controller;
import home.nikolabojanic.sprint.service.StateService;
import home.nikolabojanic.sprint.support.StateToStateDto;
import home.nikolabojanic.sprint.web.dto.StateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "api/states", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiStateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private StateToStateDto toDto;
    @GetMapping
    public ResponseEntity<List<StateDto>> getStates(){
        return new ResponseEntity<>(toDto.convert(stateService.getAll()), HttpStatus.OK);
    }
}