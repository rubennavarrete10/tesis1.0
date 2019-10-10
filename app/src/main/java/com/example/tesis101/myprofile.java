package com.example.tesis101;
import android.widget.CheckBox;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


public class myprofile extends AppCompatActivity {

    private CheckBox chek1;
    private CheckBox chek2;
    private CheckBox chek3;
    TextView valorA;
    String valoralarma;
    int tiempoalarma=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        chek1 = (CheckBox) findViewById(R.id.checkBox3);
        chek2 = (CheckBox) findViewById(R.id.checkBox4);
        chek3 = (CheckBox) findViewById(R.id.checkBox5);
        valorA = (TextView) findViewById(R.id.textView4);

            Button btn2 = (Button) findViewById(R.id.button2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent2, 0);
                }
            });
            chek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 1000;
                valoralarma = "1 segundo";
                valorA.setText(valoralarma);
                chek2.setEnabled(false);
                chek3.setEnabled(false);
                  }
             });
            chek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 2000;
                valoralarma = "2 segundo";
                valorA.setText(valoralarma);
                chek1.setEnabled(false);
                chek3.setEnabled(false);
                }
            });
            chek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 4000;
                valoralarma = "4 segundo";
                valorA.setText(valoralarma);
                chek2.setEnabled(false);
                chek1.setEnabled(false);
                 }
             });
        chek1.setEnabled(true);
        chek2.setEnabled(true);
        chek3.setEnabled(true);
        valoralarma = "N/A";
        valorA.setText(valoralarma);
    }
    }
