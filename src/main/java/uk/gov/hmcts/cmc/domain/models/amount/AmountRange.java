package uk.gov.hmcts.cmc.domain.models.amount;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import uk.gov.hmcts.cmc.domain.constraints.Money;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Builder
@EqualsAndHashCode
public class AmountRange implements Amount {

    @Money
    @DecimalMin(value = "0.01")
    private final BigDecimal lowerValue;

    @NotNull
    @Money
    @DecimalMin(value = "0.01")
    private final BigDecimal higherValue;

    public AmountRange(BigDecimal lowerValue, BigDecimal higherValue) {
        this.lowerValue = lowerValue;
        this.higherValue = higherValue;
    }

    public Optional<BigDecimal> getLowerValue() {
        return Optional.ofNullable(lowerValue);
    }

    public BigDecimal getHigherValue() {
        return higherValue;
    }

}
