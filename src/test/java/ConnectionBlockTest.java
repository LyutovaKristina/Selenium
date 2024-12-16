import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Услуги связи")
    @Story("Поле Номер счета")
    @DisplayName("Проврека текста плейсходлера Номер телефона")
    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер телефона", checkBlock.getPlaceholderPhoneText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Услуги связи")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера Сумма")
    @Test
    void checkPlaceholderSumText() {
        assertEquals("Сумма", checkBlock.getPlaceholderSumText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Услуги связи")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера E-mail")
    @Test
    void checkPlaceholderEmailText() {
        assertEquals("E-mail для отправки чека", checkBlock.getPlaceholderEmailText());
    }
}