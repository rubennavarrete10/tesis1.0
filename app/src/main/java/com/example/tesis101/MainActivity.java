package com.example.tesis101;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    public int t1=0;
    public int n1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = (ImageButton) findViewById(R.id.imageButton2);
        Button btn1 = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), myprofile.class);
                startActivityForResult(intent, 0);
                //////////////////////////////////////////////////////////////////////
                Intent intent1 = new Intent(v.getContext(), reconocimientoVoz.class);
                intent1.putExtra("B", t1);
                //////////////////////////////////////////////////////////////////
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), reconocimientoVoz.class);
                Bundle extras = getIntent().getExtras();
                t1 = extras.getInt("tipo");
                n1 = extras.getInt("duracion");
                intent1.putExtra("t", t1);
                intent1.putExtra("n", n1);
                startActivityForResult(intent1, 0);
            }
        });
    }
}
