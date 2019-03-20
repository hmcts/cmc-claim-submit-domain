package uk.gov.hmcts.cmc.domain.models.amount;

import lombok.Data;

import uk.gov.hmcts.cmc.domain.constraints.Money;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

@Data
public class AmountRow {

    private String id;

    private String reason;

    @Money
    @DecimalMin(value = "0.01")
    private final BigDecimal amount;

}
