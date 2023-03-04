package co.develhope.loginDemo.auth.entities;

import co.develhope.loginDemo.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRTO {

    private User user;
    private String JWT;

}
