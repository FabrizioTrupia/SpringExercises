package co.develhope.loginDemo.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;
    @Column(length = 36)
    private String activationCode;
    @Column(length = 36)
    private String passwordResetCode;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
               @JoinColumn(name = "USER_ID")
                  },
            inverseJoinColumns = {
               @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;



}
