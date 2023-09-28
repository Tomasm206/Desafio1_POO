package com.juegoPPT.dominio;

public class Jugada {
    private static int puntajeMaquina;
    private static int puntajeJugador;
    public static String comprobarJugada(String jugadaMaquina, String jugadaJugador, int jugador) {
        String [] players = {"Maquina", "Jugador"};
        boolean comprobar = (jugador != 0); //Si el jugador es 0, bool False <--> Si es 1, bool True
        if (jugadaMaquina.equals(jugadaJugador)) {
            puntajeMaquina++;
            puntajeJugador++;
            return "Empate";
        } else if ((jugadaMaquina.equals("Piedra") && jugadaJugador.equals("Tijeras")) ||
                (jugadaMaquina.equals("Papel") && jugadaJugador.equals("Piedra")) ||
                (jugadaMaquina.equals("Tijeras") && jugadaJugador.equals("Papel"))) {
            if (comprobar){ //Define a la maquina como ganadora
                puntajeMaquina++;
                puntajeMaquina++;
                return  players[0] + " escogió --> " + jugadaJugador + "\n" +
                        players[jugador] + " escogió --> " + jugadaMaquina + "\n"
                        +"Ganó " + players[jugador] + " con la jugada " + jugadaMaquina;
            }else{ //Define al jugador como ganador
                puntajeJugador++;
                puntajeJugador++;
                return  players[jugador] + " escogió --> " + jugadaMaquina + "\n" +
                        players[1] + " escogió --> " + jugadaJugador + "\n"
                        +"Ganó " + players[jugador] + " con la jugada " + jugadaMaquina;
            }
        } else {
            return comprobarJugada(jugadaJugador, jugadaMaquina, 1);
        }
    }
    public static int getPuntajeMaquina() {
        return puntajeMaquina;
    }
    public static int getPuntajeJugador() {
        return puntajeJugador;
    }
}
