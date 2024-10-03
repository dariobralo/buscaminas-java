import componentes.CalculadorMemoria;
import controladores.Controlador;
import controladores.ControladorImpl;
import vistas.VentanaJuego;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

//        CalculadorMemoria.imprimirUsoMemoria("Inicio de aplicacion");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controlador controlador = new ControladorImpl();
                VentanaJuego ventana = new VentanaJuego(controlador);
                controlador.setVentanaJuego(ventana);
                ventana.abrirVentana();
            }
        });

//        CalculadorMemoria.imprimirUsoMemoria("Juego cargado");

    }

}