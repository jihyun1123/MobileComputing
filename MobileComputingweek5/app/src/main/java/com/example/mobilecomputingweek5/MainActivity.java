package com.example.mobilecomputingweek5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout((this));
        baseLayout.setOrientation((LinearLayout.VERTICAL));
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        setContentView(baseLayout, params);

        Button btn = new Button(this);
        btn.setText("button");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);
        btn.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        btn.getLayoutParams().height = 100;

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(),
                        "코드로 생성한 버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}