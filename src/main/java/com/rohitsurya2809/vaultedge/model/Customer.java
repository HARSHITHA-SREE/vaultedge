package com.rohitsurya2809.vaultedge.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {

    @Id
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name="created_at", columnDefinition = "TIMESTAMP")
    private OffsetDateTime createdAt;

    @Column(name="updated_at", columnDefinition = "TIMESTAMP")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (this.id == null) this.id = UUID.randomUUID();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}
