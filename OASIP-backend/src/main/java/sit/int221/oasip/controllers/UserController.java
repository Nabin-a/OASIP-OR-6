package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.DTO.userdto.UserDtoCreate;
import sit.int221.oasip.DTO.userdto.UserDtoDetail;
import sit.int221.oasip.DTO.userdto.UserDtoList;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

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
