import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Домашний интернет")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера Номер абонента")
    @Test
    void checkPlaceholderPhoneText() {
        assertEquals("Номер абонента", checkBlock.getPlaceholderPhoneText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Домашний интернет")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера Сумма")
    @Test
    void checkPlaceholderSumText() {
        assertEquals("Сумма", checkBlock.getPlaceholderSumText());
    }

    @Epic("Тестирование mts.by main Page")
    @Feature("Блок Домашний интернет")
    @Story("Плейсхолдеры")
    @DisplayName("Проврека текста плейсходлера E-mail")
    @Test
    void checkPlaceholderEmailText() {
        assertEquals("E-mail для отправки чека", checkBlock.getPlaceholderEmailText());
    }
}