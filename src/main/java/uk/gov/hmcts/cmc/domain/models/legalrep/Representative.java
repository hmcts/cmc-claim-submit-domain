package uk.gov.hmcts.cmc.domain.models.legalrep;

import uk.gov.hmcts.cmc.domain.models.Address;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@EqualsAndHashCode
public class Representative {

    @NotBlank
    @Size(max = 255, message = "must be at most {max} characters")
    private final String organisationName;

    @Valid
    @NotNull
    private final Address organisationAddress;

    @Valid
    private final ContactDetails organisationContactDetails;

    public Representative(
        String organisationName,
        Address organisationAddress,
        ContactDetails organisationContactDetails
    ) {
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        this.organisationContactDetails = organisationContactDetails;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public Address getOrganisationAddress() {
        return organisationAddress;
    }

    public Optional<ContactDetails> getOrganisationContactDetails() {
        return Optional.ofNullable(organisationContactDetails);
    }

}
