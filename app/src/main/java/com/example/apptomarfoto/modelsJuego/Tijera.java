package com.example.apptomarfoto.modelsJuego;

public class Tijera extends Jugada {
    @Override
    public String CompararJugada(Jugada otrajugada) {
        if(otrajugada instanceof  Tijera)
            return "Empate";
        else if (otrajugada instanceof  Piedra)
            return "Perdiste";
        else
            return "Ganaste";
    }
}
