package com.nttdata.steps;

import com.nttdata.screens.SauceProductoLoginScreen;
import com.nttdata.screens.SauceProductoValidacionScreen;

public class SauceLabsProductoSteps {

    SauceProductoLoginScreen login;
    SauceProductoLoginScreen carga;
    SauceProductoLoginScreen products;
    SauceProductoValidacionScreen cartScreen;


    public void validarPaginaInicio() {
        login.validarInicio();

    }

    public void ValidarCargaProductos() {
        carga.validarCarga();
    }

    public void addProductToCart(String productName, int unidades) {
        products.selectProduct(productName);
        products.setProductUnits(unidades);
        products.addToCart();
    }

    public void verifyCartUpdated() {
        cartScreen.verifyProductInCart();
    }
}
