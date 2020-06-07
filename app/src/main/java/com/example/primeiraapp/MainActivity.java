package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fazerChamada(View view) {
        startActivity(new Intent(MainActivity.this, TelefoneActivity.class));
    }

    public void verMapa(View view) {
        startActivity(new Intent(MainActivity.this, MapaActivity.class));
    }

    public void enviarEmail(View view){
        startActivity(new Intent(MainActivity.this, EmailActivity.class));
    }

    public void abrirGaleria(View view) {
        startActivity(new Intent(MainActivity.this, GaleriaActivity.class));
    }
    public void abrirCamera(View view) {
        startActivity(new Intent(MainActivity.this, CameraActivity.class));
    }
    public void capturarImagem(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAPTURAR_IMAGEM);
        }
    }

}
