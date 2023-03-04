package co.develhope.loginDemo.auth.services;

import co.develhope.loginDemo.auth.entities.LoginDTO;
import co.develhope.loginDemo.auth.entities.LoginRTO;
import co.develhope.loginDemo.user.entities.User;
import co.develhope.loginDemo.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

@Service
public class LoginService {

    public static final String JWT_SECRET = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY3NzY4NDk5NywiaWF0IjoxNjc3Njg0OTk3fQ.AY3ewLXN8hpbu7sXW2Rc14mldDXa8Iw8z0mqlutihKc";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginRTO login(LoginDTO loginDTO) throws UnsupportedEncodingException {
        if (loginDTO == null) return null;
        User userFromDb = userRepository.finByEmail(loginDTO.getEmail());
        if (userFromDb == null || !userFromDb.isActive()) return null;

        boolean canLogin = canUserLogin(userFromDb , loginDTO.getPassword());
        if (!canLogin) return null;

        String JWT = getJWT(userFromDb);
        userFromDb.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(userFromDb);

        userFromDb.setPassword(null);
        LoginRTO out = new LoginRTO();
        out.setJWT(JWT);
        out.setUser(userFromDb);
        return out;
    }

    public boolean canUserLogin(User user , String password){
       return passwordEncoder.matches(password , user.getPassword());
    }


    public static String getJWT(User user) throws UnsupportedEncodingException {
        return JWT.create().withClaim("id" , user.getId()).withClaim("email" , user.getEmail()).sign(Algorithm.HMAC512(JWT_SECRET));
    }

}
