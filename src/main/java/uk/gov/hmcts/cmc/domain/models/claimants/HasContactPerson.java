package uk.gov.hmcts.cmc.domain.models.claimants;

import java.util.Optional;

public interface HasContactPerson {

    Optional<String> getContactPerson();

}