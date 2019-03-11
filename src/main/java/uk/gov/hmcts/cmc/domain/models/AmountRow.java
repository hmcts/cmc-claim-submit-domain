package uk.gov.hmcts.cmc.domain.models;

import uk.gov.hmcts.cmc.domain.constraints.Money;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import static uk.gov.hmcts.cmc.domain.utils.ToStringStyle.ourStyle;

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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ourStyle());
    }
}
