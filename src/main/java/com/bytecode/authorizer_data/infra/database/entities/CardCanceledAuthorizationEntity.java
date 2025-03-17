package com.bytecode.authorizer_data.infra.database.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_canceled_authorization")
public class CardCanceledAuthorizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_canceled_authorization_id")
    private BigInteger id;

    @Column(name = "card_id", nullable = false)
    private BigInteger cardId;

    @Column(name = "authorization_id", nullable = false)
    private BigInteger authorizationId;

    @Column(name = "transaction_time", nullable = false)
    private LocalDateTime transactionTime;

    public BigInteger getCardId() {
        return cardId;
    }

    public void setCardId(BigInteger cardId) {
        this.cardId = cardId;
    }

    public BigInteger getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(BigInteger authorizationId) {
        this.authorizationId = authorizationId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
