package com.bytecode.authorizer_data.infra.database.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_canceled_authorization")
@Data
public class CardCanceledAuthorizationModel {
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
}
