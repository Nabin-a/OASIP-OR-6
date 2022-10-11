package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.dto.eventdto.EventDtoCreate;
import sit.int221.oasip.dto.eventdto.EventDtoDetail;
import sit.int221.oasip.dto.eventdto.EventDtoEdit;
import sit.int221.oasip.dto.eventdto.EventDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;
import sit.int221.oasip.services.EventService;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/events")

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
    public EventDtoDetail create(@Valid @RequestBody EventDtoCreate newEventDtoCreate){
        return eventService.save(newEventDtoCreate);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "does not exist"));
        repository.deleteById(id);
    }

    //PUT
    @PutMapping("/{id}")
    public Event edit(@Valid @RequestBody EventDtoEdit edit, @PathVariable Integer id){
        return eventService.edit(edit, id);
    }

}
