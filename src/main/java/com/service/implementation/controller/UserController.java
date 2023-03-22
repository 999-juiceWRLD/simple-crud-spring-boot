package com.service.implementation.controller;
import com.service.implementation.entity.PatchUser;
import com.service.implementation.entity.User;
import com.service.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService usrService;

    @GetMapping("/main")
    public String main() {
        return "hello from /main";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return usrService.findAllUsers();
    }

    @GetMapping("/get_username_{name}")
    public User getSpecificUser(@PathVariable("name") String user_name) {
        return usrService.findUserByName(user_name);
    }

    @GetMapping("/get_userid_{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        Long idlong = Long.valueOf(id);
        return usrService.getUserById(idlong);
    }

    @PostMapping("/create")
    public void createUserPage(@RequestBody User user) {
        usrService.saveUser(user);
    }

    @PatchMapping("/update/{id}")
    public void changeUserInfo(@PathVariable("id") Integer id, @RequestBody PatchUser patchUser) {
        Long idLong = Long.valueOf(id);
        usrService.updateUser(idLong, patchUser);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteUserPage(@PathVariable("id") Integer id) {
        Long idLong = Long.valueOf(id);
        usrService.deleteUserId(idLong);
    }

    @DeleteMapping("/delete_all")
    public void deleteAllUsers() {
        usrService.deleteAllUsers();
    }

}
