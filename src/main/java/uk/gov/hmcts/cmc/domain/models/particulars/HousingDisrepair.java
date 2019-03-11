package uk.gov.hmcts.cmc.domain.models.particulars;

import lombok.EqualsAndHashCode;

import java.util.Optional;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
public class HousingDisrepair {

    @NotNull
    private final DamagesExpectation costOfRepairsDamages;

    private final DamagesExpectation otherDamages;

    public HousingDisrepair(DamagesExpectation costOfRepairsDamages, DamagesExpectation otherDamages) {
        this.costOfRepairsDamages = costOfRepairsDamages;
        this.otherDamages = otherDamages;
    }

    public DamagesExpectation getCostOfRepairsDamages() {
        return costOfRepairsDamages;
    }

    public Optional<DamagesExpectation> getOtherDamages() {
        return Optional.ofNullable(otherDamages);
    }

}
