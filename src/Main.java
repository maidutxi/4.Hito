package src;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VisualizadorFotos().setVisible(true);
            }
        });
    }
}
