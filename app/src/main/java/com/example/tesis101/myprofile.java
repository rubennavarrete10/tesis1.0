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

    private Handler mHandler = new Handler();
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

            Button btn2 = (Button) findViewById(R.id.button2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent2, 0);
                }
            });

            chek1 = (CheckBox) findViewById(R.id.checkBox3);
            chek2 = (CheckBox) findViewById(R.id.checkBox4);
            chek3 = (CheckBox) findViewById(R.id.checkBox5);
            valorA = (TextView) findViewById(R.id.textView4);

            String s = "Estado: " + (chek1.isChecked() ? "Marcado" : "No Marcado");
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();

            if (chek1.isChecked() == true) {
                tiempoalarma = 10;
                valoralarma = "1 segundo";
                chek2.setChecked(false);
                chek3.setChecked(false);
            }
            else
            {
                valoralarma = "N/A";
            }
            valorA.setText(valoralarma);


    }
    }
