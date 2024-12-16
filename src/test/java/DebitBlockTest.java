import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DebitBlockTest extends BaseTest {
    private DebitBlock checkBlock;
    private CheckBlockName checkBlockName;

    @BeforeEach
    void initPage() {
        checkBlockName = new CheckBlockName(super.driver);
        checkBlock = new DebitBlock(super.driver);
        checkBlockName.selectServiceType("Задолженность");
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Задолженность")
    @Story("Поле Номер счета")
    @DisplayName("Проврека текста плейсходлера Номер счета")
    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер счета на 2073", checkBlock.getPlaceholderPhoneText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Задолженность")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера Сумма")
    @Test
    void checkPlaceholderSumText() {
        assertEquals("Сумма", checkBlock.getPlaceholderSumText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Задолженность")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера E-mail")
    @Test
    void checkPlaceholderEmailText() {
        assertEquals("E-mail для отправки чека", checkBlock.getPlaceholderEmailText());
    }
}