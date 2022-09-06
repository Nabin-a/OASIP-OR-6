package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.dto.userdto.*;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.repositories.UserRepository;
import sit.int221.oasip.services.PasswordService;
import sit.int221.oasip.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @GetMapping("")
    public List<UserDtoList> getUserDTO() {
        return userService.getUsersAll();
    }

    @GetMapping("/{id}")
    public UserDtoDetail getUserById(@PathVariable Integer id) {
        return userService.getUsertById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody UserDtoCreate newUser){
        return  userService.save(newUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "Can not found this id"));
        repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public User update(@Valid @RequestBody UserDtoEdit update, @PathVariable Integer id, BindingResult result){
        return userService.edit(update, id);
    }

    @PostMapping("/match")
    public User checkPassword(@RequestBody UserDtoLogin login){
        return passwordService.checkPassword(login);
    }
}