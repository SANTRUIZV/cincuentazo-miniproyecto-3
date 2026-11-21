package com.example.cincuentazo;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Punto de entrada de la aplicación JavaFX del Cincuentazo.
 *
 * @author Santiago Ruiz Vanegas
 * @author Jose Luis Valencia
 * @author Juan Manuel Cadena
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Abre la ventana principal del juego.
     * <p>
     * Por ahora muestra una ventana vacía. Cuando exista {@code WelcomeStage}
     * se reemplaza por {@code WelcomeStage.getInstance().show()}.
     *
     * @param stage ventana que entrega JavaFX
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Cincuentazo");
        stage.show();
    }
}
