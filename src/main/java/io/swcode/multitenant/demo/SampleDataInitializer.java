package io.swcode.multitenant.demo;

import io.swcode.multitenant.demo.domain.User;
import io.swcode.multitenant.demo.domain.UserRepository;
import io.swcode.multitenant.demo.infrastructure.tenant.CurrentTenantHolder;
import io.swcode.multitenant.demo.infrastructure.tenant.Tenant;
import io.swcode.multitenant.demo.infrastructure.tenant.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SampleDataInitializer {

    private final UserRepository userRepository;

    private final TenantService tenantService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationStartedEvent() {
        Tenant tenant1 = tenantService.tenantByDomain("localhost");
        CurrentTenantHolder.set(tenant1);
        userRepository.deleteAll();
        userRepository.save(User.of("Gandalf", "The Grey"));

        Tenant tenant2 = tenantService.tenantByDomain("127.0.0.1");
        CurrentTenantHolder.set(tenant2);
        userRepository.deleteAll();
        userRepository.save(User.of("Darth", "Vader"));

        CurrentTenantHolder.reset();
    }
}
