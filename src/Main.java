import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Ventana
        JFrame frame = new JFrame("Herramienta de Visualización de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);
        frame.setVisible(true);
    }

    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel titulo = new JLabel("Visualizacion de Datos");
        titulo.setBounds(140, 20, 200, 25);
        panel.add(titulo);

        JTextField entradaTexto = new JTextField(20);
        entradaTexto.setBounds(100, 70, 200, 25);
        panel.add(entradaTexto);

        JButton boton = new JButton("Hacer Click");
        boton.setBounds(150, 120, 100, 25);
        panel.add(boton);

        JLabel resultadoOraciones = new JLabel("Número de oraciones: ");
        resultadoOraciones.setBounds(100, 160, 200, 25);
        panel.add(resultadoOraciones);

        JLabel resultadoPalabras = new JLabel("Número de palabras: ");
        resultadoPalabras.setBounds(100, 190, 200, 25);
        panel.add(resultadoPalabras);

        JLabel resultadoLetras = new JLabel("Número de letras: ");
        resultadoLetras.setBounds(100, 220, 200, 25);
        panel.add(resultadoLetras);

        JLabel resultadoNumeros = new JLabel("Número de números: ");
        resultadoNumeros.setBounds(100, 250, 200, 25);
        panel.add(resultadoNumeros);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = entradaTexto.getText();

                int numeroOraciones = contarOraciones(texto);
                int numeroPalabras = contarPalabras(texto);
                int numeroLetras = contarLetras(texto);
                int numeroNumeros = contarNumeros(texto);

                resultadoOraciones.setText("Número de oraciones: " + numeroOraciones);
                resultadoPalabras.setText("Número de palabras: " + numeroPalabras);
                resultadoLetras.setText("Número de letras: " + numeroLetras);
                resultadoNumeros.setText("Número de números: " + numeroNumeros);
            }
        });
    }

    private static int contarOraciones(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                contador++;
            }
        }
        return contador;
    }

    private static int contarPalabras(String texto) {
        int contador = 0;
        boolean enPalabra = false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == ' ' || c == '\n' || c == '\t') {
                enPalabra = false;
            } else if (!enPalabra) {
                enPalabra = true;
                contador++;
            }
        }
        return contador;
    }

    private static int contarLetras(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                contador++;
            }
        }
        return contador;
    }

    private static int contarNumeros(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= '0' && c <= '9') {
                contador++;
            }
        }
        return contador;
    }
}
