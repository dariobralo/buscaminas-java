package controladores;

import configuraciones.NivelesConst;
import configuraciones.NivelesEnum;
import vistas.PanelTablero;
import vistas.VentanaJuego;

public class ControladorImpl implements Controlador {

    private VentanaJuego ventanaJuego;
    private PanelTablero nuevaPartida;

    public ControladorImpl() {
    }

    @Override
    public void setVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void iniciarJuego(String dificultad) {

        if (dificultad.equals(NivelesEnum.FACIL.name())){
            nuevaPartida = new PanelTablero(NivelesConst.FILAS_FACIL, NivelesConst.COLUMNAS_FACIL, NivelesConst.MINAS_FACIL);
            ventanaJuego.iniciarPartida(nuevaPartida);

        } else if (dificultad.equals(NivelesEnum.INTERMEDIO.name())) {
            nuevaPartida = new PanelTablero(NivelesConst.FILAS_MEDIO, NivelesConst.COLUMNAS_MEDIO, NivelesConst.MINAS_MEDIO);
            ventanaJuego.iniciarPartida(nuevaPartida);

        } else if (dificultad.equals(NivelesEnum.DIFICIL.name())) {
            nuevaPartida = new PanelTablero(NivelesConst.FILAS_DIFICIL, NivelesConst.COLUMNAS_DIFICIL, NivelesConst.MINAS_DIFICIL);
            ventanaJuego.iniciarPartida(nuevaPartida);

        }
    }

    @Override
    public void partidaFinalizada(){
        ventanaJuego.partidaFinalizada();
    }

}
