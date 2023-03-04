package co.develhope.redisCache.services;

import co.develhope.redisCache.entities.User;
import co.develhope.redisCache.entities.jpa.UserJpa;
import co.develhope.redisCache.entities.redis.UserRedis;
import co.develhope.redisCache.repositories.jpa.UserRepositoryJpa;
import co.develhope.redisCache.repositories.redis.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;
    @Autowired
    private UserRepositoryRedis userRepositoryRedis;

    public UserRedis convertDate(UserJpa user){
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user , userRedis); //copia per noi tutti i field
        return userRedis;
    }

    public User create(UserJpa userJpa) {
        if (userJpa == null) return null;
        userJpa.setId(null);
        return userRepositoryJpa.save(userJpa);
    }

    public List<? extends User> readAll() {
        return userRepositoryJpa.findAll();
    }

    public User readOne(Long id) {
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()){
            return userRedis.get();
        }else {
            UserJpa userFromDb = userRepositoryJpa.getById(id);
            userRepositoryRedis.save(convertDate(userFromDb));
            return userFromDb;
        }
    }

    public User update(Long id , UserJpa user) {
        if (user == null) return null;
        user.setId(id);
        UserJpa newUser = userRepositoryJpa.save(user);

        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()){
           // userRepositoryRedis.deleteById(id); // Piu veloce
           userRepositoryRedis.save(convertDate(newUser)); //Piu lento nella fase di update , ma piu veloce nella fase di read
        }
        return user;
    }

    public void delete(Long id) {
        userRepositoryJpa.deleteById(id);
        userRepositoryRedis.deleteById(id);
    }

    public void readOneFast(Long id) {
    }
}
