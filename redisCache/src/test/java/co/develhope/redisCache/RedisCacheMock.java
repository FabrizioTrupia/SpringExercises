package co.develhope.redisCache;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

@TestConfiguration
public class RedisCacheMock {

    private RedisServer redisServer;

    @Value("${redis.port}")
    private int redisPort;


    @PostConstruct
    public void postConstruct(){
        try {
            redisServer = new RedisServer(redisPort);
            redisServer.start();
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }

    @PreDestroy
    public void preDestroy(){
        redisServer.stop();
    }




}
