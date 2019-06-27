package isrsd.sumit.com.isrsd.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import isrsd.sumit.com.isrsd.R;
import isrsd.sumit.com.isrsd.adapter.DrawerListAdapter;
import isrsd.sumit.com.isrsd.slider.CircleIndicator;
import isrsd.sumit.com.isrsd.slider.Frag1;
import isrsd.sumit.com.isrsd.slider.Frag2;
import isrsd.sumit.com.isrsd.slider.Frag3;

public class HomeActivity extends AppCompatActivity {

    public static int[] drawer_icons = {R.drawable.ic_home,
            R.drawable.ic_myaccount, R.drawable.ic_history,
            R.drawable.ic_invite_frnd, R.drawable.ic_contact, R.drawable.ic_faq,
            R.drawable.ic_terms_conditions, R.drawable.ic_about_us, R.drawable.ic_feedback};
    //ToolBar Start
    ImageView backImageView, img_notification;
    //ToolBar End
    TextView toolbar_title, badge_notification_Count;
    //Drawer Layout start
    DrawerLayout drawer_layout;
    ArrayList<String> navigation_items;
    TextView txt_aboutus, txt_services_Solutions, txt_Training, txt_branches, txt_contactus, txt_faq;
    CircleIndicator circleIndicator;

    //Drawer Layout End
    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;
    int count = 0;
    Timer timer;
    private ListView lv_drawer;
    private DrawerListAdapter drawerListAdapter;

    // int trainingflag=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        InitID();
        setDrawer();

        TextViewListner();

        SetViewPager();

    }

    private void SetViewPager() {
        mPager.setAdapter(new SlidePagerAdapter(getSupportFragmentManager()));

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                mPager.post(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 5) {
                            mPager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            mPager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 300, 3000);


        circleIndicator.setViewPager(mPager);
    }

    private void TextViewListner() {
        txt_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Update Soon!!!!");

            }
        });

        txt_services_Solutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Update Soon!!!!");

            }
        });

        txt_Training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // toast("Update Soon!!!!");

                startActivity(new Intent(HomeActivity.this, Training.class));
                overridePendingTransition(R.anim.fadeinnew, R.anim.fadeoutnew);
                finish();


            }
        });
        txt_branches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Update Soon!!!!");

            }
        });

        txt_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Update Soon!!!!");

            }
        });
        txt_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("Update Soon!!!!");

            }
        });


    }

    @Override
    public void onBackPressed() {


        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }


    }

    private void InitID() {

        //start toolbar
        backImageView = (ImageView) findViewById(R.id.backImageView);
        backImageView.setVisibility(View.VISIBLE);
        //  img_notification=(ImageView)findViewById(R.id.img_notification);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        //  badge_notification_Count=(TextView)findViewById(R.id.badge_notification_Count);

        //   Typeface tf = Typeface.createFromAsset(getAssets(), "dancingscript_bold.ttf");
        //  Typeface typeface = getResources().getAssets().getFont(R.font.DancingScript_Bold);
        //   toolbar_title.setTypeface(tf);

        //End toolbar

        mPager = (ViewPager) findViewById(R.id.pager);
        circleIndicator = (isrsd.sumit.com.isrsd.slider.CircleIndicator) findViewById(R.id.indicator);
        txt_aboutus = (TextView) findViewById(R.id.txt_aboutus);
        txt_services_Solutions = (TextView) findViewById(R.id.txt_services_Solutions);
        txt_Training = (TextView) findViewById(R.id.txt_Training);
        txt_branches = (TextView) findViewById(R.id.txt_branches);
        txt_contactus = (TextView) findViewById(R.id.txt_contactus);
        txt_faq = (TextView) findViewById(R.id.txt_faq);


    }

    private void setDrawer() {
        //Drawer Layout start
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lv_drawer = (ListView) findViewById(R.id.lv_drawer);

        navigation_items = new ArrayList<>();

//adding menu items for naviations
        navigation_items.add("Home");
        navigation_items.add("Services \n & Solutions");
        navigation_items.add("Training");
        navigation_items.add("Invite Friends");
        navigation_items.add("Contact Us");
        navigation_items.add("FAQ");
        navigation_items.add("Terms & Conditions");
        navigation_items.add("About Us");
        navigation_items.add("Rate To App");

        openCloseDrawer(backImageView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeActivity.this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer_layout.setDrawerListener(toggle);
        toggle.syncState();

        drawerListAdapter = new DrawerListAdapter(HomeActivity.this, navigation_items, drawer_icons);
        lv_drawer.setAdapter(drawerListAdapter);


        lv_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  drawer_layout.closeDrawer(lv_drawer);

                drawer_layout.closeDrawers();

                switch (position) {
                    case 1:
                        //   startActivity(new Intent(HomeScreen_Activity.this,School_Profile.class));
                        //      finish();
                        toast("U R in My Account");
                        break;
                    case 2:
                        //        toast("U R in Training");
                        //     KBFlag_homescreen=0;
                        //    trainingflag=0;
                        startActivity(new Intent(HomeActivity.this, Training.class));
                        overridePendingTransition(R.anim.fadeinnew, R.anim.fadeoutnew);
                        finish();

                        break;

                    case 3:
                        InviteDriends();
                        //   toast("Invite Friends");
                        break;
                    case 4:
                        //   startActivity(new Intent(HomeScreen_Activity.this,ContactUS.class));
                        //    finish();
                        toast("Contact Us");
                        break;
                    case 5:
                        //   startActivity(new Intent(HomeScreen_Activity.this,FAQ_Activity.class));
                        //   finish();
                        toast("FAQ");
                        break;
                    case 6:
                        //  startActivity(new Intent(HomeScreen_Activity.this,TermsAndConditions.class));
                        //   finish();


                        toast("Terms & Conditions");
                        break;
                    case 7:
                        //    startActivity(new Intent(HomeScreen_Activity.this,AboutUS.class));
                        //   finish();
                        toast("About Us");
                        break;
                    case 8:
                        RateToApp();
                        break;
                }


            }
        });


    }

    public void openCloseDrawer(ImageView backImageView) {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer_layout.isDrawerOpen(Gravity.LEFT)) { // close
                    drawer_layout.closeDrawers();
                } else {// open }
                    drawer_layout.openDrawer(Gravity.LEFT);

                }
            }
        });
    }

    private void InviteDriends() {

        int applicationNameId = getApplicationInfo().labelRes;
        final String appPackageName = getPackageName();
        Intent MyIntent = new Intent(Intent.ACTION_SEND);
        MyIntent.setType("text/plain");
        MyIntent.putExtra(Intent.EXTRA_SUBJECT, getString(applicationNameId));
        String text = "Install this cool application: ";
        String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
        MyIntent.putExtra(Intent.EXTRA_TEXT, text + " " + link);
        startActivity(Intent.createChooser(MyIntent, "Share link:"));
    }

    private void RateToApp() {
        int applicationNameId = getApplicationInfo().labelRes;
        final String appPackageName = getPackageName();

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));

    }

    public void toast(String msg) {
        Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    public class SlidePagerAdapter extends FragmentPagerAdapter {
        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Frag1.newInstance("FirstFragment, Instance 1");
                case 1:
                    return Frag2.newInstance("SecondFragment, Instance 1");
                case 2:
                    return Frag3.newInstance("ThirdFragment, Instance 1");
                default:
                    return Frag1.newInstance("FirstFragment, Instance 1");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


}
