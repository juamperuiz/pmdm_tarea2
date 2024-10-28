package com.ruizrabadan.pmdm_tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Simular una tarea de carga (reemplazar con tu lógica real)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent para iniciar la actividad principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // Esperar 3 segundos
    }
}