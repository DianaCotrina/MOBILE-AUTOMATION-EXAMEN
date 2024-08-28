package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SauceProductoLoginScreen extends PageObject {


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]" )
    private WebElement imgInicio;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup")
    private List<WebElement>  cargaProducto;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/cartTV\"]")
    private WebElement cartItem;



    public void validarInicio() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(imgInicio));
    }

    public void validarCarga() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOfAllElements(cargaProducto)); // Espera hasta que al menos un elemento sea visible

        if (cargaProducto == null || cargaProducto.isEmpty()) {
            throw new AssertionError("No se encontró ningún producto en la galería.");
        }

        // Opcional: Validación adicional si quieres asegurarte de que los productos sean visibles
        for (WebElement producto : cargaProducto) {
            if (!producto.isDisplayed()) {
                throw new AssertionError("Uno o más productos no son visibles en la galería.");
            }
        }
    }


    public void selectProduct(String productName){
        String xpath = "//android.widget.ImageView[@content-desc='" + productName + "']";
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);

// Encuentra el elemento utilizando el XPath dinámico
        WebElement productoelegido = getDriver().findElement(By.xpath(xpath));

// Espera hasta que el elemento sea visible
        WebElement producto = wait.until(ExpectedConditions.visibilityOf(productoelegido));

// Verifica si el producto es clicable antes de intentar hacer clic
        wait.until(ExpectedConditions.elementToBeClickable(producto));

// Haz clic en el producto para seleccionarlo
        producto.click();
    }

    public void setProductUnits(int unidades) {
        // Localiza los elementos de "+" y "-" para ajustar la cantidad
        WebElement incrementButton = getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/minusIV"));
        WebElement decrementButton = getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/plusIV"));
        WebElement quantityText = getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/noTV"));

        // Obtiene la cantidad actual
        int currentQuantity = Integer.parseInt(quantityText.getText());

        // Ajusta la cantidad según sea necesario
        while (currentQuantity < unidades) {
            incrementButton.click();
            currentQuantity++;
        }

        while (currentQuantity > unidades) {
            decrementButton.click();
            currentQuantity--;
        }

    }

    public void addToCart() {
        addToCartButton.click();

    }


}
