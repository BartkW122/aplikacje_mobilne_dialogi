package com.example.dialogi_zadanie;

import android.content.DialogInterface;
import android.os.Bundle;
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

        if(savedInstanceState!=null){
            ilosc=savedInstanceState.getInt(ilosc_klik);
        }
       // ustaw();

        btn_delete.setOnClickListener(view -> AlterDialog());
    }
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ilosc_klik,ilosc);
    }
    private void AlterDialog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);

        builder.setTitle("Potwierdzenie!");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");

        licznik=findViewById(R.id.licznik);

        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ilosc+=1;
                licznik.setText("Dane usunięto: "+ilosc+" razy");
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
    private  void  ustaw(){
        licznik.setText("Dane usunięto: "+ilosc+" razy");
    }
}