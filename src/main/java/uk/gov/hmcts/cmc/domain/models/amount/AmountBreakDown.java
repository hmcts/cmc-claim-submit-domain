package uk.gov.hmcts.cmc.domain.models.amount;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@EqualsAndHashCode
public class AmountBreakDown implements Amount {

    @Valid
    @NotNull
    @Size(max = 1000)
    private final List<AmountRow> rows;

    public AmountBreakDown(@JsonProperty("rows") List<AmountRow> rows) {
        this.rows = rows;
    }

    public List<AmountRow> getRows() {
        return rows;
    }

}
