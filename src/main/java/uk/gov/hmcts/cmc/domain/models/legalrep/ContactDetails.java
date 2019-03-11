package uk.gov.hmcts.cmc.domain.models.legalrep;

import uk.gov.hmcts.cmc.domain.constraints.PhoneNumber;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Builder
@EqualsAndHashCode
public class ContactDetails {

    @PhoneNumber
    private final String phone;

    @Email
    private final String email;

    @Size(max = 255, message = "must be at most {max} characters")
    private final String dxAddress;

    public ContactDetails(String phone, String email, String dxAddress) {
        this.phone = phone;
        this.email = email;
        this.dxAddress = dxAddress;
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phone);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getDxAddress() {
        return Optional.ofNullable(dxAddress);
    }

}
