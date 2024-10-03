package vistas;

import controladores.Controlador;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {

    private Controlador controlador;

    private CardLayout cardLayout;
    private JPanel contenedor;
    private PanelInicio panelInicio;
    private PanelTablero panelTablero;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item1, item2, item3;


    public VentanaJuego(Controlador controlador){
        this.controlador = controlador;
        setTitle("Buscaminas Java");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
    }

    public void iniciarPartida(PanelTablero tablero) {
        this.panelTablero = tablero;
        contenedor.add(panelTablero, "panelTablero");
        cardLayout.show(contenedor, "panelTablero");
        contenedor.remove(panelInicio);
        this.panelInicio = null;
        if (panelTablero.getControlador() == null) {
            panelTablero.setControlador(this.controlador);
        }
    }

    public void partidaFinalizada(){
        panelInicio = new PanelInicio(controlador);
        contenedor.add(panelInicio, "panelInicio");
        cardLayout.show(contenedor, "panelInicio");
        contenedor.remove(panelTablero);
        this.panelTablero = null;
    }

    public void initComponents(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);
        panelInicio = new PanelInicio(controlador);
        contenedor.add(panelInicio, "panelInicio");
        add(contenedor);
        cardLayout.show(contenedor, "panelInicio");

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(240,230,240));
        setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menu.setFont(new Font("Arial", Font.PLAIN, 12));
        menu.setForeground(Color.black);
        menuBar.add(menu);

        item1 = new JMenuItem("Nueva Partida");
        item1.setFont(new Font("Arial", Font.PLAIN, 12));
        item1.setForeground(Color.black);
        item1.addActionListener(e -> {
            if (this.panelInicio==null) this.panelInicio = new PanelInicio(controlador);
            contenedor.add(panelInicio, "panelInicio");
            cardLayout.show(contenedor, "panelInicio");
        });
        menu.add(item1);

        item2 = new JMenuItem("item 2");
        item2.setFont(new Font("Arial", Font.PLAIN, 12));
        item2.setForeground(Color.black);
        item2.addActionListener(e -> {});
//        menu.add(item2);

        item3 = new JMenuItem("item 3");
        item3.setFont(new Font("Arial", Font.PLAIN, 12));
        item3.setForeground(Color.black);
        item3.addActionListener(e -> {});
//        menu.add(item3);
    }

    public void abrirVentana(){
        setVisible(true);
    }

}
