package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauceProductoValidacionScreen extends PageObject {


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/cartTV']")
    private WebElement cartItem;

    public void verifyProductInCart() {
        // Localiza el elemento con el ID "com.saucelabs.mydemoapp.android:id/noTV"
        WebElement noTVElement = getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/noTV"));

        // Obtén el texto del elemento cartItem
        String cartItemText = cartItem.getText();

        // Obtén el texto del elemento noTVElement
        String noTVText = noTVElement.getText();

        // Compara los dos valores
        Assert.assertEquals("El carrito no se actualizó correctamente", noTVText, cartItemText);
    }

}
