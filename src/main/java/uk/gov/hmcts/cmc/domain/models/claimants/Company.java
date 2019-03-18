package uk.gov.hmcts.cmc.domain.models.claimants;

import uk.gov.hmcts.cmc.domain.models.common.Address;
import uk.gov.hmcts.cmc.domain.models.common.Representative;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class Company extends Party implements HasContactPerson {

    private final String contactPerson;

    @Builder
    public Company(
        String id,
        String name,
        Address address,
        Address correspondenceAddress,
        String mobilePhone,
        Representative representative,
        String contactPerson
    ) {
        super(id, name, address, correspondenceAddress, mobilePhone, representative);
        this.contactPerson = contactPerson;
    }

    public Optional<String> getContactPerson() {
        return Optional.ofNullable(contactPerson);
    }

}
