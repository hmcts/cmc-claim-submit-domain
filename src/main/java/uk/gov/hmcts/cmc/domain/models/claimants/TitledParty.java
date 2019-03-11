package uk.gov.hmcts.cmc.domain.models.claimants;

import java.util.Optional;

public interface TitledParty {
    Optional<String> getTitle();
}
