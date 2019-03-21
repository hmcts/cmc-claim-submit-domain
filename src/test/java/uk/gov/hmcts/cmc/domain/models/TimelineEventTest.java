package uk.gov.hmcts.cmc.domain.models;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.builders.SampleTimelineEvent;
import uk.gov.hmcts.cmc.domain.models.timeline.TimelineEvent;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class TimelineEventTest {

    @Test
    public void shouldBeSuccessfulValidationForCorrectTimelineEvent() {
        TimelineEvent timelineEvent = SampleTimelineEvent.validDefaults();

        Set<String> response = validate(timelineEvent);

        assertThat(response).hasSize(0);
    }

    @Test
    public void shouldFailValidationForNullEventDate() {
        TimelineEvent timelineEvent = SampleTimelineEvent.validDefaults();
        timelineEvent.setDate(null);

        Set<String> response = validate(timelineEvent);

        assertThat(response)
            .hasSize(1)
            .contains("date : must not be blank");
    }

    @Test
    public void shouldFailValidationForEmptyEventDate() {
        TimelineEvent timelineEvent = SampleTimelineEvent.validDefaults();
        timelineEvent.setDate("");

        Set<String> response = validate(timelineEvent);

        assertThat(response)
            .hasSize(1)
            .contains("date : must not be blank");
    }

    @Test
    public void shouldFailValidationForNullDescription() {
        TimelineEvent timelineEvent = SampleTimelineEvent.validDefaults();
        timelineEvent.setDescription(null);

        Set<String> response = validate(timelineEvent);

        assertThat(response)
            .hasSize(1)
            .contains("description : must not be blank");
    }

    @Test
    public void shouldFailValidationForEmptyDescription() {
        TimelineEvent timelineEvent = SampleTimelineEvent.validDefaults();
        timelineEvent.setDescription("");

        Set<String> response = validate(timelineEvent);

        assertThat(response)
            .hasSize(1)
            .contains("description : must not be blank");
    }

}
