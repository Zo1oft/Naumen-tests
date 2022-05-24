package tests.zoloft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //locators
    SelenideElement
            productLink = $$(".link").findBy(Condition.text("Продукты")),
            searchForm = $("input[type=search]"),
            searchButton = $(".ya-site-form__submit");

    //actions
    public MainPage openPage() {
        open("https://www.naumen.ru/");
        return this;
    }

    public void productTransfer() {
        productLink.click();

    }
    public void searchTransfer() {
        searchForm.setValue("контакт-центр");
    }
    
    public void searchSubmit() {
        searchButton.click();
    }
}
