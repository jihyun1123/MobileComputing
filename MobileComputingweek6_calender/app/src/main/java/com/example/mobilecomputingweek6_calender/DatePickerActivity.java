package com.example.mobilecomputingweek6_calender;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePickerActivity extends AppCompatActivity {
    DatePicker datePicker;
    TextView textView;
    TimePicker timePicker;
    Button btnDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);

        datePicker = findViewById(R.id.datePicker);
        textView = findViewById(R.id.textview2);
        timePicker = findViewById(R.id.timePicker);
        btnDatePicker = findViewById(R.id.btnDatePicker);

        datePicker.init(
                datePicker.getYear(),
                datePicker.getMonth(),
                datePicker.getDayOfMonth(),
                (view, year, monthOfYear, dayOfMonth) ->
                        textView.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth)
        );

        timePicker.setOnTimeChangedListener((view, i, i1) ->
                textView.setText(i + ":" + i1)
        );

        MaterialDatePicker<Long> materialDatePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("날짜를 선택하세요")
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();

        btnDatePicker.setOnClickListener(v ->
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER")
        );

        materialDatePicker.addOnPositiveButtonClickListener(selection -> {
            Date selectedDate = new Date(selection);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String formattedDate = sdf.format(selectedDate);
            Toast.makeText(this, "선택된 날짜: " + formattedDate, Toast.LENGTH_SHORT).show();
        });
    }
}
