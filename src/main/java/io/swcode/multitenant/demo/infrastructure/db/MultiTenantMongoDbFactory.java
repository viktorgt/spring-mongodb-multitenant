package io.swcode.multitenant.demo.infrastructure.db;

import com.mongodb.client.MongoDatabase;
import io.swcode.multitenant.demo.infrastructure.tenant.CurrentTenantHolder;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

public class MultiTenantMongoDbFactory extends SimpleMongoClientDbFactory {
    public MultiTenantMongoDbFactory(final String connectionString) {
        super(connectionString);
    }

    @Override
    public MongoDatabase getDb() {
        final String database = CurrentTenantHolder.get().getDatabase();
        return super.getDb(database);
    }
}
