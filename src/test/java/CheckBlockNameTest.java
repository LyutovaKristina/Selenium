import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBlockNameTest extends BaseTest {
    private CheckBlockName checkBlockName;

    @BeforeEach
    public void setPage() {
        checkBlockName = new CheckBlockName(super.driver);
    }

    @Test
    public void testBlockName() {
        assertEquals("Онлайн пополнение\n" + "без комиссии", checkBlockName.getCheckBlockName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    public void testPaymentSystemsVisibility(String alt) {
        assertTrue(checkBlockName.checkPaymentPartnerIsVisible(alt));
    }

    @Test
    public void testMoreInfoLink() {
        checkBlockName.clickMoreInfo();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", currentUrl);
    }
}

