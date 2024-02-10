package com.ecom.common.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<String> {

    private final HttpServletRequest httpServletRequest;

    public AuditorAwareImpl(HttpServletRequest httpServletRequest){
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(getClientIpAddress(httpServletRequest));
    }

    private String getClientIpAddress(HttpServletRequest httpServletRequest){

        String ipAddress = httpServletRequest.getHeader("X-Fowarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getHeader("Proxy-Client-Ip");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getHeader("WL-Proxy-Client-Ip");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        return ipAddress;
    }
}
