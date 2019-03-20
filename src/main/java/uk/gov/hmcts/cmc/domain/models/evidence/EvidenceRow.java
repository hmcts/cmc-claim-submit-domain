package uk.gov.hmcts.cmc.domain.models.evidence;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EvidenceRow {

    private String id;

    @NotNull
    private final EvidenceType type;

    @Size(max = 99000)
    private final String description;

}
