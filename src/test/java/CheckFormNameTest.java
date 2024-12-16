import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckFormNameTest extends BaseTest {
    private CheckFormName checkFormName;

    @BeforeEach
    void initPage() {
        checkFormName = new CheckFormName(super.driver);
        ConnectionBlock checkBlockName = new ConnectionBlock(super.driver);
        checkBlockName.fillForm("297777777", "300");
        checkFormName.switchToFrame();
    }

    @Test
    public void testWindow() {
        checkFormName.checkFormPaymentAmountContainsText("300.00 BYN");
        checkFormName.checkButtonPaymentAmountContainsText("Оплатить 300.00 BYN");
        checkFormName.checkNumberContainsText("Оплата: Услуги связи Номер:375297777777");
    }

    @Test
    public void testPlaceholder() {
        assertTrue(checkFormName.getNumberCard());
        assertTrue(checkFormName.getValidityPeriod());
        assertTrue(checkFormName.getUserName());
        assertTrue(checkFormName.getUserCode());
    }

    @Test
    public void testIcon() {
        assertTrue(checkFormName.getIconVisa());
        assertTrue(checkFormName.getIconMastercard());
        assertTrue(checkFormName.getIconBelkart());
        assertTrue(checkFormName.getIconMir());
    }
}