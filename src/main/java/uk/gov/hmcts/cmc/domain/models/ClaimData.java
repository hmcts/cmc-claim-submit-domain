package uk.gov.hmcts.cmc.domain.models;

import lombok.Data;

import uk.gov.hmcts.cmc.domain.constraints.EachNotNull;
import uk.gov.hmcts.cmc.domain.models.amount.Amount;
import uk.gov.hmcts.cmc.domain.models.claimants.Party;
import uk.gov.hmcts.cmc.domain.models.defendants.TheirDetails;
import uk.gov.hmcts.cmc.domain.models.evidence.Evidence;
import uk.gov.hmcts.cmc.domain.models.interest.Interest;
import uk.gov.hmcts.cmc.domain.models.particulars.HousingDisrepair;
import uk.gov.hmcts.cmc.domain.models.particulars.PersonalInjury;
import uk.gov.hmcts.cmc.domain.models.payment.Payment;
import uk.gov.hmcts.cmc.domain.models.timeline.Timeline;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class ClaimData {

    private UUID externalId;

    @Valid
    @NotEmpty
    @EachNotNull
    private List<Party> claimants;

    @Valid
    @NotEmpty
    @EachNotNull
    private List<TheirDetails> defendants;

    @Valid
    private Payment payment;

    @Valid
    @NotNull
    private Amount amount;

    @Valid
    private Interest interest;

    @Valid
    private PersonalInjury personalInjury;

    @Valid
    private HousingDisrepair housingDisrepair;

    @Valid
    private Timeline timeline;

    @Valid
    private Evidence evidence;

    @NotBlank
    private String reason;

    @Valid
    private StatementOfTruth statementOfTruth;

    private String feeAccountNumber;

    private String externalReferenceNumber;

    private String preferredCourt;

}
