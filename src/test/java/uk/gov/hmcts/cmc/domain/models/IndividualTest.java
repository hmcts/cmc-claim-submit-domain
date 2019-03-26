package uk.gov.hmcts.cmc.domain.models;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.models.claimants.Individual;
import uk.gov.hmcts.cmc.domain.samples.SampleParty;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class IndividualTest {

    @Test
    public void shouldNotRaiseValidationErrorWhenDateOfBirthIsNotProvided() {
        Individual individual = SampleParty.individual();
        individual.setDateOfBirth(null);

        Set<String> errorMessages = validate(individual);

        assertThat(errorMessages).hasSize(0);
    }

}
