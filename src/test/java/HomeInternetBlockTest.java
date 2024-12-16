import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeInternetBlockTest extends BaseTest {
    private HomeInternetBlock checkBlock;

    @BeforeEach
    void initPage() {
        CheckBlockName checkBlockName = new CheckBlockName(super.driver);
        checkBlock = new HomeInternetBlock(super.driver);
        checkBlockName.selectServiceType("Домашний интернет");
    }

    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер абонента", checkBlock.getPlaceholderPhoneText());
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