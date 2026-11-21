/**
 * Módulo de la aplicación Cincuentazo.
 */
module com.example.cincuentazo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cincuentazo to javafx.fxml;
    exports com.example.cincuentazo;

    // Agregar cada línea cuando el paquete tenga su primera clase
    // (Java no deja exportar un paquete vacío):
    exports com.example.cincuentazo.model.card;
    exports com.example.cincuentazo.model.deck;
    exports com.example.cincuentazo.model.exceptions;
    // exports com.example.cincuentazo.model.player;
    // exports com.example.cincuentazo.model.game;
    // exports com.example.cincuentazo.model.threads;
    // exports com.example.cincuentazo.view;
    // opens com.example.cincuentazo.controller to javafx.fxml;
    // exports com.example.cincuentazo.controller;
}
