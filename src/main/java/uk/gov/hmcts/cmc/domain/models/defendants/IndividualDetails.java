package uk.gov.hmcts.cmc.domain.models.defendants;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualDetails extends TheirDetails {

    private LocalDate dateOfBirth;

}
