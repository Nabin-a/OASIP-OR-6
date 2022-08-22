package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasip.dto.userdto.UserDtoCreate;
import sit.int221.oasip.dto.userdto.UserDtoDetail;
import sit.int221.oasip.dto.userdto.UserDtoList;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.repositories.UserRepository;
import sit.int221.oasip.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<UserDtoList> getUserDTO() {
        return userService.getUsersAll();
    }

    @GetMapping("/{id}")
    public UserDtoDetail getUserById(@PathVariable Integer id) {
        return userService.getUsertById(id);
    }

    @PostMapping("")
    public User create(@Valid @RequestBody UserDtoCreate newUser){
        return  userService.save(newUser);
    }
}
