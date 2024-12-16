import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DebitBlockTest extends BaseTest {
    private DebitBlock checkBlock;

    @BeforeEach
    void initPage() {
        CheckBlockName checkBlockName = new CheckBlockName(super.driver);
        checkBlock = new DebitBlock(super.driver);
        checkBlockName.selectServiceType("Задолженность");
    }

    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер счета на 2073", checkBlock.getPlaceholderPhoneText());
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