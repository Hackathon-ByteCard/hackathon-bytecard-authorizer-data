package com.bytecode.authorizer_data.infra.database.repositories;

import com.bytecode.authorizer_data.infra.database.models.CardCanceledAuthorizationModel;
import com.bytecode.authorizer_data.infra.database.repositories.jpa.CardCanceledAuthorizationJPARepository;
import com.bytecode.authorizer_domain.card.Card;
import com.bytecode.authorizer_domain.conciliation.Cancellation;
import com.bytecode.authorizer_domain.conciliation.CancellationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Repository

public class CardCanceledAuthorizationRepositoryImpl implements CancellationRepository {
    private final CardCanceledAuthorizationJPARepository jpaRepository;

    @Override
    public void save(Cancellation cancellation) {
        CardCanceledAuthorizationModel model = fromEntity(cancellation);
        jpaRepository.save(model);
    }

    @Override
    public int count(Card card, LocalDateTime localDateTime) {
        return jpaRepository.countByPanRefAndTransactionTimeAfter(convertUUIDToBytes(card.getPan()), localDateTime);
    }

    private CardCanceledAuthorizationModel fromEntity(Cancellation cancellation) {
        CardCanceledAuthorizationModel model = new CardCanceledAuthorizationModel();

        model.setPanRef(convertUUIDToBytes(cancellation.getCard().getPan()));
        model.setAuthorizationCode(convertUUIDToBytes(cancellation.getOriginAuthorization().getCode()));
        model.setTransactionTime(cancellation.getCanceledAt());

        return model;
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
