package uk.gov.hmcts.cmc.domain.models;

import uk.gov.hmcts.cmc.domain.builders.SampleClaimData;
import uk.gov.hmcts.cmc.domain.builders.SampleInterest;
import uk.gov.hmcts.cmc.domain.builders.SampleInterestDate;
import uk.gov.hmcts.cmc.domain.builders.SampleParty;
import uk.gov.hmcts.cmc.domain.builders.SampleTheirDetails;
import uk.gov.hmcts.cmc.domain.models.interest.Interest;
import uk.gov.hmcts.cmc.domain.models.timeline.Timeline;
import uk.gov.hmcts.cmc.domain.models.timeline.TimelineEvent;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;
import static uk.gov.hmcts.cmc.domain.models.interest.Interest.InterestType.STANDARD;

public class ClaimDataTest {

    @Test
    public void shouldBeValidWhenGivenInterestIsValid() {
        //given
        Interest validInterest = SampleInterest
                .builder()
                .withType(STANDARD)
                .withRate(new BigDecimal(8))
                .withReason(null)
                .withInterestBreakdown(null)
                .withInterestDate(SampleInterestDate.validDefaults())
                .withSpecificDailyAmount(null)
                .build();
        ClaimData claimData = SampleClaimData.builder()
            .withInterest(validInterest)
            .build();
        //when
        Set<String> errors = validate(claimData);
        //then
        assertThat(errors).isEmpty();
    }

    @Test
    public void shouldBeInvalidWhenGivenNullDefendants() {
        ClaimData claimData = SampleClaimData.builder()
            .withDefendants(null)
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("defendants : must not be empty");
    }

    @Test
    public void shouldBeInvalidWhenGivenNoDefendants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearDefendants()
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("defendants : must not be empty");
    }

    @Test
    public void shouldBeInvalidWhenGivenNullDefendant() {
        ClaimData claimData = SampleClaimData.builder()
            .withDefendant(null)
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("defendants : each element must be not null");
    }

    @Test
    public void shouldBeInvalidWhenGivenInvalidDefendant() {
        ClaimData claimData = SampleClaimData.builder()
            .withDefendant(SampleTheirDetails.builder()
                .withName("")
                .individualDetails())
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("defendants[0].name : must not be blank");
    }

    @Test
    public void shouldBeInvalidWhenGivenTooManyDefendants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearDefendants()
            .addDefendants(SampleTheirDetails.builder().individualDetails(21))
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("defendants : at most 20 defendants are supported");
    }

    @Test
    public void shouldBeValidWhenGivenTwentyDefendants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearDefendants()
            .addDefendants(SampleTheirDetails.builder().individualDetails(20))
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).isEmpty();
    }

    @Test
    public void shouldBeInvalidWhenGivenNullClaimants() {
        ClaimData claimData = SampleClaimData.builder()
            .withClaimants(null)
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants : must not be empty");
    }

    @Test
    public void shouldBeInvalidWhenGivenNoClaimants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearClaimants()
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants : must not be empty");
    }

    @Test
    public void shouldBeInvalidWhenGivenNullClaimant() {
        ClaimData claimData = SampleClaimData.builder()
            .withClaimant(null)
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants : each element must be not null");
    }

    @Test
    public void shouldBeInvalidWhenGivenInvalidClaimant() {
        ClaimData claimData = SampleClaimData.builder()
            .withClaimant(SampleParty.builder()
                .withName("")
                .individual())
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants[0].name : must not be blank");
    }

    @Test
    public void shouldBeInvalidWhenGivenInvalidClaimantAddress() {
        ClaimData claimData = SampleClaimData.builder()
            .withClaimant(SampleParty.builder()
                .withAddress(null)
                .individual())
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants[0].address : must not be null");
    }

    @Test
    public void shouldBeInvalidWhenGivenTooManyClaimants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearClaimants()
            .addClaimants(SampleParty.builder().individualDetails(21))
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).containsOnly("claimants : at most 20 claimants are supported");
    }

    @Test
    public void shouldBeValidWhenGivenTwentyClaimants() {
        ClaimData claimData = SampleClaimData.builder()
            .clearClaimants()
            .addClaimants(SampleParty.builder().individualDetails(20))
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors).isEmpty();
    }

    @Test
    public void shouldBeInvalidWhenGivenTooManyTimeLineEvents() {
        ClaimData claimData = SampleClaimData.builder()
            .withTimeline(new Timeline(asList(new TimelineEvent[1001])))
            .build();

        Set<String> errors = validate(claimData);

        assertThat(errors)
            .hasSize(1)
            .containsOnly("timeline.events : size must be between 1 and 1000");
    }
}
