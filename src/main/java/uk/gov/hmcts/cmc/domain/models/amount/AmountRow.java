package uk.gov.hmcts.cmc.domain.models.amount;

import uk.gov.hmcts.cmc.domain.constraints.Money;
import uk.gov.hmcts.cmc.domain.models.common.CollectionId;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

@EqualsAndHashCode(callSuper = true)
public class AmountRow extends CollectionId {
    private final String reason;

    @Money
    @DecimalMin(value = "0.01")
    private final BigDecimal amount;

    @Builder
    public AmountRow(String id, String reason, BigDecimal amount) {
        super(id);
        this.reason = reason;
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
