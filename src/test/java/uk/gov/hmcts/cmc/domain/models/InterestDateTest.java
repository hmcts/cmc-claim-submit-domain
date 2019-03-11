package uk.gov.hmcts.cmc.domain.models;

import uk.gov.hmcts.cmc.domain.builders.SampleInterestDate;
import uk.gov.hmcts.cmc.domain.models.interest.InterestDate;
import uk.gov.hmcts.cmc.domain.models.interest.InterestDate.InterestEndDateType;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;
import static uk.gov.hmcts.cmc.domain.models.interest.InterestDate.InterestDateType.CUSTOM;
import static uk.gov.hmcts.cmc.domain.models.interest.InterestDate.InterestDateType.SUBMISSION;
import static uk.gov.hmcts.cmc.domain.models.interest.InterestDate.InterestEndDateType.SETTLED_OR_JUDGMENT;

public class InterestDateTest {

    @Test
    public void withCustomType_shouldBeSuccessfulValidationWhenDateInThePast() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(CUSTOM)
                .withDate(LocalDate.of(2015, 2, 5))
                .withReason("reason")
                .withEndDateType(InterestEndDateType.SUBMISSION)
                .build();
        //when
        Set<String> errors = validate(interestDate);
        //then
        assertThat(errors).isEmpty();
    }

    @Test
    public void withSubmissionType_shouldBeSuccessfulValidation() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(SUBMISSION)
                .withDate(null)
                .withReason(null)
                .withEndDateType(InterestEndDateType.SUBMISSION)
                .build();
        //when
        Set<String> errors = validate(interestDate);
        //then
        assertThat(errors).isEmpty();
    }

    @Test
    public void withNullType_shouldBeSuccessfulValidation() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(null)
                .withDate(null)
                .withReason(null)
                .withEndDateType(InterestEndDateType.SUBMISSION)
                .build();
        //when
        Set<String> errors = validate(interestDate);
        //then
        assertThat(errors).isEmpty();
    }

    @Test
    public void withCustomType_shouldIsCustomReturnTrue() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(CUSTOM)
                .withDate(LocalDate.of(2015, 2, 5))
                .build();

        //then
        assertThat(interestDate.isCustom()).isEqualTo(true);
    }

    @Test
    public void withCustomType_shouldIsEndDateOnSubmissionReturnFalse() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(CUSTOM)
                .withDate(LocalDate.of(2015, 2, 5))
                .build();

        //then
        assertThat(interestDate.isEndDateOnSubmission()).isEqualTo(false);
    }

    @Test
    public void withSubmissionType_shouldIsCustomReturnFalse() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(SUBMISSION)
                .build();

        //then
        assertThat(interestDate.isCustom()).isEqualTo(false);
    }

    @Test
    public void withSubmissionType_shouldIsEndDateOnClaimCompleteReturnTrueWhenEndDateTypeIsSettledOrJudgment() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(SUBMISSION)
                .withEndDateType(SETTLED_OR_JUDGMENT)
                .build();

        //then
        assertThat(interestDate.isEndDateOnClaimComplete()).isEqualTo(true);
        assertThat(interestDate.isEndDateOnSubmission()).isEqualTo(false);
    }

    @Test
    public void withSubmissionType_shouldIsEndDateOnClaimCompleteReturnFalseWhenEndDateTypeIsSubmission() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(SUBMISSION)
                .withEndDateType(InterestEndDateType.SUBMISSION)
                .build();

        //then
        assertThat(interestDate.isEndDateOnSubmission()).isEqualTo(true);
        assertThat(interestDate.isEndDateOnClaimComplete()).isEqualTo(false);
    }

    @Test
    public void withSubmissionType_shouldIsEndDateOnClaimCompleteReturnFalseWhenEndDateTypeIsSetNull() {
        //given
        InterestDate interestDate = SampleInterestDate.builder()
                .withType(SUBMISSION)
                .withEndDateType(null)
                .build();

        //then
        assertThat(interestDate.isEndDateOnSubmission()).isEqualTo(false);
        assertThat(interestDate.isEndDateOnClaimComplete()).isEqualTo(true);
    }
}
