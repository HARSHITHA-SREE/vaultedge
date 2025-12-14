package com.rohitsurya2809.vaultedge.repository;

import com.rohitsurya2809.vaultedge.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {
}
