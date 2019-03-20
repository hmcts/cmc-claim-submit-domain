package uk.gov.hmcts.cmc.domain.models.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Payment {

    private String id;

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String reference;

    @JsonProperty("date_created")
    private String dateCreated;

    private String status;

}
