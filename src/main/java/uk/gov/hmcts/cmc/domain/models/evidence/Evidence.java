package uk.gov.hmcts.cmc.domain.models.evidence;

import lombok.Data;

import java.util.List;

import javax.validation.Valid;

@Data
public class Evidence {

    @Valid
    private List<EvidenceRow> rows;

}
