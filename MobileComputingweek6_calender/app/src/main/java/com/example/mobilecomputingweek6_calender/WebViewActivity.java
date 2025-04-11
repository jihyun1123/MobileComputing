package com.example.mobilecomputingweek6_calender;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    EditText editurl;

    Button btngo, btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewlayout);


        webView = (WebView) findViewById(R.id.webView);
        editurl = (EditText) findViewById(R.id.editurl);
        btngo = (Button) findViewById(R.id.btngo);
        btnback = (Button) findViewById(R.id.btnback);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        btngo.setOnClickListener(view -> webView.loadUrl("https://"+ editurl.getText().toString()));
        btnback.setOnClickListener(view -> webView.goBack());
    }
}
