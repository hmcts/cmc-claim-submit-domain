package uk.gov.hmcts.cmc.domain.models.payment;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountPayment implements Payment {

    @NotBlank
    private String feeAccountNumber;
}
