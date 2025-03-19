package com.bytecode.authorizer_data.infra.database.repositories.jpa;

import com.bytecode.authorizer_data.infra.database.models.CardCanceledAuthorizationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface CardCanceledAuthorizationJPARepository extends JpaRepository<CardCanceledAuthorizationModel, BigInteger> {
    int countByPanRefAndTransactionTimeAfter(byte[] panRef, LocalDateTime localDateTime);
}
