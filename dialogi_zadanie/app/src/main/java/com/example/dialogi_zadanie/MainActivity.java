package com.example.dialogi_zadanie;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final  String ilosc_klik="ilosc";

    private TextView licznik;
    private int ilosc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn_delete=findViewById(R.id.delete_btn);
        Button btn_reset=findViewById(R.id.reset);

        licznik=findViewById(R.id.licznik);

        if(savedInstanceState!=null){
            ilosc=savedInstanceState.getInt(ilosc_klik);
        }
        ustaw();
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilosc=0;
                licznik.setText("Dane usunięto: "+ilosc+" razy");
            }
        });

        btn_delete.setOnClickListener(view -> AlterDialog());

    }
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ilosc_klik,ilosc);
    }
    private  void  ustaw(){
        licznik.setText("Dane usunięto: "+ilosc+" razy");
    }
    private void AlterDialog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);

        builder.setTitle("Potwierdzenie!");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");


        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ilosc++;
                //licznik.setText("Dane usunięto: "+ilosc+" razy");
                ustaw();
                Toast.makeText(MainActivity.this,"Dane zostały usunięte",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}