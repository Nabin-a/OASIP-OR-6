package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.EventDtoCreate;
import sit.int221.oasip.DTO.EventDtoDetail;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;
import sit.int221.oasip.services.EventService;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/event")

public class EventController {
    @Autowired
    private EventRepository repository;
    @Autowired
    private EventService eventService;
    
    @GetMapping("")
    public List<EventDtoList> getEventDTO() {
        return eventService.getEventsAll();
    }

    @GetMapping("/{id}")
    public EventDtoDetail getEventById(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

    //POST
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@Valid @RequestBody EventDtoCreate newEventDtoCreate, BindingResult result){
        if(result.hasErrors()){
            System.out.println("The information is invalid");
        }
        return eventService.save(newEventDtoCreate);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "Does not exist"));
        repository.deleteById(id);
    }

    //PUT
    @PutMapping("/{id}")
    public  Event edit(@RequestBody Event editEvent, @PathVariable Integer id){
        return repository.findById(id).map(edit -> {
            edit.setStartTime(editEvent.getStartTime());
            edit.setNote(editEvent.getNote());
            return repository.saveAndFlush(edit);
        }).orElseGet(()->{
            return repository.save(editEvent);
        });
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
