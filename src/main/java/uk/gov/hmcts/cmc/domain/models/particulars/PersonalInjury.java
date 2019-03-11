package uk.gov.hmcts.cmc.domain.models.particulars;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode
public class PersonalInjury {

    @NotNull
    private final DamagesExpectation generalDamages;

    public PersonalInjury(@JsonProperty("generalDamages") DamagesExpectation generalDamages) {
        this.generalDamages = generalDamages;
    }

    public DamagesExpectation getGeneralDamages() {
        return generalDamages;
    }

}
