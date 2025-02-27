package com.example.apptomarfoto.modelsJuego;

public class Piedra extends Jugada{
    @Override
    public String CompararJugada(Jugada otrajugada) {
        if(otrajugada instanceof  Piedra)
            return "Empate";
        else if (otrajugada instanceof  Papel)
            return "Perdiste";
        else
            return "Ganaste";
    }
}
