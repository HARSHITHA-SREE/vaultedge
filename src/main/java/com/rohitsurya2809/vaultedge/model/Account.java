package com.rohitsurya2809.vaultedge.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="accounts")
@Getter @Setter @NoArgsConstructor
public class Account {
  @Id
  private UUID id = UUID.randomUUID();

  @Column(name="account_number", unique=true, nullable=false)
  private String accountNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="customer_id")
  private Customer customer;

  @Column(name="account_type")
  private String accountType;

  @Column(precision=18, scale=2)
  private BigDecimal balance = BigDecimal.ZERO;

  private String currency = "INR";

  private String status = "ACTIVE";

  @Version
  private Long version;
}

