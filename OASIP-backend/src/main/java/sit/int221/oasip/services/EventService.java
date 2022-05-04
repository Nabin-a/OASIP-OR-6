package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.EventDtoDetail;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.repositories.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapperService listMapper;

    public List<EventDtoList> getEventsAll() {
        List<Event> eventList = repository.findAll(Sort.by(Sort.Direction.DESC, "startTime"));
        return listMapper.mapList(eventList, EventDtoList.class, modelMapper);
    }

    public EventDtoDetail getEventById(Integer id){
        Event event = repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Event id: "+id+"Does not exist"));
        return modelMapper.map(event, EventDtoDetail.class);
    }
}
