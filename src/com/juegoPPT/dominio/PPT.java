package com.juegoPPT.dominio;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class PPT {
    private static ImageIcon icon = new ImageIcon(PPT.class.getResource("PPTimg.png"));
    private static final Object[] OPCIONES = Arrays.asList("Ver Instrucciones", "Jugar", "Ver Resultados").toArray();
    public static int mostrarMenu() {
        int opcion = JOptionPane.showOptionDialog(null, "¡Bienvenido!\nJuego Piedra, Papel o Tijera",
                "PIEDRA, PAPEL O TIJERA" , 0,
                JOptionPane.QUESTION_MESSAGE, icon, OPCIONES, null);
        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
        }
        return opcion;
    }
    public static void instrucciones(){
        JOptionPane.showMessageDialog(null, "El objetivo es vencer al oponente seleccionando el arma ganadora según las siguientes reglas:\n" +
                "\n" +
                "La piedra aplasta la tijera. (Gana la piedra.)\n" +
                "La tijera corta el papel. (Gana la tijera.)\n" +
                "El papel envuelve la piedra. (Gana el papel.)\n" +
                "\n"+
                "En caso de empate (que dos jugadores elijan el mismo elemento o que tres jugadores elijan cada uno un objeto distinto), se juega otra vez.");
    }
    public static void jugar(){
        String[] options = { "Piedra", "Papel", "Tijeras" };
        Random compu = new Random();
        int seleccion = compu.nextInt(options.length);
        String jugador = JOptionPane.showInputDialog(null, "Has tu jugada","PIEDRA, PAPEL O TIJERA", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]).toString();
        JOptionPane.showMessageDialog(null, Jugada.comprobarJugada(options[seleccion], jugador, 0), "PIEDRA, PAPEL O TIJERA", JOptionPane.INFORMATION_MESSAGE,icon);
    }
    public static void resultados(){
        JOptionPane.showMessageDialog(null, "Proximamente...");
    }
}
