package com.rohitsurya2809.vaultedge.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="transactions")
@Getter @Setter @NoArgsConstructor
public class Transaction {
  @Id
  private UUID id = UUID.randomUUID();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="account_id")
  private Account account;

  private String type; // DEPOSIT, WITHDRAWAL, TRANSFER_DEBIT, TRANSFER_CREDIT

  @Column(precision=18, scale=2)
  private BigDecimal amount;

  @Column(precision=18, scale=2)
  private BigDecimal balanceAfter;

  private UUID referenceId; // link transfer pairs
  private String status = "SUCCESS";
}

