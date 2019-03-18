package uk.gov.hmcts.cmc.domain.models.interest;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@EqualsAndHashCode
public class InterestAmount {

    private final BigDecimal amount;

    public InterestAmount(@JsonProperty("amount") BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
