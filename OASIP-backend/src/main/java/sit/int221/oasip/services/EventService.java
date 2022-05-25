package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.EventDtoCreate;
import sit.int221.oasip.DTO.EventDtoDetail;
import sit.int221.oasip.DTO.EventDtoEdit;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.entities.Category;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.CategoryRepository;
import sit.int221.oasip.repositories.EventRepository;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapperService listMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    //Method list all event
    public List<EventDtoList> getEventsAll() {
        List<Event> eventList = repository.findAll(Sort.by(Sort.Direction.DESC, "startTime"));
        return listMapper.mapList(eventList, EventDtoList.class, modelMapper);
    }

    //Method get Event by eventId
    public EventDtoDetail getEventById(Integer id){
        Event event = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Event id: "+id+" does not exist"));
        return modelMapper.map(event, EventDtoDetail.class);
    }

    //Method create new Event
    public Event save(EventDtoCreate newEvent){
        Category category = categoryRepository.findById(newEvent.getEventCategoryId())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                newEvent.getEventCategoryId() + " does't exist !!"));
        newEvent.setDurations(category.getDurationMin());
        Event event = modelMapper.map(newEvent , Event.class);
        return repository.saveAndFlush(event);
    }

    public Event edit(EventDtoEdit editEvent, Integer bookingId){
        Event event = repository.findById(bookingId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Event id: "+bookingId+" does not exist"));
        event.setStartTime(editEvent.getStartTime());
        event.setNote(editEvent.getNote());
        return modelMapper.map(editEvent, Event.class);
    }

}
