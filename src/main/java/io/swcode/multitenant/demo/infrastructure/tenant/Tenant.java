package io.swcode.multitenant.demo.infrastructure.tenant;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Tenant {
    private static Tenant defaultTenant;

    @NotEmpty
    private String domain;

    @NotEmpty
    private String database;

    public static void setDefaultTenant(final Tenant defaultTenant) {
        Tenant.defaultTenant = defaultTenant;
    }

    public static Tenant defaultTenant() {
        if(defaultTenant == null) {
            throw new NoDefaultTenantException();
        }
        return defaultTenant;
    }

    public boolean isSameDomain(final String domain) {
        return this.domain.equalsIgnoreCase(domain);
    }
}
