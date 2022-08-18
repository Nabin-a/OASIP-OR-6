package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasip.DTO.userdto.UserDtoDetail;
import sit.int221.oasip.DTO.userdto.UserDtoList;
import sit.int221.oasip.services.UserService;

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
}
