package uk.gov.hmcts.cmc.domain.models.evidence;

import org.junit.Test;

import java.util.Set;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.repeat;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.CONTRACTS_AND_AGREEMENTS;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.EXPERT_WITNESS;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.OTHER;
import static uk.gov.hmcts.cmc.domain.models.evidence.EvidenceType.STATEMENT_OF_ACCOUNT;

public class EvidenceRowTest {

    @Test
    public void shouldBeSuccessfulValidationForCorrectEvidenceRow() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setType(EXPERT_WITNESS);
        evidenceRow.setDescription("description");

        Set<String> response = validate(evidenceRow);

        assertThat(response).hasSize(0);
    }

    @Test
    public void shouldBeSuccessfulValidationForNullDescription() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setType(STATEMENT_OF_ACCOUNT);
        evidenceRow.setDescription(null);

        Set<String> response = validate(evidenceRow);

        assertThat(response).hasSize(0);
    }

    @Test
    public void shouldBeSuccessfulValidationForEmptyDescription() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setType(CONTRACTS_AND_AGREEMENTS);
        evidenceRow.setDescription("");

        Set<String> response = validate(evidenceRow);

        assertThat(response).hasSize(0);
    }

    @Test
    public void shouldFailValidationForNullEvidenceType() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setType(null);
        evidenceRow.setDescription("description");

        Set<String> response = validate(evidenceRow);

        assertThat(response)
            .hasSize(1)
            .contains("type : must not be null");
    }

    @Test
    public void shouldFailValidationForTooLongDescription() {

        EvidenceRow evidenceRow = new EvidenceRow();
        evidenceRow.setId(UUID.randomUUID().toString());
        evidenceRow.setType(OTHER);
        evidenceRow.setDescription(repeat("a", 99001));


        Set<String> response = validate(evidenceRow);

        assertThat(response)
            .hasSize(1)
            .contains("description : size must be between 0 and 99000");
    }
}
