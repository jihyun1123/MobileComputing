package com.example.mobilecomputingweek6_calender;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;

    Button chronostart, chronostop;

    CalendarView calendarView;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronostart = (Button) findViewById(R.id.btnstart);
        chronostop = (Button) findViewById(R.id.btnend);

        chronostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        chronostop.setOnClickListener( view -> chronometer.stop());

        calendarView = (CalendarView) findViewById(R.id.calendarview);
        textView = (TextView) findViewById(R.id.textview1);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2){
                textView.setText(i+"/"+(i1+1)+"/"+i2);
            }
        });
    }
}