package uk.gov.hmcts.cmc.domain.models.common;

import lombok.Data;

import uk.gov.hmcts.cmc.domain.constraints.PhoneNumber;

import javax.validation.constraints.Email;

@Data
public class ContactDetails {

    @PhoneNumber
    private String phone;

    @Email
    private String email;

    private String dxAddress;

}
