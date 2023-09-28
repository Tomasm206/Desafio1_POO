package com.calculadora.dominio;

import javax.swing.*;
import java.util.Arrays;

public class Calculadora {
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;
    private static ImageIcon icono = new ImageIcon(Calculadora.class.getResource("cal.png"));
    private static JCheckBox checkBox = new JCheckBox("¿Desea Redondear?");

    public static int mostrarMenu() {
        Object[] OPCIONES = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", checkBox).toArray();
        int opcion = JOptionPane.showOptionDialog(null, "¡Bienvenido!\n¿Qué operación quieres realizar?\n",
                "CALCULADORA" , 0,
                JOptionPane.QUESTION_MESSAGE, icono, OPCIONES, null);
        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
        }
        return opcion;
    }
    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "CALCULADORA", JOptionPane.INFORMATION_MESSAGE , icono);
    }
    public static double recibirNumero(String mensaje) {
        double numeroARetornar = 0;
        boolean numeroValido = false;

        do {
            try {
                numeroARetornar = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                numeroValido = true;
            } catch (NumberFormatException e) {
                mostrarError("El número no es válido. Ingreselo nuevamente.");
                e.printStackTrace();
            }
        } while (!numeroValido);

        return numeroARetornar;
    }
    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "CALCULADORA", JOptionPane.ERROR_MESSAGE);
    }

    public static void programaPrincipal() {
        do {
            int opcionElegida = Calculadora.mostrarMenu();
            double n1 = Calculadora.recibirNumero("Ingrese el primer número");
            double n2 = Calculadora.recibirNumero("Ingrese el segundo número");
            if (checkBox.isSelected()) {
                switch (opcionElegida) {
                    case SUMAR -> Calculadora.mostrarMensaje("La suma es --> " + Math.round(Operaciones.sumar(n1, n2)));
                    case RESTAR -> Calculadora.mostrarMensaje("La resta es --> " + Math.round(Operaciones.restar(n1, n2)));
                    case MULTIPLICAR -> Calculadora.mostrarMensaje("La multiplicacion es --> " + Math.round(Operaciones.multiplicar(n1, n2)));
                    case DIVIDIR -> Calculadora.mostrarMensaje("La division es --> " + Math.round(Operaciones.dividir(n1, n2)));
                }
            } else {
                switch (opcionElegida) {
                    case SUMAR -> Calculadora.mostrarMensaje("La suma es --> " + Operaciones.sumar(n1, n2));
                    case RESTAR -> Calculadora.mostrarMensaje("La resta es --> " + Operaciones.restar(n1, n2));
                    case MULTIPLICAR -> Calculadora.mostrarMensaje("La multiplicacion es --> " + Operaciones.multiplicar(n1, n2));
                    case DIVIDIR -> Calculadora.mostrarMensaje("La division es --> " + Operaciones.dividir(n1, n2));
                }
            }
        }while (true);
    }
}
