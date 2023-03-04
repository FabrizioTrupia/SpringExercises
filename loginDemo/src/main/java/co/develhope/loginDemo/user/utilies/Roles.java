package co.develhope.loginDemo.user.utilies;

import co.develhope.loginDemo.user.entities.User;

public class Roles {

    public final static String REGISTERED = "REGISTERED";
    public final static String RESTAURANT = "RESTAURANT";
    public final static String RIDER = "RIDER";


    public static boolean hasRole(User user , String roleInput){
        return user.getRoles().stream().filter(role -> role.getName().equals(REGISTERED)).count() != 0;
    }



}
