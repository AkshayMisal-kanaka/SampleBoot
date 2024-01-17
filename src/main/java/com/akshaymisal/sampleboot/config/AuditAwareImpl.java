package com.akshaymisal.sampleboot.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<Integer> {

	/**
	 * Returns the current auditor of the application.
	 *
	 * @return the current auditor.
	 */
	@Override
	public Optional<Integer> getCurrentAuditor() {
		return Optional.of(1);
	}

}
