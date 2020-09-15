package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageObjects {

    private WebElement select;

    public void SelectProduct(String SelectProduct) throws InterruptedException {
        select.clear();
        select.sendKeys(SelectProduct);
        select.sendKeys();
    }
    }

