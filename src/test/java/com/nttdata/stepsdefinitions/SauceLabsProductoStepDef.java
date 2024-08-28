package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceLabsProductoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SauceLabsProductoStepDef {

    @Steps
    SauceLabsProductoSteps login;
    @Steps
    SauceLabsProductoSteps carga;
    @Steps
    SauceLabsProductoSteps products;
    @Steps
    SauceLabsProductoSteps cartScreen;


    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        login. validarPaginaInicio();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        if (carga == null) {
            throw new AssertionError("La instancia 'carga' es null. Verifica la inicialización.");
        }
        carga.ValidarCargaProductos();

    }

    @When("^agrego (\\d+) del siguiente producto \"([^\"]*)\"$")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        products.addProductToCart(producto, unidades);
    }


    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        cartScreen.verifyCartUpdated();
    }
}
