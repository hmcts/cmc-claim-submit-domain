package uk.gov.hmcts.cmc.domain.models.particulars;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HousingDisrepair {

    @NotNull
    private final DamagesExpectation costOfRepairsDamages;

    private final DamagesExpectation otherDamages;

}
