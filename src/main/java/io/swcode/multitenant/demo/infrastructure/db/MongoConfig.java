package io.swcode.multitenant.demo.infrastructure.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

@Configuration
public class MongoConfig {
    @Bean
    public MongoDbFactory mongoDbFactory(@Value("${spring.data.mongodb.uri}") String connectionString) {
        return new MultiTenantMongoDbFactory(connectionString);
    }
}
