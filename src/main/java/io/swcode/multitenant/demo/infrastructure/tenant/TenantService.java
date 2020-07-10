package io.swcode.multitenant.demo.infrastructure.tenant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class TenantService {
    private final List<Tenant> tenants;

    public Tenant tenantByDomain(final String domain) {
        return tenants.stream()
                .filter(tenant -> tenant.isSameDomain(domain))
                .findFirst()
                .orElse(Tenant.defaultTenant());
    }
}
