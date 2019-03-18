package uk.gov.hmcts.cmc.domain.models.evidence;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import uk.gov.hmcts.cmc.domain.models.common.CollectionId;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Getter
public class EvidenceRow extends CollectionId {

    @NotNull
    private final EvidenceType type;

    @Size(max = 99000)
    private final String description;

    @Builder
    public EvidenceRow(String id, EvidenceType type, String description) {
        super(id);
        this.type = type;
        this.description = description;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

}
