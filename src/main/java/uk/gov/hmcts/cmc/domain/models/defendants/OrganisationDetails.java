package uk.gov.hmcts.cmc.domain.models.defendants;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrganisationDetails extends TheirDetails {

    private String contactPerson;

    private String companiesHouseNumber;

}
