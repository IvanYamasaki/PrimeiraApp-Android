package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelefoneActivity extends AppCompatActivity {
    private EditText etTelefonar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);
        etTelefonar = findViewById(R.id.edTelefone);
    }
    public void fazerChamada(View view)
    {
        String Numero = etTelefonar.getText().toString();
        Uri uri = Uri.parse("tel:"+Numero);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }
}
