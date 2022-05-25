package tests.zoloft.tests;

import tests.zoloft.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class NaumanTests extends TestBase {

    @Test
    @Description("Проверка работы страницы Network manager")
    @DisplayName("Naumen Network Manager")
    void networkManagerPageTest() {
        step("Открываем сайт Naumen", () -> {
           mainPage.openPage();
        });

        step("Перейти на страницу продуктов", () -> {
            mainPage.productTransfer();
        });
        step("Переходим на страницу Naumen Network Manager", () -> {
            productPage.networkManagerTransfer();
        });
        step("Проверяем, что мы на верной странице", () -> {
            netPage.networkPageCheck();
        });
    }

    @Test
    @Description("Проверка работы поиска по сайту")
    @DisplayName("Поиск по сайту")
    void searchTest() {
        step("Открываем сайт Naumen", () -> {
            mainPage.openPage();
        });

        step("В форме поиска вводим 'контакт-центр'", () -> {
            mainPage.searchTransfer();
        });
        step("В форме поиска вводим 'контакт-центр'", () -> {
            mainPage.searchSubmit();
        });

        step("Проверяем начиличие ключевого слова в поисковой выдаче", () -> {
            searchPage.searchListCheck();
        });
    }

    @Test
    @Description("Проверка наличия Title на странице")
    @DisplayName("Заголовок страницы должен иметь заголовок")
    void titleTest() {
        step("Открываем сайт Naumen", () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие Title", () -> {
            String expectedTitle = "NAUMEN - информационные системы управления растущим бизнесом";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Проверка наличия ошибок в консоли")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт Naumen", () -> {
            mainPage.openPage();
        });

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
