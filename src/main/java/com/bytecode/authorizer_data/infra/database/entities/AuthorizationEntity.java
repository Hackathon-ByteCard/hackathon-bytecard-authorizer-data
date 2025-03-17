package com.bytecode.authorizer_data.infra.database.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "authorization")
public class AuthorizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_id", nullable = false)
    private BigInteger authorization_id;

    @Column(name = "transaction_description", nullable = false)
    private String transactionDescription;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_time", nullable = false)
    private LocalDateTime transactionTime;

    @Column(name = "pan_ref", nullable = false)
    private byte[] panRef;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AuthorizationStatus status;

    @Column(name = "authorization_code", nullable = false)
    private byte[] authorizationCode;

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public byte[] getPanRef() {
        return panRef;
    }

    public void setPanRef(byte[] panRef) {
        this.panRef = panRef;
    }

    public AuthorizationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthorizationStatus status) {
        this.status = status;
    }

    public byte[] getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(byte[] authorizationCode) {
        this.authorizationCode = authorizationCode;
    }
}