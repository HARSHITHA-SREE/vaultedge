package com.rohitsurya2809.vaultedge.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String action; // DEPOSIT, WITHDRAW, TRANSFER, LOGIN_SUCCESS, LOGIN_FAILED

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "entity_id")
    private UUID entityId;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(columnDefinition = "JSON")
    private String details;

    @Column(nullable = false)
    private OffsetDateTime createdAt;
}
