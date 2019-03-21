package uk.gov.hmcts.cmc.domain.models.evidence;

import org.junit.Test;

import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.PHOTO;

public class EvidenceTest {

    @Test
    public void shouldPassValidationForValidEvidence() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setType(PHOTO);
        evidenceRow.setDescription("description");

        Evidence evidence = new Evidence();
        evidence.setRows(asList(evidenceRow));

        Set<String> response = validate(evidence);

        assertThat(response)
            .hasSize(0);
    }

    @Test
    public void shouldPassValidationForMoreEvidences() {
        Evidence evidence = new Evidence();
        evidence.setRows(asList(new EvidenceRow[20]));

        Set<String> response = validate(evidence);

        assertThat(response)
            .hasSize(0);
    }

}
