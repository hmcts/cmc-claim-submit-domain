package uk.gov.hmcts.cmc.domain.models;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.builders.SampleTimeline;
import uk.gov.hmcts.cmc.domain.models.timeline.Timeline;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class TimelineTest {

    @Test
    public void shouldPassValidationForValidTimeline() {
        Timeline timeline = SampleTimeline.validDefaults();

        Set<String> response = validate(timeline);

        assertThat(response).hasSize(0);
    }

}
