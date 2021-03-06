package tests.zoloft.tests;

import tests.zoloft.config.Project;
import tests.zoloft.helpers.AllureAttachments;
import tests.zoloft.helpers.DriverSettings;
import tests.zoloft.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.zoloft.pages.MainPage;
import tests.zoloft.pages.NetworkManagerPage;
import tests.zoloft.pages.ProductsPage;
import tests.zoloft.pages.SearchPage;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    MainPage mainPage = new MainPage();
    NetworkManagerPage netPage = new NetworkManagerPage();
    SearchPage searchPage = new SearchPage();
    ProductsPage productPage = new ProductsPage();
    
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
