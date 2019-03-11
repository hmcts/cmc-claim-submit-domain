package uk.gov.hmcts.cmc.domain.models;

import uk.gov.hmcts.cmc.domain.builders.SampleParty;
import uk.gov.hmcts.cmc.domain.models.claimants.Individual;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class IndividualTest {

    @Test
    public void shouldNotRaiseValidationErrorWhenDateOfBirthIsNotProvided() {
        Individual individual = SampleParty.builder()
            .withDateOfBirth(null)
            .individual();

        Set<String> errorMessages = validate(individual);

        assertThat(errorMessages).hasSize(0);
    }

}
