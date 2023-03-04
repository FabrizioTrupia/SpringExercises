package co.develhope.loginDemo.user.controllers;

import co.develhope.loginDemo.auth.entities.LoginRTO;
import co.develhope.loginDemo.auth.services.LoginService;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/profile")
    public LoginRTO getProfile(Principal principal ){
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        LoginRTO rto = new LoginRTO();
        rto.setUser(user);
        rto.setJWT(loginService.generateJWT(user));
        return rto;
    }

    @PostMapping("")
    public @ResponseBody User create(@RequestBody User user){
        return userRepository.save(user);
    }

    // read all
    @GetMapping("/")
    public @ResponseBody List<User> getUser(){
        return userRepository.findAll();
    }

    // read just one
    @GetMapping("/{id}")
    public @ResponseBody  User getAUser(@PathVariable long id){
        Optional<User> user =  userRepository.findById(id);
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
        return userRepository.save(user);
    }


    // delete a user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
