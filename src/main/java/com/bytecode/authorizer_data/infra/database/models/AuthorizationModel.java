package com.bytecode.authorizer_data.infra.database.models;

import com.bytecode.authorizer_domain.authorization.AuthorizationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "authorization")
@Data
public class AuthorizationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_id", nullable = false)
    private BigInteger authorizationId;

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
}