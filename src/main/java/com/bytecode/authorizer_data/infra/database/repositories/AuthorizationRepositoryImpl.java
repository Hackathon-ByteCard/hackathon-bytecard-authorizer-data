package com.bytecode.authorizer_data.infra.database.repositories;

import com.bytecode.authorizer_data.infra.database.models.AuthorizationModel;
import com.bytecode.authorizer_data.infra.database.repositories.jpa.AuthorizationJPARepository;
import com.bytecode.authorizer_domain.authorization.Authorization;
import com.bytecode.authorizer_domain.authorization.AuthorizationFactory;
import com.bytecode.authorizer_domain.authorization.AuthorizationRepository;
import lombok.RequiredArgsConstructor;

import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class AuthorizationRepositoryImpl implements AuthorizationRepository {
    private final AuthorizationJPARepository jpaRepository;

    @Override
    public void save(Authorization authorization) {
        var model = fromEntity(authorization);
        jpaRepository.save(model);
    }

    @Override
    public Optional<Authorization> findOne(UUID uuid) {
        var model = jpaRepository.findByAuthorizationCode(convertUUIDToBytes(uuid));
        return model.map(this::toEntity);
    }

    private AuthorizationModel fromEntity(final Authorization authorization) {
        var model = new AuthorizationModel();

        model.setAmount(authorization.getAmount());
        model.setTransactionDescription(authorization.getDescription());
        model.setTransactionTime(authorization.getTime());
        model.setStatus(authorization.getStatus());
        model.setAuthorizationCode(convertUUIDToBytes(authorization.getCode()));
        model.setPanRef(convertUUIDToBytes(authorization.getPan()));

        return model;
    }

    private Authorization toEntity(final AuthorizationModel record) {
        return AuthorizationFactory.create(
                record.getAmount(),
                record.getTransactionDescription(),
                record.getTransactionTime(),
                record.getStatus(),
                convertBytesToUUID(record.getAuthorizationCode()),
                convertBytesToUUID(record.getPanRef())
        );
    }

    private static byte[] convertUUIDToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    private static UUID convertBytesToUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}
