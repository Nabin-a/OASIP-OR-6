package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;

import java.util.List;

@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    private EventRepository repository;

    @GetMapping("")
    public List<Event> getAllEvent(){
        return repository.findAll();
    }
}
