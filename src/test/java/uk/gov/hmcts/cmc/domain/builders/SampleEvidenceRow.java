package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.evidence.EvidenceRow;

import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.CORRESPONDENCE;

public class SampleEvidenceRow {

    private SampleEvidenceRow() {
        super();
    }

    public static EvidenceRow validDefaults() {
        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setId("d839f2f0-025f-4ee9-9a98-16bbe6ab3b35");
        evidenceRow.setType(CORRESPONDENCE);
        evidenceRow.setDescription("description");

        return evidenceRow;
    }
}
