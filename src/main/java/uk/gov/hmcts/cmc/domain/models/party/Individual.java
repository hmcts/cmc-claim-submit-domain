package uk.gov.hmcts.cmc.domain.models.party;

import uk.gov.hmcts.cmc.domain.models.Address;
import uk.gov.hmcts.cmc.domain.models.legalrep.Representative;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class Individual extends Party {

    @JsonUnwrapped
    private final LocalDate dateOfBirth;

    @Builder
    public Individual(
        String id,
        String name,
        Address address,
        Address correspondenceAddress,
        String mobilePhone,
        Representative representative,
        LocalDate dateOfBirth
    ) {
        super(id, name, address, correspondenceAddress, mobilePhone, representative);
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
