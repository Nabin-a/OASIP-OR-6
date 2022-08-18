package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int221.oasip.DTO.EventDtoList;
import sit.int221.oasip.DTO.UserDtoList;
import sit.int221.oasip.entities.Event;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapperService listMapper;

    public List<UserDtoList> getUsersAll() {
        List<User> userList = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return listMapper.mapList(userList, UserDtoList.class, modelMapper);
    }
}
