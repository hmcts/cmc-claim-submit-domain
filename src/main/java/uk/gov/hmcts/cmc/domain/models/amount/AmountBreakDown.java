package uk.gov.hmcts.cmc.domain.models.amount;

import lombok.Data;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class AmountBreakDown implements Amount {

    @Valid
    @NotNull
    private final List<AmountRow> rows;

}
