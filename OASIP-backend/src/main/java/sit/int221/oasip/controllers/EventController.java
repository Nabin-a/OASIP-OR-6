package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.EventDtoCreate;
import sit.int221.oasip.DTO.EventDtoDetail;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;
import sit.int221.oasip.services.EventService;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

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
    public Event create(@RequestBody EventDtoCreate newEventDtoCreate){
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
}
