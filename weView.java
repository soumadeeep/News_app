package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class weView extends AppCompatActivity {
    Toolbar toolbar;
   WebView weView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_view);
        toolbar=findViewById(R.id.toolbar);
        weView=findViewById(R.id.webview);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        weView.setWebViewClient(new WebViewClient());
        weView.loadUrl(url);
    }
}