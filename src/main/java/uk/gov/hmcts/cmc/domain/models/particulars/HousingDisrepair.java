package uk.gov.hmcts.cmc.domain.models.particulars;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HousingDisrepair {

    @NotNull
    private DamagesExpectation costOfRepairsDamages;

    private DamagesExpectation otherDamages;

}
