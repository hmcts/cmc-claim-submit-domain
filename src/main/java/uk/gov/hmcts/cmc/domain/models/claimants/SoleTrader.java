package uk.gov.hmcts.cmc.domain.models.claimants;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SoleTrader extends Party {

    private String title;

    private String businessName;

}
