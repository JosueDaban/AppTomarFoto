package com.example.apptomarfoto;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apptomarfoto.modelsJuego.Jugada;
import com.example.apptomarfoto.modelsJuego.Papel;
import com.example.apptomarfoto.modelsJuego.Piedra;
import com.example.apptomarfoto.modelsJuego.Tijera;

import java.util.Random;

public class ActividadJuego extends AppCompatActivity {
    RadioButton rbPapel,rbPiedra,rbTijera;
    TextView lbRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbPapel=findViewById(R.id.rbPapel);
        rbPiedra=findViewById(R.id.rbPiedra);
        rbTijera=findViewById(R.id.rbTtijera);
        lbRespuesta=findViewById(R.id.lbRespuesta);
    }
    public void calcularResultado(View boton) {

        Jugada oJugada = null;
        if (rbPiedra.isChecked()){
            oJugada = new Piedra();
        } else if (rbPapel.isChecked()) {
            oJugada = new Papel();
        }else if (rbTijera.isChecked()){
            oJugada = new Tijera();
        }
        if (oJugada == null) {
            lbRespuesta.setText("Selecciona una opción antes de continuar.");
            return;
        }

        Jugada[] opciones = {new Piedra(), new Papel(), new Tijera()};
        Jugada dispositivo = opciones[new Random().nextInt(opciones.length)];

        String resultado = oJugada.CompararJugada(dispositivo);
        lbRespuesta.setText(resultado);
    }

}