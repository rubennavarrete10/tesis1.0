package com.example.tesis101;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import android.content.Context;
import android.os.Vibrator;


public class reconocimientoVoz extends AppCompatActivity {

    public int tfinal = 1;
    int a=1;
    public int nfinal=1;
    TextView grabar;//
    TextView revisar;
    private Vibrator vibrator;//VARIABLE DE LA ALARMA
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;

    Timer tiempo=new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recvoz);

        Bundle extras = getIntent().getExtras();
        tfinal = extras.getInt("t");
        nfinal = extras.getInt("n");

        Button btn3 = (Button) findViewById(R.id.button4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(v.getContext(), MainActivity.class);
                intent4.putExtra("tipo",tfinal);
                intent4.putExtra("duracion",nfinal);
                startActivityForResult(intent4, 0);
                tiempo.cancel();
                tiempo.purge();
            }
        });
        grabar = (TextView) findViewById(R.id.textView3);
        revisar = (TextView) findViewById(R.id.textView9);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        TimerTask ciclo = new TimerTask() {
            @Override
            public void run() {
                 Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
             intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
                 try {
                     startActivityForResult(intentActionRecognizeSpeech,
                             RECOGNIZE_SPEECH_ACTIVITY);
                 } catch (ActivityNotFoundException a) {
                        Toast.makeText(getApplicationContext(),
                            "Tú dispositivo no soporta el reconocimiento por voz",
                            Toast.LENGTH_SHORT).show();
                 }
            }

        };
        tiempo.schedule(ciclo,700,6000);


        ////////////////////////////////////////////////////////////////////////////////////////////
        /*Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show();
        }*/
        ////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);
                    grabar.setText(strSpeech2Text + tfinal+","+nfinal);

                    if (vibrator.hasVibrator()) //Si tiene vibrador//
                    {
                        long[] pattern={};
                        if (tfinal == 1) {
                            if(nfinal==1)
                            {
                                long [] pattern1 = {100, 900};
                                pattern=pattern1;
                            }
                            if(nfinal==2)
                            {
                                long [] pattern2 = {100, 900, 100, 900};
                                pattern=pattern2;
                            }
                            if(nfinal==3)
                            {
                                long [] pattern3 = {100, 900, 100, 900, 100, 900};
                                pattern=pattern3;
                            }
                            if(nfinal==4)
                            {
                                long [] pattern4 = {100, 900, 100, 900, 100, 900, 100, 900};
                                pattern=pattern4;
                            }
                            if(nfinal==5)
                            {
                                long [] pattern5 = {100, 900, 100, 900, 100, 900, 100, 900, 100, 900};
                                pattern=pattern5;
                            }
                            vibrator.vibrate(pattern, -1);
                        }
                        if (tfinal == 2) {
                            if(nfinal==1)
                            {
                                long [] pattern6 = {50, 283, 50, 283, 50, 284};
                                pattern=pattern6;
                            }
                            if(nfinal==2)
                            {
                                long [] pattern7 = {50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284};
                                pattern=pattern7;
                            }
                            if(nfinal==3)
                            {
                                long [] pattern8 = {50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284};
                                pattern=pattern8;
                            }
                            if(nfinal==4)
                            {
                                long [] pattern9 = {50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284};
                                pattern=pattern9;
                            }
                            if(nfinal==5)
                            {
                                long [] pattern10 = {50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284,50, 283, 50, 283, 50, 284};
                                pattern=pattern10;
                            }
                            vibrator.vibrate(pattern, -1);
                        }
                        if (tfinal == 4) {

                            vibrator.vibrate(nfinal*1000);
                        }
                    }
                        break;
                }
                    default:
                        break;
            }
    }
    /*
    private void reconocer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intentActionRecognizeSpeech = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intentActionRecognizeSpeech.putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
                try {
                    startActivityForResult(intentActionRecognizeSpeech,
                            RECOGNIZE_SPEECH_ACTIVITY);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Tú dispositivo no soporta el reconocimiento por voz",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }).start();

    }*/
}
