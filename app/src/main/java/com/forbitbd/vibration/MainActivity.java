package com.forbitbd.vibration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnvibrate1,btnVibrate2;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);
        btnvibrate1 = findViewById(R.id.vibrate1);
        btnVibrate2 = findViewById(R.id.vibrate2);

        btnVibrate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnVibrate2.getText().toString().equals("Start")) {
                    long pattern[] = {300, 300};
                    vibrator.vibrate(pattern, 0);
                    btnVibrate2.setText("Stop");
                }else {
                    vibrator.cancel();
                    btnVibrate2.setText("Start");
                }
            }
        });

        btnvibrate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnvibrate1.getText().toString().equals("Start")) {
                    long pattern[] = {100, 100};
                    vibrator.vibrate(pattern, 0);
                    btnvibrate1.setText("Stop");
                }else {
                    vibrator.cancel();
                    btnvibrate1.setText("Start");
                }

            }
        });
    }
}