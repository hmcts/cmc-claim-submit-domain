package uk.gov.hmcts.cmc.domain.models.defendants;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import uk.gov.hmcts.cmc.domain.models.claimants.HasContactPerson;
import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import java.util.Optional;

import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
public class CompanyDetails extends TheirDetails implements HasContactPerson {

    @Size(max = 255, message = "may not be longer than {max} characters")
    private final String contactPerson;

    @Builder
    public CompanyDetails(
        String id,
        String name,
        Address address,
        String email,
        Representative representative,
        Address serviceAddress,
        String contactPerson
    ) {
        super(id, name, address, email, representative, serviceAddress);
        this.contactPerson = contactPerson;
    }

    public Optional<String> getContactPerson() {
        return Optional.ofNullable(contactPerson);
    }

}
