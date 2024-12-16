import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectionBlockTest extends BaseTest {

    private ConnectionBlock checkBlock;

    @BeforeEach
    void initPage() {
        CheckBlockName checkBlockName = new CheckBlockName(super.driver);
        checkBlock = new ConnectionBlock(super.driver);
        checkBlockName.selectServiceType("Услуги связи");
    }

    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер телефона", checkBlock.getPlaceholderPhoneText());
    }

    @Test
    void checkPlaceholderSumText() {
        assertEquals("Сумма", checkBlock.getPlaceholderSumText());
    }

    @Test
    void checkPlaceholderEmailText() {
        assertEquals("E-mail для отправки чека", checkBlock.getPlaceholderEmailText());
    }
}