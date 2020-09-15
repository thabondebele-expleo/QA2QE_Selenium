package PageObjects;

import org.openqa.selenium.WebElement;

public class HomePageObjects {

    private WebElement select;

    public void HomePage (String HomePage) throws InterruptedException {
        select.clear();
        select.sendKeys(HomePage);
        select.sendKeys();
    }
}