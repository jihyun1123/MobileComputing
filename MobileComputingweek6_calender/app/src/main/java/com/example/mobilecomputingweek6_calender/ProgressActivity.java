package com.example.mobilecomputingweek6_calender;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    TextView textView;
    RatingBar ratingBar;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progresslayout);

        textView = findViewById(R.id.textView3);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);

        ratingBar.setOnRatingBarChangeListener((ratingBar, v, fromUser) -> {
            textView.setText("Rating Bar value: " + v + " From User: " + fromUser);
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("Progress : " + i + "From User : " + b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("Start Tracking Touch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Stop Tracking Touch");
            }
        });
    }
}
