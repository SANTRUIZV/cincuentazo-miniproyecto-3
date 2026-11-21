package com.example.cincuentazo;

import javafx.application.Application;

/**
 * Clase que lanza la aplicación. Sirve para ejecutar el juego
 * desde el IDE sin configurar los módulos de JavaFX a mano.
 *
 * @author Santiago Ruiz Vanegas
 * @author Jose Luis Valencia
 * @author Juan Manuel Cadena
 * @version 1.0
 */
public class Launcher {

    /**
     * Método principal.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
