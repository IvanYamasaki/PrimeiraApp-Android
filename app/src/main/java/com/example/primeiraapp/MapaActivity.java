package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MapaActivity extends AppCompatActivity {
    private EditText ptLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        ptLocal = findViewById(R.id.ptLocal);
    }

    public void verMapa(View view)
    {
        String Local = ptLocal.getText().toString();
        // Localização georreferenciada é possível efetuar a busca ou informar as coordenadas
        // busca de localiza&ccedil;&atilde;o : (geo:0,0?q="parametros de busca")
        Uri location= Uri.parse("geo:0,0?q="+Local);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent );
    }
}
