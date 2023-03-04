package co.develhope.redisCache.controllers;

import co.develhope.redisCache.entities.User;
import co.develhope.redisCache.entities.jpa.UserJpa;
import co.develhope.redisCache.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public User create(@RequestBody UserJpa userJpa){
       return userService.create(userJpa);
    }

    @GetMapping("/read_all")
    public List<? extends User> readAll(){
       return userService.readAll();
    }

    @GetMapping("/read_one/{id}")
    public User readOne(@PathVariable Long id){
       return userService.readOne(id);
    }

    @GetMapping("/read_one/fast/{id}")
    public void readOneFast(@PathVariable Long id){
        userService.readOneFast(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id , @RequestBody UserJpa userJpa){
       return userService.update(id , userJpa);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
