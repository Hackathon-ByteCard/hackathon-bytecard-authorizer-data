package com.bytecode.authorizer_data.infra.database.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "card")
@Data
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private BigInteger id;

    @Column(name = "pan_ref", nullable = false)
    private byte[] panRef;

    @Column(name = "customer_id", nullable = false)
    private BigInteger customerId;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "blocked_since")
    private LocalDateTime blockedSince;
}
