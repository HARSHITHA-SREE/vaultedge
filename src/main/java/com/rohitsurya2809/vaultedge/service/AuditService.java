package com.rohitsurya2809.vaultedge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohitsurya2809.vaultedge.model.AuditLog;
import com.rohitsurya2809.vaultedge.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class AuditService {

    private final AuditLogRepository auditLogRepository;
    private final ObjectMapper objectMapper;

    public AuditService(AuditLogRepository auditLogRepository, ObjectMapper objectMapper) {
        this.auditLogRepository = auditLogRepository;
        this.objectMapper = objectMapper;
    }

    public void log(
            String action,
            UUID userId,
            UUID entityId,
            String ipAddress,
            Map<String, Object> details
    ) {
        try {
            String json = details == null ? null : objectMapper.writeValueAsString(details);

            AuditLog log = AuditLog.builder()
                    .action(action)
                    .userId(userId)
                    .entityId(entityId)
                    .ipAddress(ipAddress)
                    .details(json)
                    .createdAt(OffsetDateTime.now())
                    .build();

            auditLogRepository.save(log);
        } catch (Exception ignored) {
            // audit must NEVER break business flow
        }
    }
}
