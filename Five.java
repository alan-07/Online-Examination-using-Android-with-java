package com.example.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Five extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView textView;
    Button b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        textView = findViewById (R.id.textView3);
        b7=(Button)findViewById(R.id.button7);
        r1=(RadioButton) findViewById(R.id.radioButton6);
        r2=(RadioButton) findViewById(R.id.radioButton7);
        r3=(RadioButton) findViewById(R.id.radioButton8);
        r4=(RadioButton) findViewById(R.id.radioButton9);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r4.isChecked())
                {
                    Four.score++;
                    Intent i=new Intent( Five.this,Third.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Four.score--;
                    Intent i=new Intent(Five.this, Third.class);
                    startActivity(i);
                    finish();
                }
            }

        }); r3=(RadioButton) findViewById(R.id.radioButton8);
        new CountDownTimer(50000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("00:00:00");
            }
        }.start();


    }
}
