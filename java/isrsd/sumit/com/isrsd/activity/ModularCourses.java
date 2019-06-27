package isrsd.sumit.com.isrsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import isrsd.sumit.com.isrsd.R;
import isrsd.sumit.com.isrsd.adapter.GridViewAdapter;

public class ModularCourses extends AppCompatActivity {

    public static String[] modularcourseList = {"C Language", "C++ Language", "Core java", "Advanced Java", "Android", "ASP.Net"};
    public static int[] modularcourseImages = {R.drawable.clang, R.drawable.cplus, R.drawable.corejava,
            R.drawable.advancedjava, R.drawable.androidimg, R.drawable.dotnet};
    //ToolBar End
    public static int background[] =
            {R.drawable.bg_circle_mydarkblue, R.drawable.bg_circle_mydarkblue1, R.drawable.bg_circle_skyblueshade,
                    R.drawable.bg_circle_mycorejavacolor, R.drawable.bg_circle_greenshade, R.drawable.bg_circle_skyblueshade};
    //ToolBar start
    ImageView img_logo, backToPreviousImageView;
    TextView toolbar_title;
    GridView gridView;
    GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modular_courses);

        InitID();

        gridViewAdapter = new GridViewAdapter(modularcourseList, ModularCourses.this, modularcourseImages, background);
        gridView.setAdapter(gridViewAdapter);

        //ToolBar Imageview
        backToPreviousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModularCourses.this, Training.class));
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
        toolbar_title.setText(R.string.modularcourse);


        gridView = (GridView) findViewById(R.id.grid_gridView);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(ModularCourses.this, Training.class));
        finish();
    }
}
