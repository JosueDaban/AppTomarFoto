package com.example.apptomarfoto.modelsJuego;

import androidx.annotation.NonNull;

public class Papel extends Jugada {
    @Override
    public String CompararJugada(Jugada otrajugada) {
        if (otrajugada instanceof Papel)
            return "Empate";
        else if (otrajugada instanceof Tijera)
            return "Perdiste";
        else
            return "Ganaste";
    }

}
