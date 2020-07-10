package io.swcode.multitenant.demo.infrastructure.tenant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrentTenantHolder {
    private static final ThreadLocal<Tenant> CURRENT_TENANT = ThreadLocal.withInitial(Tenant::defaultTenant);

    public static Tenant get() {
        return CURRENT_TENANT.get();

    }

    public static void set(Tenant tenant) {
        CURRENT_TENANT.set(tenant);
    }

    public static void reset() {
        CURRENT_TENANT.remove();
    }
}
