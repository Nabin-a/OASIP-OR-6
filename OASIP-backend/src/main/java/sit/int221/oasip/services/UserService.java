package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.dto.userdto.UserDtoCreate;
import sit.int221.oasip.dto.userdto.UserDtoDetail;
import sit.int221.oasip.dto.userdto.UserDtoList;
import sit.int221.oasip.entities.Roles;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapperService listMapper;

    //Method List User All
    public List<UserDtoList> getUsersAll() {
        List<User> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return listMapper.mapList(userList, UserDtoList.class, modelMapper);
    }

    //Method Show Detail User by ID
    public UserDtoDetail getUsertById(Integer id){
        User user = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User ID: "+id+" does not exist"));
        return modelMapper.map(user, UserDtoDetail.class);
    }

    //Method Create User
    public User save(UserDtoCreate newUser){
        if(newUser.getRole() == null){
            newUser.setRole(String.valueOf(Roles.student));
        }
        User user = modelMapper.map(newUser, User.class);
        return userRepository.saveAndFlush(user);
    }
}
