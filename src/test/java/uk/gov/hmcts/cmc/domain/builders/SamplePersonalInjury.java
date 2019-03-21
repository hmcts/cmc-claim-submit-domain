package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.particulars.DamagesExpectation;
import uk.gov.hmcts.cmc.domain.models.particulars.PersonalInjury;

public class SamplePersonalInjury {

    private SamplePersonalInjury() {
        super();
    }

    public static PersonalInjury validDefaults() {

        PersonalInjury personalInjury = new PersonalInjury();
        personalInjury.setGeneralDamages(DamagesExpectation.MORE_THAN_THOUSAND_POUNDS);

        return personalInjury;
    }

}
