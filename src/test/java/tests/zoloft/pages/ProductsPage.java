package tests.zoloft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    
    //locator
    SelenideElement
            networkManagerProduct = $$(".about__products__item__title").findBy(Condition.text("Naumen Network Manager"));

    //action
    public void networkManagerTransfer() {
        networkManagerProduct.click();
    }
}
