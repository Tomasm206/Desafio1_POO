package com.juegoPPT.dominio;

public class Jugada {
    private int puntajeMaquina;
    private int puntajeJugador;
    public int getPuntajeMaquina() {
        return puntajeMaquina;
    }
    public int getPuntajeJugador() {
        return puntajeJugador;
    }
    public static String comprobarJugada(String jugadaMaquina, String jugadaJugador, int jugador) {
        String [] players = {"Maquina", "Jugador"};
        boolean comprobar = (jugador != 0); //Si el jugador es 0, bool False <--> Si es 1, bool True
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

}
