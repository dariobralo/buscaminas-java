package controladores;

import vistas.VentanaJuego;

public interface Controlador {

    void setVentanaJuego(VentanaJuego ventanaJuego);

    void iniciarJuego(String dificultad);

    void partidaFinalizada();
}
