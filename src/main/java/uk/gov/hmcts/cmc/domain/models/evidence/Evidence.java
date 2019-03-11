package uk.gov.hmcts.cmc.domain.models.evidence;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@EqualsAndHashCode
public class Evidence {

    @Valid
    @Size(max = 1000)
    private final List<EvidenceRow> rows;

    public Evidence(@JsonProperty("rows") List<EvidenceRow> rows) {
        this.rows = rows;
    }

    public List<EvidenceRow> getRows() {
        return rows;
    }

}
