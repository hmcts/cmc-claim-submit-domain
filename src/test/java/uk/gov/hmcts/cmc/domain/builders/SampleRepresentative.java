package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.common.Representative;
import uk.gov.hmcts.cmc.domain.models.common.Representative.RepresentativeBuilder;

public class SampleRepresentative {

    private SampleRepresentative() {
        super();
    }

    public static RepresentativeBuilder builder() {
        return Representative.builder()
            .organisationName("Trading ltd")
            .organisationAddress(SampleAddress.builder().build())
            .organisationContactDetails(SampleContactDetails.builder().build());
    }
}
