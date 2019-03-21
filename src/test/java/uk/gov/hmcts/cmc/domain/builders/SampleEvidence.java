package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.evidence.Evidence;

import static java.util.Collections.singletonList;

public class SampleEvidence {

    public static Evidence validDefaults() {
        Evidence evidence = new Evidence();
        evidence.setRows(singletonList(SampleEvidenceRow.validDefaults()));

        return evidence;
    }

}
