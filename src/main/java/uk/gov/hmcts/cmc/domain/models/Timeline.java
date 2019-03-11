package uk.gov.hmcts.cmc.domain.models;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@EqualsAndHashCode
public class Timeline {

    @Valid
    @Size(min = 1, max = 1000)
    @JsonProperty("rows")
    private final List<TimelineEvent> events;

    public Timeline(@JsonProperty("rows") List<TimelineEvent> events) {
        this.events = events;
    }

    public List<TimelineEvent> getEvents() {
        return events;
    }

}
