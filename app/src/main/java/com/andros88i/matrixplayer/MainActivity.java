package com.andros88i.matrixplayer;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final WebView myWebView = new WebView(this);
        setContentView(myWebView);
        
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDomStorageEnabled(true); // Ayuda a que la web no se trabe
        
        myWebView.setWebViewClient(new WebViewClient());
        
        // 1. Carga la animación inicial
        myWebView.loadUrl("file:///android_asset/splash_screen_anonimo/code.html");

        // 2. Espera 6 segundos y luego carga el reproductor
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Ajusta esta ruta según el nombre de tu carpeta de música
                myWebView.loadUrl("file:///android_asset/index.html"); 
            }
        }, 6000); 
    }
}
