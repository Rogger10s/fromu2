package com.example.programacion5a.fromu2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.Txtnom);
        t2=(EditText)findViewById(R.id.txtApe);
        t3=(EditText)findViewById(R.id.txtCed);

    }
    public void guardar(View view){
        guard g1=new guard(this, "informacion", null,1);
        SQLiteDatabase based= g1.getWritableDatabase();
        String nom=t1.getText().toString();
        String ape=t2.getText().toString();
        String ced=t3.getText().toString();
        ContentValues datos=new ContentValues();
        datos.put("nombre",nom);
        datos.put("apellido",ape);
        datos.put("cedula",ced);
        long i = based.insert("persona",null,datos);
        if(i>0){
            Toast.makeText(this,"SE guardo la persona",Toast.LENGTH_SHORT).show();
        }
        based.close();
        t1.setText("");
        t2.setText("");
        t3.setText("");



    }
}
