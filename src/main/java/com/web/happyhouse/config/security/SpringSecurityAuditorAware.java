package com.web.happyhouse.config.security;

import com.web.happyhouse.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {

        Optional<String> username = SecurityUtil.getCurrentUsername();
        return Optional.ofNullable(username.isPresent() ? Long.parseLong(username.get()) : null);

    }
}
