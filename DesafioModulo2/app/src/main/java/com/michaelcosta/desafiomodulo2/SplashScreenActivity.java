package com.michaelcosta.desafiomodulo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashTimer(getDelayInMillis());
    }

    private long getDelayInMillis() {
        //Context context = this.getApplicationContext(); // getApplicationContext().ge getActivity();
        SharedPreferences myPrefs = this.getPreferences(Context.MODE_PRIVATE);
        boolean blnFirstExec = myPrefs.getBoolean("blnFirstExec", true);

        if (blnFirstExec) {
            final SharedPreferences.Editor editor = myPrefs.edit();
            editor.putBoolean("blnFirstExec", false);
            editor.commit();
            return 5000;
        } else return  1000;
    }

    private void splashTimer(long delayMillis) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        },delayMillis);

    }
}