package com.andros88i.matrixplayer;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ocultar la barra de estado para look Fullscreen Hacker
        getSupportActionBar().hide();

        myWebView = new WebView(this);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Activa el JS de tu Matrix
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);

        // Cargar tu diseño de Stitch (Splash Screen)
        myWebView.loadUrl("file:///android_asset/splash_screen_anónimo/code.html");

        setContentView(myWebView);

        // Pedir permisos de música al iniciar
        checkPermissions();
    }

    private void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }
}
