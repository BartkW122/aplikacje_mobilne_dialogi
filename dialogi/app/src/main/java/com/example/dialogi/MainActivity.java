package com.example.dialogi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.button);
        Button btn2=findViewById(R.id.button2);

        btn.setOnClickListener(v-> showAlertDialog());
        btn2.setOnClickListener(v-> showListDialog());

    }
    private  void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Prosty Alertdialog");
        builder.setMessage("Przykladowa wiadomosc");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"kliknięto OK",Toast.LENGTH_LONG).show();

            }
        });

        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"kliknięto Anuluj",Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }

    private void showListDialog(){
        final  String[] items = {"Opcja 1","Opcja 2","Opcja 3","Opcja 4","Opcja 5"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("wybierz opcje:");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Wybrano " + items[which],Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }
}