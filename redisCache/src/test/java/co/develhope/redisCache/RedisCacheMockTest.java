package co.develhope.redisCache;

import co.develhope.redisCache.entities.redis.UserRedis;
import co.develhope.redisCache.repositories.redis.UserRepositoryRedis;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisCacheMock.class)
public class RedisCacheMockTest {

    @Autowired
    private UserRepositoryRedis userRepositoryRedis;



    @Test
    public void souledWriteOnRedisCache(){
        UserRedis userRedis = new UserRedis();
        userRedis.setDomicileCity("Palermo");
        userRedis.setId(1L);
        userRedis.setEmail("fabrizio@hotmial.it");
        userRedis.setFirstName("Fabrizio");

        UserRedis userSavedInRedisCache = userRepositoryRedis.save(userRedis);

        Assertions.assertNotNull(userSavedInRedisCache);
    }


}
