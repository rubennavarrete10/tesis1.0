package com.example.tesis101;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class myprofile extends AppCompatActivity {

    public TextView valorA;
    public TextView nivel;
    public TextView tiempo;
    public SeekBar durac;
    public Switch auto;

    public int tiempoalarma=0;
    public int nivel2=1;
    public String nivel1;
    public String tiemp;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String TEXT2 = "text2";
    public static final String TEXT3 = "text3";
    private String text1="0";
    private String text2="0";
    private String text3="0";
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        valorA = (TextView) findViewById(R.id.textView4);
        nivel = (TextView) findViewById(R.id.textView8);
        tiempo = (TextView) findViewById(R.id.textView10);
        durac = (SeekBar) findViewById(R.id.seekBar5);
        durac.setProgress(1);
        durac.setMin(1);
        durac.setMax(5);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.checkBox3);
        Button btn4 = (Button) findViewById(R.id.checkBox4);
        Button btn5 = (Button) findViewById(R.id.checkBox5);

        loadData();
        updateViews();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                intent2.putExtra("tipo",tiempoalarma);
                intent2.putExtra("duracion",nivel2);
                startActivityForResult(intent2, 0);
                saveData();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 1;
                tiemp=Integer.toString(tiempoalarma);
                tiempo.setText(tiemp);
                nivel1= (String) nivel.getText();
                nivel2=Integer.parseInt(nivel1);
                tiemp= (String) tiempo.getText();
                tiempoalarma=Integer.parseInt(tiemp);
                valorA.setText("Lento, "+tiemp);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 2;
                tiemp=Integer.toString(tiempoalarma);
                tiempo.setText(tiemp);
                nivel1= (String) nivel.getText();
                nivel2=Integer.parseInt(nivel1);
                tiemp= (String) tiempo.getText();
                tiempoalarma=Integer.parseInt(tiemp);
                valorA.setText("Rapido, "+tiemp);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoalarma = 4;
                tiemp=Integer.toString(tiempoalarma);
                tiempo.setText(tiemp);
                nivel1= (String) nivel.getText();
                nivel2=Integer.parseInt(nivel1);
                tiemp= (String) tiempo.getText();
                tiempoalarma=Integer.parseInt(tiemp);
                valorA.setText("Continuo, "+tiemp);
            }
        });
        durac.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            nivel.setText(String.valueOf(progress));
                nivel1= (String) nivel.getText();
                nivel2=Integer.parseInt(nivel1);
                tiemp= (String) tiempo.getText();
                tiempoalarma=Integer.parseInt(tiemp);
            }
            //hace un llamado  cuando se toca la perilla
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            //hace un llamado  cuando se detiene la perilla
             public void onStopTrackingTouch(SeekBar seekBar) {
             }
        });

    }
    public void saveData(){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(TEXT, valorA.getText().toString());
            editor.putString(TEXT2,nivel.getText().toString());
            editor.putString(TEXT3,tiempo.getText().toString());
            editor.apply();

            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text1 = sharedPreferences.getString(TEXT,"");
        text2= sharedPreferences.getString(TEXT2,"");
        text3= sharedPreferences.getString(TEXT3,"");
    }
    public void updateViews() {
        valorA.setText(text1);
        nivel.setText(text2);
        tiempo.setText(text3);
        nivel1= (String) nivel.getText();
        nivel2=Integer.parseInt(nivel1);
        tiemp= (String) tiempo.getText();
        tiempoalarma=Integer.parseInt(tiemp);
    }
}
