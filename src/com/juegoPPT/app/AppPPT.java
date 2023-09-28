package com.juegoPPT.app;

import com.juegoPPT.dominio.PPT;

public class AppPPT {
    public static void main(String[] args) {
        do {
            int opcionElegida = PPT.mostrarMenu();
            switch (opcionElegida) {
                case 0 -> PPT.instrucciones();
                case 1 -> PPT.jugar();
                case 2 -> PPT.resultados();
            }
        }while(true);
    }
}
