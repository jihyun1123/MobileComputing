package com.example.button250321class2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button3, button4;

    EditText edit1, edit2;

    TextView textResult;

    @SuppressLint("MissingInflatedId")
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

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.textresult);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edit1.getText().toString());
                int num2 = Integer.parseInt(edit2.getText().toString());
                int result = num1 + num2;
                textResult.setText(String.valueOf(result));

                Toast.makeText(MainActivity.this, "Button1 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button3.setOnClickListener(this);
        button4.setOnClickListener(new MyOnClick());
    }

    public void btn2Click(View view){
        Toast.makeText(getApplicationContext(), "Button2 clicked", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        Toast.makeText(getApplicationContext(), "Button3 clicked", Toast.LENGTH_SHORT).show();
    }

    class MyOnClick implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Button4 clicked", Toast.LENGTH_SHORT).show();
        }
    }
}