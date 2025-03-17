package com.bytecode.authorizer_data.infra.database.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "card")
public class CardEntity {
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

    public byte[] getPanRef() {
        return panRef;
    }

    public void setPanRef(byte[] panRef) {
        this.panRef = panRef;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getBlockedSince() {
        return blockedSince;
    }

    public void setBlockedSince(LocalDateTime blockedSince) {
        this.blockedSince = blockedSince;
    }
}
