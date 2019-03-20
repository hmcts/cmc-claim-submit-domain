package uk.gov.hmcts.cmc.domain.models.claimants;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Organisation extends Party {

    private final String contactPerson;
    private final String companiesHouseNumber;

}
