package isrsd.sumit.com.isrsd.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import isrsd.sumit.com.isrsd.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MyPREFERENCES = "Login_MyPrefs";
    public static SharedPreferences login_sharedpreferences;
    public static SharedPreferences.Editor login_editor;
    public ProgressDialog pd;
    EditText edit_username, edit_password;
    TextView txt_btnlogin, txt_forgot_password;
    String str_username, str_password, emailid;
    String user = "admin@isrsd.com", pass = "admin";

    public static boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        InitId();


        txt_btnlogin.setOnClickListener(LoginActivity.this);


    }

    public boolean isNetworkAvailable() {

        ConnectivityManager onGoingCM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = onGoingCM.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void InitId() {
        pd = new ProgressDialog(LoginActivity.this);
        //   sessionManager = new SessionManager(this);
        //  sendGetRequest = new SendGetRequest();

        edit_username = (EditText) findViewById(R.id.edit_name);
        edit_password = (EditText) findViewById(R.id.edit_pass);
        //    txt_forgot_password=(TextView) findViewById(R.id.txt_forgot_password);
        txt_btnlogin = (TextView) findViewById(R.id.txt_btnlogin);

        //  txt_clickhere=(TextView) findViewById(R.id.txt_clickhere);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.txt_btnlogin:

                if (isNetworkAvailable()) {
                    str_username = edit_username.getText().toString();
                    str_password = edit_password.getText().toString();
                    if (str_username.isEmpty() & str_password.isEmpty()) {
                        // mProgress.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Please enter your login User Name and Password",
                                Toast.LENGTH_LONG).show();
                    } else if (str_username.isEmpty()) {
                        //  mProgress.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Please enter your User Name", Toast.LENGTH_LONG).show();
                    } else if (str_password.isEmpty()) {

                        // mProgress.dismiss();
                        Toast.makeText(getApplicationContext(),
                                "Please enter your Password", Toast.LENGTH_LONG).show();
                    } else {

                        // get_login();
                        Log.e("LoginDetails", "Username " + str_username);
                        Log.e("LoginDetails", "Password " + str_password);

                        //  CallLoginService();


                        if ((str_username.toLowerCase().compareToIgnoreCase("admin@isrsd.com") == 0) && (str_password.toLowerCase().compareToIgnoreCase("admin") == 0)) {
                            login_sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                            login_editor = login_sharedpreferences.edit();
                            login_editor.putString("username", str_username);
                            login_editor.putString("password", str_password);
                            login_editor.commit();
                            toast("Login Successful");
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();

                            //   CallLoginService();

                            //  startActivity(new Intent(Login_Activity.this, com.veetron.veetron2.praescio.PraescioSchool.activity.HomeScreen_Activity.class));
                            //   finish();


                        } else {
                            toast("Invalid Username & Password");
                        }


                    }
                } else {
                    toast("Please Check your internet Connection!!");

                }


                break;
        }

    }

    public void toast(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
