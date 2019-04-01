package uk.gov.hmcts.cmc.domain.models.payment;

import org.junit.Test;

import uk.gov.hmcts.cmc.domain.models.payment.Payment;
import uk.gov.hmcts.cmc.domain.samples.SamplePayment;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmcts.cmc.domain.BeanValidator.validate;

public class PaymentTest {

    @Test
    public void shouldBeSuccessfulValidationForPayment() {
        //given
        Payment payment = SamplePayment.validDefaults();
        //when
        Set<String> errors = validate(payment);
        //then
        assertThat(errors).isNotNull().hasSize(0);
    }

}
