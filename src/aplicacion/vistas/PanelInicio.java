package vistas;

import configuraciones.NivelesEnum;
import componentes.BotonesInicio;
import configuraciones.TiemposJugador;
import controladores.Controlador;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {

    private JButton botonFacil, botonMedio, botonDificil;
    private JTextArea textArea;
    private Controlador controlador;

    public PanelInicio(Controlador controlador){
        this.controlador = controlador;
        setSize(400, 500);
        setBackground(new Color(240, 150, 65));
        setLayout(null);
        initComponents();
    }

    public void iniciarJuego(String dificultad){
        JOptionPane.showMessageDialog(null, dificultad);
    }

    public void initComponents(){
        botonFacil = new BotonesInicio(NivelesEnum.FACIL.name(), 115, 55);
        botonFacil.addActionListener(e -> controlador.iniciarJuego(NivelesEnum.FACIL.name()));
        add(botonFacil);
        botonMedio = new BotonesInicio(NivelesEnum.INTERMEDIO.name(), 115, 125);
        botonMedio.addActionListener(e -> controlador.iniciarJuego(NivelesEnum.INTERMEDIO.name()));
        add(botonMedio);
        botonDificil = new BotonesInicio(NivelesEnum.DIFICIL.name(), 115, 195);
        botonDificil.addActionListener(e -> controlador.iniciarJuego(NivelesEnum.DIFICIL.name()));
        add(botonDificil);

        textArea = new JTextArea("Record partida fácil:\t" + TiemposJugador.getRecordFacil()
                + " segundos.\n\nRecord partida intermedio:\t" + TiemposJugador.getRecordIntermedio()
                + " segundos.\n\nRecord partida difícil:\t" + TiemposJugador.getRecordDificil()
                + " segundos." );
        textArea.setFont(new Font("Arial", Font.BOLD, 12));
        textArea.setBounds(70, 300, 350, 170);
        textArea.setBackground(new Color(240, 150, 65));
        add(textArea);
    }


}
