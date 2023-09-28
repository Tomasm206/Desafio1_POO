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
        JOptionPane.showMessageDialog(null,
                "El objetivo es vencer al oponente seleccionando el arma ganadora según las siguientes reglas:\n" +
                "\n" +
                "La piedra aplasta la tijera. (Gana la piedra y obtiene 2 puntos.)\n" +
                "La tijera corta el papel. (Gana la tijera y obtiene 2 puntos.)\n" +
                "El papel envuelve la piedra. (Gana el papel y obtiene 2 puntos.)\n" +
                "\n"+
                "En caso de empate (Ambos obtienen 1 punto)."
                , "PIEDRA, PAPEL O TIJERA",JOptionPane.INFORMATION_MESSAGE, icon);
    }
    public static void jugar(){
        String[] options = { "Piedra", "Papel", "Tijeras" };
        Random compu = new Random();
        int seleccion = compu.nextInt(options.length);
        String jugador = JOptionPane.showInputDialog(null, "Has tu jugada","PIEDRA, PAPEL O TIJERA", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]).toString();
        JOptionPane.showMessageDialog(null, Jugada.comprobarJugada(options[seleccion], jugador, 0), "PIEDRA, PAPEL O TIJERA", JOptionPane.INFORMATION_MESSAGE,icon);
    }
    public static void resultados(){
        System.out.println(Jugada.getPuntajeMaquina());
        System.out.println(Jugada.getPuntajeJugador());
        JOptionPane.showMessageDialog(null,
                "Los resultados son" + "\n"
                +"La Maquina obtuvo --> " + Jugada.getPuntajeMaquina() + "\n"
                +"El Jugador obtuvo --> " + Jugada.getPuntajeJugador() + "\n"
                +ganador(Jugada.getPuntajeMaquina(),Jugada.getPuntajeJugador())
                , "PIEDRA, PAPEL O TIJERA", JOptionPane.INFORMATION_MESSAGE,icon);
    }
    public static String ganador(int puntajeMaquina, int puntajeJugador) {
        if (puntajeMaquina == puntajeJugador) {
            return "La Maquina y el Jugador quedaron empatados";
        } else if (puntajeMaquina > puntajeJugador) {
            return "La Maquina quedó ganadora";
        } else {
            return "El Jugador quedó ganador";
        }
    }
}
