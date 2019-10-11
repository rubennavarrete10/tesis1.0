package com.example.tesis101;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;



public class myprofile extends AppCompatActivity {

    public TextView valorA;
    public TextView alarmA;
    public int tiempoalarma=0;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String TEXT2 = "text1";
    private String text1;
    private String text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        valorA = (TextView) findViewById(R.id.textView4);
        alarmA = (TextView) findViewById(R.id.textView8);

        loadData();
        updateViews();
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.checkBox3);
        Button btn4 = (Button) findViewById(R.id.checkBox4);
        Button btn5 = (Button) findViewById(R.id.checkBox5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                intent2.putExtra("tiempo",tiempoalarma);
                startActivityForResult(intent2, 0);
                saveData();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 1000;
                valorA.setText("1 seg");
                alarmA.setText("1000ms");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 2000;
                valorA.setText("2 seg");
                alarmA.setText("2000ms");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            tiempoalarma = 4000;
            valorA.setText("4 seg");
            alarmA.setText("4000ms");
            }
        });
    }
    public void saveData(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(TEXT, valorA.getText().toString());
            editor.putString(TEXT2,alarmA.getText().toString());

            editor.apply();

            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text1 = sharedPreferences.getString(TEXT, "");
        text2= sharedPreferences.getString(TEXT2,"");
    }
    public void updateViews() {
        valorA.setText(text1);
        alarmA.setText(text2);
    }
}
