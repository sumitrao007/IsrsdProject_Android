package isrsd.sumit.com.isrsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import isrsd.sumit.com.isrsd.R;

public class Training extends AppCompatActivity implements View.OnClickListener {

    CardView cardview_modularcourse, cardview_joboriented, cardview_AdvCourse, cardview_learndev;

    //ToolBar start
    ImageView img_logo, backToPreviousImageView;
    TextView toolbar_title;
    //ToolBar End


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Training.this, HomeActivity.class));
        overridePendingTransition(R.anim.fadeoutnew, R.anim.fadeinnew);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        InitID();
        cardview_modularcourse.setOnClickListener(this);
        cardview_joboriented.setOnClickListener(this);
        cardview_AdvCourse.setOnClickListener(this);
        cardview_learndev.setOnClickListener(this);

        //ToolBar Imageview
        backToPreviousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Training.this, HomeActivity.class));
                overridePendingTransition(R.anim.fadeoutnew, R.anim.fadeinnew);
                finish();

            }
        });

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
        toolbar_title.setText(R.string.training);

        cardview_modularcourse = (CardView) findViewById(R.id.cardview_modularcourse);
        cardview_joboriented = (CardView) findViewById(R.id.cardview_joboriented);
        cardview_AdvCourse = (CardView) findViewById(R.id.cardview_AdvCourse);
        cardview_learndev = (CardView) findViewById(R.id.cardview_learndev);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardview_modularcourse:
                //   toast("Update Soon");
                startActivity(new Intent(Training.this, ModularCourses.class));
                finish();
                break;
            case R.id.cardview_joboriented:
                toast("Update Soon");
                break;
            case R.id.cardview_AdvCourse:
                toast("Update Soon");
                break;
            case R.id.cardview_learndev:
                toast("Update Soon");
                break;
        }

    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
