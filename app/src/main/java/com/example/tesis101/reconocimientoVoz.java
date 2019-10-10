package com.example.tesis101;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;



public class reconocimientoVoz extends AppCompatActivity {

    TextView grabar;//
    private Vibrator vibrator;//VARIABLE DE LA ALARMA
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recvoz);


        Button btn3 = (Button) findViewById(R.id.button4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent3, 0);
            }
        });

            grabar = (TextView) findViewById(R.id.textView3);
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

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
            a = a + 1;

        }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);


            switch (requestCode) {
                case RECOGNIZE_SPEECH_ACTIVITY:
                    if (resultCode == RESULT_OK && null != data) {
                        ArrayList<String> speech = data
                                .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        String strSpeech2Text = speech.get(0);
                        grabar.setText(strSpeech2Text);

                        if (vibrator.hasVibrator()) //Si tiene vibrador//
                        {
                            //vibra N milisegundos
                            if (true) {
                                long tiempo = 500;
                                vibrator.vibrate(tiempo);
                            }

                        }
                        a=0;
                    }
                    break;
                default:
                    break;
            }
        }

}
