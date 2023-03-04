package co.develhope.redisCache.entities.redis;

import co.develhope.redisCache.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "user" , timeToLive = 10)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRedis extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
