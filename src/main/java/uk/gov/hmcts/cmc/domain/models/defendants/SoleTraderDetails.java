package uk.gov.hmcts.cmc.domain.models.defendants;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SoleTraderDetails extends TheirDetails {

    private String title;

    private String businessName;
}
