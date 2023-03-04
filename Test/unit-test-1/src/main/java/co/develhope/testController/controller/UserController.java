package co.develhope.testController.controller;

import co.develhope.testController.entities.User;
import co.develhope.testController.repositories.UserRepositories;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepositories userRepositories;

    //create
    @PostMapping("")
    public @ResponseBody User create(@RequestBody User user){
        return userRepositories.save(user);
    }

    // read all
    @GetMapping("/")
    public @ResponseBody List<User> getUser(){
        return userRepositories.findAll();
    }

    // read just one
    @GetMapping("/{id}")
    public @ResponseBody  User getAUser(@PathVariable long id){
        Optional<User> user =  userRepositories.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    // update the id of a user
    @PutMapping("/{id}")
    public @ResponseBody User update(@PathVariable long id, @RequestBody  @NotNull User user){
        user.setId(id);
        return userRepositories.save(user);
    }


    // delete a user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userRepositories.deleteById(id);
    }


}