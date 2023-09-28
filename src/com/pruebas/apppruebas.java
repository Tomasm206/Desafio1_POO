package com.pruebas;

import com.juegoPPT.dominio.Jugada;

import javax.swing.*;
import java.util.Random;

public class apppruebas {
    public static void main(String[] args) {
        jugar();
    }
    public static String comprobarJugada(String jugadaMaquina, String jugadaJugador, int jugador) {
        String [] players = {"Maquina", "Jugador"};
        boolean comprobar = (jugador != 0); //Si el jugador es 0, bool False <--> Si es 1, bool True
        System.out.println(jugadaMaquina + "\n" + jugadaJugador);
        if (jugadaMaquina.equals(jugadaJugador)) {
            return "Empate";
        } else if ((jugadaMaquina.equals("Piedra") && jugadaJugador.equals("Tijeras")) ||
                (jugadaMaquina.equals("Papel") && jugadaJugador.equals("Piedra")) ||
                (jugadaMaquina.equals("Tijeras") && jugadaJugador.equals("Papel"))) {
            if (comprobar){
                return  players[0] + " escogió --> " + jugadaJugador + "\n" +
                    players[jugador] + " escogió --> " + jugadaMaquina + "\n"
                    +"Ganó " + players[jugador] + " con la jugada " + jugadaMaquina;
            }else{
                return  players[jugador] + " escogió --> " + jugadaMaquina + "\n" +
                        players[1] + " escogió --> " + jugadaJugador + "\n"
                        +"Ganó " + players[jugador] + " con la jugada " + jugadaMaquina;
            }
        } else {
            return comprobarJugada(jugadaJugador, jugadaMaquina, 1);
        }
    }
    public static void jugar(){
        String[] options = { "Piedra", "Papel", "Tijeras" };
        Random compu = new Random();
        int seleccion = compu.nextInt(options.length);
        String jugador = JOptionPane.showInputDialog(null, "Has tu jugada","PIEDRA, PAPEL O TIJERA", JOptionPane.QUESTION_MESSAGE, null, options, options[0]).toString();
        JOptionPane.showMessageDialog(null, comprobarJugada(options[seleccion], jugador, 0), "PIEDRA, PAPEL O TIJERA", JOptionPane.INFORMATION_MESSAGE,null);
    }


    //Programa principal a corregir

}
