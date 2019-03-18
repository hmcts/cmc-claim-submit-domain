package uk.gov.hmcts.cmc.domain.models.interest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
public class InterestDate {
    public enum InterestDateType {
        @JsonProperty("custom")
        CUSTOM,

        @JsonProperty("submission")
        SUBMISSION
    }

    public enum InterestEndDateType {
        @JsonProperty("settled_or_judgment")
        SETTLED_OR_JUDGMENT,

        @JsonProperty("submission")
        SUBMISSION
    }

    private final InterestDateType type;

    @JsonUnwrapped
    private final LocalDate date;

    private final String reason;

    private final InterestEndDateType endDateType;

    public InterestDate(InterestDateType type, LocalDate date, String reason, InterestEndDateType endDateType) {
        this.type = type;
        this.date = date;
        this.reason = reason;
        this.endDateType = endDateType == null ? InterestEndDateType.SETTLED_OR_JUDGMENT : endDateType;
    }

    public InterestDateType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public InterestEndDateType getEndDateType() {
        return endDateType;
    }

    @JsonIgnore
    public boolean isEndDateOnClaimComplete() {
        return endDateType.equals(InterestEndDateType.SETTLED_OR_JUDGMENT);
    }

    @JsonIgnore
    public boolean isEndDateOnSubmission() {
        return endDateType.equals(InterestEndDateType.SUBMISSION);
    }

    @JsonIgnore
    public boolean isCustom() {
        return type.equals(InterestDate.InterestDateType.CUSTOM);
    }

    @JsonIgnore
    public boolean isValid() {
        return type != null || date != null || reason != null;
    }

}
