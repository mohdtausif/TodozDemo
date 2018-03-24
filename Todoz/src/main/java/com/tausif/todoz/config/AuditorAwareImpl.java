package com.tausif.todoz.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>
{
	@Override
	public String getCurrentAuditor() {
		String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		return username;
	}
}
