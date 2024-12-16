import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Рассрочка")
    @Story("Поле Номер счета")
    @DisplayName("Проврека текста плейсходлера Номер счета")
    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер счета на 44", checkBlock.getPlaceholderScoreText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Рассрочка")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера Сумма")
    @Test
    void checkPlaceholderSumText() {
        assertEquals("Сумма", checkBlock.getPlaceholderSumText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Рассрочка")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера E-mail")
    @Test
    void checkPlaceholderEmailText() {
        assertEquals("E-mail для отправки чека", checkBlock.getPlaceholderEmailText());
    }
}