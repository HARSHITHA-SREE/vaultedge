package com.rohitsurya2809.vaultedge.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="accounts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
  @Id
  @Column(columnDefinition = "BINARY(16)", nullable = false)
  @Builder.Default
  private UUID id = UUID.randomUUID();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="customer_id", nullable = false, columnDefinition = "BINARY(16)")
  private Customer customer;

  @Column(name="account_number", unique=true, nullable=false)
  private String accountNumber;

  @Column(name="account_type")
  private String accountType;

  @Column(precision=18, scale=2)
  private BigDecimal balance = BigDecimal.ZERO;

  private String currency = "INR";

  private String status = "ACTIVE";

  @Version
  private Long version;
}
