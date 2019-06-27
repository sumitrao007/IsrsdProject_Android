package isrsd.sumit.com.isrsd.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import isrsd.sumit.com.isrsd.R;

public class SplashActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GoToScreen();

            }
        }).start();

    }

    private void GoToScreen() {
        LoginActivity.login_sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        username = LoginActivity.login_sharedpreferences.getString("username", "");

        if (username.equalsIgnoreCase("admin@isrsd.com")) {

            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();


        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }


    }
}
