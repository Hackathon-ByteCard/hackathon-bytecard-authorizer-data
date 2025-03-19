package com.bytecode.authorizer_data.infra.database.repositories;

import com.bytecode.authorizer_domain.authorization.Authorization;
import com.bytecode.authorizer_domain.authorization.AuthorizationFactory;
import com.bytecode.authorizer_domain.card.Card;
import com.bytecode.authorizer_domain.card.CardFactory;
import com.bytecode.authorizer_domain.conciliation.Cancellation;
import com.bytecode.authorizer_domain.conciliation.CancellationFactory;
import com.bytecode.authorizer_domain.conciliation.CancellationRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CardCanceledAuthorizationRepositoryImplTest {
    private final CancellationRepository cancellationRepository;

    public CardCanceledAuthorizationRepositoryImplTest(@Autowired CancellationRepository cancellationRepository) {
        this.cancellationRepository = cancellationRepository;
    }

    @Test
    void saveTest() {
        Card card = CardFactory.newCard(BigDecimal.valueOf(50000));
        Authorization authorization = AuthorizationFactory.newAuthorization(
                BigDecimal.valueOf(3000),
                "some description",
                LocalDateTime.now(),
                card.getPan()
        );
        Cancellation cancellation = CancellationFactory.newCancellation(card, authorization);
        cancellationRepository.save(cancellation);
    }
}