package tests.zoloft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    //locator
    SelenideElement
            searchResultList = $(".b-serp-list");

    //action

    public void searchListCheck() {
        searchResultList.shouldHave(Condition.text("контакт-центр"));
    }
}
