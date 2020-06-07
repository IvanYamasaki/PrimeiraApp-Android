package com.example.primeiraapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GaleriaActivity extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;
    @SuppressLint("MissingPermission")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = (ImageView) findViewById(R.id.imageView);

                imageView.setImageBitmap(imageBitmap);
                mostrarMensagem("Imagem capturada!");
                adicionarNaGaleria();
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 123)
        {
            Uri imagemSelecionada = data.getData();
            //ImageView imageView = (ImageView) findViewById(R.id.imageView);
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(imagemSelecionada);
            LinearLayout ln = (LinearLayout)findViewById(R.id.lnGaleria);
            ln.addView(imageView);
        }
    }
    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG).show();
    }

    /*imagem não é adicionada automaticamente a galeria
    é necessário chamar um serviço de notificação (broadcast para que a imagem seja adicionada a galeria
     */

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void visualizarGaleria(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 123);
    }
}
