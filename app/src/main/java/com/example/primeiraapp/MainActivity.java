package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fazerChamada(View view)
    {
        startActivity(new Intent(MainActivity.this, TelefoneActivity.class));
    }
    public void verMapa(View view)
    {
        startActivity(new Intent(MainActivity.this, MapaActivity.class));
    }
    public void enviarEmail(View view) throws UnsupportedEncodingException {
        startActivity(new Intent(MainActivity.this, EmailActivity.class));
    }
}
