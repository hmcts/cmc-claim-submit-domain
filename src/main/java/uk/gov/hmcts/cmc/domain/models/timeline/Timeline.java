package uk.gov.hmcts.cmc.domain.models.timeline;

import lombok.Data;

import java.util.List;

import javax.validation.Valid;

@Data
public class Timeline {

    @Valid
    private final List<TimelineEvent> rows;

}
