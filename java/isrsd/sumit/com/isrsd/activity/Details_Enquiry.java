package isrsd.sumit.com.isrsd.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import isrsd.sumit.com.isrsd.R;
import isrsd.sumit.com.isrsd.util.GMailSender;
import isrsd.sumit.com.isrsd.util.Utility;

import static isrsd.sumit.com.isrsd.activity.Modular_Details.str_mod_course;

public class Details_Enquiry extends AppCompatActivity implements View.OnClickListener {

    private static final String SMS_SENT_INTENT_FILTER = "com.isrsd.sms_send";
    private static final int PERMISSION_SEND_SMS = 123;
    //ToolBar End
    //ToolBar start
    ImageView img_logo, backToPreviousImageView;
    TextView toolbar_title;
    TextView txt_submit, txt_selected, txt_mail, txt_call,txt_walkin;
    EditText edit_name, edit_emailId, edit_mobileno, edit_descriptions;
    String str_name, str_emailid, str_mobileno, str_description;
    String number = "9960556397";

    //  String number = "9822912492";
    String messageToSend = "", mailToSend = "";


    String[] contactlist = {"9960556397", "8975544142", "9881032649", "9405371648", "8888872989"};

    double longitude_1, latitude_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__enquiry);

        InitID();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //ToolBar Imageview
        backToPreviousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Details_Enquiry.this, Modular_Details.class));
                finish();

            }
        });


        txt_submit.setOnClickListener(this);
        txt_mail.setOnClickListener(this);
        txt_call.setOnClickListener(this);
        txt_walkin.setOnClickListener(this);

    }


    private void InitID() {
        backToPreviousImageView = (ImageView) findViewById(R.id.backToPreviousImageView);
        backToPreviousImageView.setVisibility(View.VISIBLE);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        img_logo.setVisibility(View.GONE);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams) toolbar_title.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        toolbar_title.setLayoutParams(layoutParams);

        toolbar_title.setText(R.string.enquiry);

        txt_submit = (TextView) findViewById(R.id.txt_submit);
        txt_selected = (TextView) findViewById(R.id.txt_selected);
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_emailId = (EditText) findViewById(R.id.edit_emailId);
        edit_mobileno = (EditText) findViewById(R.id.edit_mobileno);
        edit_descriptions = (EditText) findViewById(R.id.edit_descriptions);
        txt_mail = (TextView) findViewById(R.id.txt_mail);
        txt_call = (TextView) findViewById(R.id.txt_call);
        txt_walkin= (TextView) findViewById(R.id.txt_walkin);

        txt_selected.setText("You have Selected Modular Course " + str_mod_course);


    }


    private boolean isEmailValid(String email) {
        // TODO Auto-generated method stub
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidMobile(String phone_number) {
        String mobile_string = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
        Pattern pattern = Pattern.compile(mobile_string);
        Matcher matcher = pattern.matcher(phone_number);
        return matcher.matches();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Details_Enquiry.this, Modular_Details.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_submit:
                // toast("Update Soon");

                str_name = edit_name.getText().toString();
                str_emailid = edit_emailId.getText().toString();
                str_mobileno = edit_mobileno.getText().toString();
                str_description = edit_descriptions.getText().toString();

                if (str_name.isEmpty() || str_name.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_name.setError("Name Can not be Empty");
                } else if (str_emailid.isEmpty() || str_emailid.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_emailId.setError("Email Id Can not be Empty");
                } else if (!isEmailValid(str_emailid)) {
                    // toast("Please Enter the Nmae");
                    edit_emailId.setError("Please Enter Valid Email Id");
                } else if (str_mobileno.isEmpty() || str_mobileno.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_mobileno.setError("Mobile No. Can not be Empty");
                } else if (!isValidMobile(str_mobileno)) {
                    edit_mobileno.setError("Please Enter Valid Mobile No.");
                } else {
                    messageToSend = "Name:" + str_name + " MobileNo:" + str_mobileno + " Email:" + str_emailid +
                            " course:Modular " + str_mod_course + " Des:" + str_description;


                    if (Utility.checkPermissionSMS(Details_Enquiry.this)) {

                        Log.e("DetailsEnq", String.valueOf(messageToSend.length()));
                        sendSms(messageToSend);
                        // sendSms( messageToSend);
                        startActivity(new Intent(Details_Enquiry.this, HomeActivity.class));
                        finish();
                    } else {
                        toast("Permission Not Granted");
                    }


                }


                break;

            case R.id.txt_mail:
                toast("Update Soon");

                str_name = edit_name.getText().toString();
                str_emailid = edit_emailId.getText().toString();
                str_mobileno = edit_mobileno.getText().toString();
                str_description = edit_descriptions.getText().toString();

                if (str_name.isEmpty() || str_name.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_name.setError("Name Can not be Empty");
                } else if (str_emailid.isEmpty() || str_emailid.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_emailId.setError("Email Id Can not be Empty");
                } else if (!isEmailValid(str_emailid)) {
                    // toast("Please Enter the Nmae");
                    edit_emailId.setError("Please Enter Valid Email Id");
                } else if (str_mobileno.isEmpty() || str_mobileno.trim().equalsIgnoreCase("")) {
                    // toast("Please Enter the Nmae");
                    edit_mobileno.setError("Mobile No. Can not be Empty");
                } else if (!isValidMobile(str_mobileno)) {
                    edit_mobileno.setError("Please Enter Valid Mobile No.");
                } else {
                    mailToSend = "Respected Sir/Mam,\n\n" + "Name: " + str_name + "\nMobileNo: " + str_mobileno + "\nEmail: " + str_emailid +
                            "\ncourse:Modular course " + str_mod_course + "\nDesCription: " + str_description +
                            "\n\n Regards,\n" + str_name + "\n" + str_mobileno;

                    //  SendEmail();


                    SendMail(mailToSend);


                }

                // SendEmail();
                break;

            case R.id.txt_call:


                if (Utility.checkPermissionCall(Details_Enquiry.this)) {


                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                       callIntent.setData(Uri.parse("tel:7972547618"));
                  //  callIntent.setData(Uri.parse("tel:8788569778"));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(callIntent);


                } else {
                    toast("Permission Not Granted");
                }
                break;
            case R.id.txt_walkin:

                    WlakinDetails();
                break;

        }

    }

    private void WlakinDetails()
    {
        Geocoder coder = new Geocoder(Details_Enquiry.this);
        List<Address> address;

        try {
            address = coder.getFromLocationName("Shivar Garden", 10);
//                    if (address == null)
//                    {
//                        return null;
//                    }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();
            latitude_1 = location.getLatitude();
            longitude_1 = location.getLongitude();

            String label = "Dwarka Empiares,Shivar Garden" + " " + "Pimpale Saudagar Pune";
            String uriBegin = "geo:" + latitude_1 + "," + longitude_1;
            String query = latitude_1 + "," + longitude_1 + "(" + label + ")";
            String encodedQuery = Uri.encode(query);
            String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
            Uri uri = Uri.parse(uriString);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
            startActivity(intent);

            //p1 = new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void SendMail(String body)
    {
        if(Utility.isNetworkAvailable(Details_Enquiry.this))
        {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"raokhande.sumit@gmail.com","parag.pathak9@gmail.com","devjk009@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Enquiry Course");
            i.putExtra(Intent.EXTRA_TEXT   , body);
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(Details_Enquiry.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            toast("Please Check your internet Connection!!");
        }

    }

    private void SendEmail()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    GMailSender sender = new GMailSender(

                            "raokahnde.sumit@gmail.com",

                            "Can't disclose, enter your password and your email");



                //    sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                    sender.sendMail("Test mail", "This mail has been sent from android app ",

                            "raokahnde.sumit@gmail.com",

                            "parag.pathak9@gmail.com");









                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                }

            }
        }).start();

    }


    void sendSms(String msg) {


     /*   PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(
                SMS_SENT_INTENT_FILTER), 0);
        SmsManager.getDefault().sendTextMessage(phone, null, msg, sentPI,null);*/

        String[] contactlist = {"7972547618"};

        SmsManager sms = SmsManager.getDefault();
        ArrayList<String> parts = sms.divideMessage(msg);
        //  sms.sendMultipartTextMessage(phone, null, parts, null, null);


        for (int i = 0; i < contactlist.length; i++) {
            //   SmsManager smsManager = SmsManager.getDefault();
            sms.sendMultipartTextMessage(contactlist[i], null, parts, null, null);
            // smsManager.sendTextMessage(numbers[i], null, "Text Message", null, null);
        }


    }

    public void toast(String msg) {
        Toast.makeText(Details_Enquiry.this, msg, Toast.LENGTH_SHORT).show();
    }
}
