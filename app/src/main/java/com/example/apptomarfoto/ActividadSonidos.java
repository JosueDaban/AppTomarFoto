package com.example.apptomarfoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActividadSonidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_sonidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickHablar(View boton){
        //Ejemplo de un objeto Intent Generico
        Intent oIntento = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //eNVIAR PARAMETROS
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"es-PE");
        oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityIfNeeded(oIntento,200);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent oIntento) {
        super.onActivityResult(requestCode, resultCode, oIntento);
        if(requestCode==200){
            ArrayList<String> resultados = oIntento.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (resultados != null && !resultados.isEmpty()) {
                // Mostrar el primer resultado en el EditText
                EditText txtMultiple = findViewById(R.id.txtMultiple);
                txtMultiple.setText(resultados.get(0));
            }
        }
    }
}