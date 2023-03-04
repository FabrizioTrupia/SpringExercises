package co.develhope.redisCache.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private Long id;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String email;
    private String passwordEncrypted;
    private String domicileAddress;
    private String domicileCity;
    private String domicileNumber;
    private String domicileState;
    private String fiscalCode;
}
