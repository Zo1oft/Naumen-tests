package tests.zoloft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NetworkManagerPage {
    
    //locator
    SelenideElement
        pageName = $(".products_line__logo");

    //action
    public void networkPageCheck() {
        pageName.shouldHave(Condition.text("Network Manager"));
    }
}
