package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.services.EventService;

import java.util.List;

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
}
