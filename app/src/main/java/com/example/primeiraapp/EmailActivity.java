package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EmailActivity extends AppCompatActivity {
    private EditText ptEmail;
    private EditText ptAssEmail;
    private EditText ptTxtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        ptEmail = findViewById(R.id.ptEmail);
        ptAssEmail = findViewById(R.id.ptAssEmail);
        ptTxtEmail = findViewById(R.id.ptTxtEmail);
    }
    public void enviarEmail(View view) throws UnsupportedEncodingException {

        String Email = ptEmail.getText().toString();
        String AssEmail = ptAssEmail.getText().toString();
        String TxtEmail = ptTxtEmail.getText().toString();
        String uriText ="mailto:"+Email +
                "?subject=" + URLEncoder.encode(AssEmail, "utf-8") +
                "&body=" + URLEncoder.encode(TxtEmail, "utf-8");
        Uri uri = Uri.parse(uriText);
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(uri);
        startActivity(Intent.createChooser(it, "Enviar Email"));
    }
}
