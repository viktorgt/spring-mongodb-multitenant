package io.swcode.multitenant.demo.infrastructure.tenant;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Configuration
@AllArgsConstructor
@Validated
@ConfigurationProperties(prefix = "app")
public class TenantConfig {
    private List<Tenant> tenants;

    public void setTenants(final List<Tenant> tenants) {
        if(tenants.isEmpty()) {
            throw new NoDefaultTenantException();
        }

        this.tenants = tenants;
        Tenant.setDefaultTenant(tenants.get(0));
    }

    @Bean
    public TenantService tenantService() {
        return new TenantService(tenants);
    }
}
