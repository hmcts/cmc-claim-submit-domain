package uk.gov.hmcts.cmc.domain.models.timeline;

import uk.gov.hmcts.cmc.domain.models.common.CollectionId;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Getter
public class TimelineEvent extends CollectionId {

    @NotBlank
    @Size(max = 20)
    private final String date;

    @NotBlank
    @Size(max = 99000)
    private final String description;

    @Builder
    public TimelineEvent(String id, String eventDate, String description) {
        super(id);
        this.date = eventDate;
        this.description = description;
    }

}
