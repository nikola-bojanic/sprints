package home.nikolabojanic.sprint.web.controller;
import home.nikolabojanic.sprint.model.Task;
import home.nikolabojanic.sprint.service.TaskService;
import home.nikolabojanic.sprint.support.TaskDtoToTask;
import home.nikolabojanic.sprint.support.TaskToTaskDto;
import home.nikolabojanic.sprint.web.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiTaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskToTaskDto toDto;
    @Autowired
    private TaskDtoToTask toModel;
    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(@RequestParam(required = false) String taskName,
                                                  @RequestParam(required = false) Long sprintId,
                                                  @RequestParam(defaultValue = "0") int pageNo,
                                                  @RequestParam(defaultValue = "5") int pageSize){
        HttpHeaders headers = new HttpHeaders();
        Page<Task> page = taskService.getAll(taskName, sprintId, pageNo, pageSize);
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
        return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getOne(@PathVariable Long id){
        Optional<Task> existing = taskService.getOne(id);
        if(!existing.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(toDto.convert(existing.get()), HttpStatus.OK);
        }
    }
//    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> createTask(@Validated @RequestBody TaskDto dto){
        return new ResponseEntity<>(toDto.convert(taskService.save(dto)), HttpStatus.CREATED);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable Long id){
        Task deleted = taskService.delete(id);
        if(deleted == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.NO_CONTENT);
        }
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> editTask(@PathVariable Long id, @Validated @RequestBody TaskDto dto){
        if(id != dto.getId()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Task> existing = taskService.getOne(id);
        if(!existing.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(toDto.convert(taskService.save(dto)), HttpStatus.OK);
        }
    }
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PostMapping("/{id}/changeState")
    public ResponseEntity<TaskDto> changeTaskState(@PathVariable Long id){
        Task newState = taskService.changeState(id);
        if(newState == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(toDto.convert(newState), HttpStatus.OK);
        }
    }
}