package co.develhope.loginDemo.user.repositories;

import co.develhope.loginDemo.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User , Long>{
    User finByEmail(String email);


    User getByActivationCode(String activationCode);

    User findByPasswordResetCode(String passwordResetCode);


}
