package org.example;

import org.example.controlador.ControladorTabla;
import org.example.vista.VentanaReptil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaReptil ventana = new VentanaReptil("Reptiles");
        ControladorTabla controlador = new ControladorTabla(ventana);

    }
}


