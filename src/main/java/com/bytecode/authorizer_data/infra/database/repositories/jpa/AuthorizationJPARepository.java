package com.bytecode.authorizer_data.infra.database.repositories.jpa;

import com.bytecode.authorizer_data.infra.database.models.AuthorizationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface AuthorizationJPARepository extends JpaRepository<AuthorizationModel, BigInteger>  {
    Optional<AuthorizationModel> findByAuthorizationCode(byte[] authorizationCode);
}
