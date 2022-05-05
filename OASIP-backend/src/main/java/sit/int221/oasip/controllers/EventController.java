package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasip.DTO.EventDtoDetail;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;
import sit.int221.oasip.services.EventService;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

<<<<<<< HEAD
@CrossOrigin(origins = "*")
=======
@CrossOrigin(origins="*")
>>>>>>> d355592f374fe7e1f6038f571c23470bfa9fee1d
@RestController
@RequestMapping("api/event")

public class EventController {
    @Autowired
//    private EventRepository repository;
//    @Autowired
    private EventService eventService;

    @GetMapping("")
//    public List<Event> getAllEvent(){
//        List<Event> events = repository.findAll(Sort.by(Sort.Direction.DESC, "startTime"));
//        return events;
//    }
    public List<EventDtoList> getEventDTO(){
        return eventService.getEventsAll();
    }

    @GetMapping("/{id}")
    public EventDtoDetail getEventById(@PathVariable Integer id){
        return eventService.getEventById(id);
    }
}
