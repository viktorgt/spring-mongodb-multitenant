package io.swcode.multitenant.demo.infrastructure.tenant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@AllArgsConstructor
public class TenantContextFilter extends OncePerRequestFilter {

    private final TenantService tenantService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CurrentTenantHolder.set(tenantService.tenantByDomain(request.getServerName()));

        log.debug("Set Tenant {} for server name {}", CurrentTenantHolder.get(), request.getServerName());

        filterChain.doFilter(request, response);

        log.debug("Reset from tenant {}", CurrentTenantHolder.get());
        CurrentTenantHolder.reset();
    }
}
