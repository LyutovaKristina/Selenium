import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstallmentBlockTest extends BaseTest {

    private InstallmentBlock checkBlock;

    @BeforeEach
    void initPage() {
        CheckBlockName checkBlockName = new CheckBlockName(super.driver);
        checkBlock = new InstallmentBlock(super.driver);
        checkBlockName.selectServiceType("Рассрочка");
    }

    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер счета на 44", checkBlock.getPlaceholderScoreText());
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