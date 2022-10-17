package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.dto.eventdto.EventDtoCreate;
import sit.int221.oasip.dto.eventdto.EventDtoDetail;
import sit.int221.oasip.dto.eventdto.EventDtoEdit;
import sit.int221.oasip.dto.eventdto.EventDtoList;
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
        Authentication role = SecurityContextHolder.getContext().getAuthentication();
        //role student
        if (role.getAuthorities().toString().equals("[ROLE_student]")){
            List<Event> eventList = repository.findAllByBookingEmail(role.getName());
            return listMapper.mapList(eventList, EventDtoList.class, modelMapper);
        }

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
    public EventDtoDetail save(EventDtoCreate newEvent){

        Category category = categoryRepository.findById(newEvent.getCategoryId())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Category id:" + newEvent.getCategoryId() + " doesn't exist !!"));
        newEvent.setDurations(category.getDurationMin());
        Event event = repository.saveAndFlush(modelMapper.map(newEvent , Event.class));
        return modelMapper.map(event, EventDtoDetail.class);
    }

    public Event edit(EventDtoEdit editEvent, Integer eventId){
        Event event = repository.findById(eventId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Event id: "+eventId+" does not exist"));
        event.setStartTime(editEvent.getStartTime());
        if (editEvent.getNote()==null){
            editEvent.setNote(event.getNote());
        }
        event.setNote(editEvent.getNote());
        modelMapper.map(editEvent, event);
        Event mapEvent = modelMapper.map(event, Event.class);
        return repository.saveAndFlush(mapEvent);
    }

}
