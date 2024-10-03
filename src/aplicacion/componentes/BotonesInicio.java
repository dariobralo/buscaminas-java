package componentes;

import javax.swing.*;
import java.awt.*;

public class BotonesInicio extends JButton {

    private int width = 150;
    private int height = 45;
    private String titulo;

    public BotonesInicio(String titulo, int x, int y) {
        super.setText(titulo);
        this.titulo = titulo;
        setBounds(x, y, this.width, this.height);
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 12));
        setForeground(Color.ORANGE);
        setBackground(Color.gray);

    }

    //Getters and Setters
    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
