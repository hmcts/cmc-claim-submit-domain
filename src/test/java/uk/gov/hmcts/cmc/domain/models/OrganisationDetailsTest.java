package uk.gov.hmcts.cmc.domain.models;

import uk.gov.hmcts.cmc.domain.builders.SampleTheirDetails;
import uk.gov.hmcts.cmc.domain.models.otherparty.OrganisationDetails;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class OrganisationDetailsTest {

    @Test
    public void shouldBeValidWhenGivenNullContactPerson() {
        OrganisationDetails organisationDetails = SampleTheirDetails.builder()
            .withContactPerson(null)
            .organisationDetails();

        Set<String> validationErrors = validate(organisationDetails);

        assertThat(validationErrors).isEmpty();
    }

    @Test
    public void shouldBeValidWhenGivenEmptyContactPerson() {
        OrganisationDetails organisationDetails = SampleTheirDetails.builder()
            .withContactPerson("")
            .organisationDetails();

        Set<String> validationErrors = validate(organisationDetails);

        assertThat(validationErrors).isEmpty();
    }

}
