package com.andros88i.matrixplayer;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        
        myWebView.setWebViewClient(new WebViewClient());
        
        // Carga el archivo desde assets
        myWebView.loadUrl("file:///android_asset/splash_screen_anónimo/code.html");
    }
}
