package uk.gov.hmcts.cmc.domain.builders;

import uk.gov.hmcts.cmc.domain.models.amount.AmountRange;

import java.math.BigDecimal;

public class SampleAmountRange {

    private SampleAmountRange() {
        super();
    }

    public static AmountRange validDefaults() {
        AmountRange amountRange = new AmountRange();
        amountRange.setLowerValue(BigDecimal.valueOf(100L));
        amountRange.setHigherValue(BigDecimal.valueOf(99000L));

        return amountRange;

    }
}
