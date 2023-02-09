package co.develhope.mongoDbDemo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "develhope";
    }

    //Questo metodo serve a dire alla nostra applicazione che voglio che le entità del mio mongodb vengano prese da questi pachetti
    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.develhope");
    }

    //metodo per creare la nostra connesione reale del mongo db
    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://fabeer:<develhope>@cluster0.seo65pv.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
