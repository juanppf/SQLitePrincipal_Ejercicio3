package com.example.juanp.sqliteprincipal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alta(View view) {
        Intent i = new Intent(this, Alta.class);
        startActivity(i);
    }

    public void consultaPorCodigo(View view) {
        Intent i = new Intent(this, ConsultaPorCodigo.class);
        startActivity(i);
    }

    public void consultaPorDescripcion(View view) {
        Intent i = new Intent(this, ConsultaPorDescrip.class);
        startActivity(i);
    }

    public void modificar(View view) {
        Intent i = new Intent(this, Modificar.class);
        startActivity(i);
    }

    public void BajaPorCodigo(View view) {
        Intent i = new Intent(this, BajaPorCodigo.class);
        startActivity(i);
    }
}