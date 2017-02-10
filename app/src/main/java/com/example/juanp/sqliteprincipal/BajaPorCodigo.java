package com.example.juanp.sqliteprincipal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.juanp.sqliteprincipal.R.id.et1;
import static com.example.juanp.sqliteprincipal.R.id.et2;

public class BajaPorCodigo extends AppCompatActivity {

    private EditText et7;
    private TextView et8;
    private Button button9,button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja_por_codigo);

        et7=(EditText)findViewById(R.id.et7);
        et8=(TextView)findViewById(R.id.et8);
    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et7.getText().toString();
        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        et7.setText("");

        if (cant == 1)
            Toast.makeText(this, "Se borró el artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void consultarTabla(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery(
                "select * from  articulos" , null);
        if (fila.moveToFirst()) {
           do{
               et8.setText(fila.getString(0));
               et8.setText("\n" + fila.getString(1));
               et8.setText("\n" + fila.getString(2));
           }while(fila.moveToNext());

        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
}
