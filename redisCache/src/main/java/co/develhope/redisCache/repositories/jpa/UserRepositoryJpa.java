package co.develhope.redisCache.repositories.jpa;

import co.develhope.redisCache.entities.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository <UserJpa , Long> {
}
