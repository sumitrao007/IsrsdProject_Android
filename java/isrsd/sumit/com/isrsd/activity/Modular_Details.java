package isrsd.sumit.com.isrsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import isrsd.sumit.com.isrsd.R;
import isrsd.sumit.com.isrsd.adapter.ListExpandableAdapter;

public class Modular_Details extends AppCompatActivity {

    public static int[] course_icons = {R.drawable.clan_big, R.drawable.cplus_big, R.drawable.corejava_big, R.drawable.advjava_big
            , R.drawable.android_big, R.drawable.dotnet_big};
    public static String str_mod_course;
    //ToolBar End
    //ToolBar start
    ImageView img_logo, backToPreviousImageView;
    TextView toolbar_title;
    ImageView img_detail;
    ExpandableListView lvExp;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String[] CPlusHeader = {"Introduction to Object Oriented Programming", "Function in ‘C++’", "Control-Flow Statements",
            "Classes & Objects", "Constructors and Destructor", "Inheritance", "Operator Overloading",
            "Polymorphism", "Abstraction & Encapsulation", "Exception Handling", "Templates"};
    String[] CHeader = {"Introduction of Programming Language", "‘C’ Tokens", "Control Statement and Expressions Introduction of Programming Language",
            "Looping", "Arrays and String", "Pointers", "Functions", "Structure and Unions", "File Handling using 'C'",
            "Dynamic Memory Allocation", "Preprocessor", "Introduction of Data Structure"};
    String[] CorejavaHeader = {"Object Oriented Concepts", "Introduction To Java", "Basics Of Java",
            "Objects & Classes", "Packages", "Inheritance & Polymorphism", "Interfaces & Abstract Classess", "Exception Handling",
            "Multithreading", "Swing Programming", "Applet Programming", "JDBC", "Collection Framework"};
    String[] AdvancedjavaHeader = {"HTML,CSS & Javascript Overview", "Overview Of Annotation & Reflection", "Java Database Connectivity",
            "Java Web Server & HTTP Protocol", "Servlets", "JSP", "Filters & Listeners", "Java Beans",
            "Maven-Java Build Tools", "MVC-Model View Architecture", "Hibernate 3.0,4.0,5.0,5.2", "Spring 3.0,4.0"};
    String[] AndroidHeader = {"Android Overview", "Android Environment Setup", "Android Architecture",
            "Android Basics", "Intents & Filters", "UI layouts & Controls", "Persistence ",
            "Android - Menu", "Fragments, Tab & Tab Activity", "Material Design & View", "JSON Parser", "Telephony & Messaging API",
            "Toast Message & Dialog Box", "Google Map", "Location Based Services", "Camera & gallery management", "Advanced Topic"};
    ListExpandableAdapter listExpandableAdapter;
    CardView card_enquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modular__details);

        GetDataFromIntent();

        InitID();

        //ToolBar Imageview
        backToPreviousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Modular_Details.this, ModularCourses.class));
                finish();

            }
        });


        card_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Modular_Details.this, Details_Enquiry.class));
                finish();
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            str_mod_course = extras.getString("mod_course");

        }
    }

    private void InitID() {
        img_detail = (ImageView) findViewById(R.id.img_detail);
        card_enquiry = (CardView) findViewById(R.id.card_enquiry);

        backToPreviousImageView = (ImageView) findViewById(R.id.backToPreviousImageView);
        backToPreviousImageView.setVisibility(View.VISIBLE);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        img_logo.setVisibility(View.GONE);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams) toolbar_title.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        toolbar_title.setLayoutParams(layoutParams);

        if (str_mod_course.equalsIgnoreCase("clang")) {
            toolbar_title.setText(R.string.clang);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[0]));

        } else if (str_mod_course.equalsIgnoreCase("cpluslang")) {
            toolbar_title.setText(R.string.cplus);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[1]));
        } else if (str_mod_course.equalsIgnoreCase("corejava")) {
            toolbar_title.setText(R.string.corejava);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[2]));
        } else if (str_mod_course.equalsIgnoreCase("advjava")) {
            toolbar_title.setText(R.string.advancedjava);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[3]));
        } else if (str_mod_course.equalsIgnoreCase("android")) {
            toolbar_title.setText(R.string.android);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[4]));
        } else if (str_mod_course.equalsIgnoreCase("dotnet")) {
            toolbar_title.setText(R.string.dotnet);

            img_detail.setImageDrawable(getResources().getDrawable(course_icons[5]));
        }



       /* DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;*/


        lvExp = (ExpandableListView) findViewById(R.id.lvExp);
        //  lvExp.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));

        PreparedData();

    }

    private void PreparedData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        if (str_mod_course.equalsIgnoreCase("clang")) {

            for (int i = 0; i < CHeader.length; i++) {
                listDataHeader.add(CHeader[i]);
            }


            // Adding child data
            List<String> C_childlist1 = new ArrayList<String>();
            C_childlist1.add("• Types of Languages");
            C_childlist1.add("• Evolution of 'C' Language");
            C_childlist1.add("• Structure of a ‘C’ Program");
            C_childlist1.add("• ‘C’ Program development life cycle");
            C_childlist1.add("• Executing and Debugging a ‘C’ Program");

            listDataChild.put(listDataHeader.get(0), C_childlist1); // Header, Child data

            List<String> C_childlist2 = new ArrayList<String>();
            C_childlist2.add("• Keywords and Identifiers");
            C_childlist2.add("• Operators");
            C_childlist2.add("• Constants");
            C_childlist2.add("• Variables");
            C_childlist2.add("• Data Types");
            C_childlist2.add("• Precedence of Operators");
            C_childlist2.add("• Scope and Lifetime of Variables");
            listDataChild.put(listDataHeader.get(1), C_childlist2); // Header, Child data

            List<String> C_childlist3 = new ArrayList<String>();
            C_childlist3.add("• Decision Making using if");
            C_childlist3.add("• statement Types of if …else block");
            C_childlist3.add("• Switch case Block ");
            C_childlist3.add("• Arithmetic Expressions");
            C_childlist3.add("• Evaluation of Expressions");
            C_childlist3.add("• goto statement");
            listDataChild.put(listDataHeader.get(2), C_childlist3); // Header, Child data

            List<String> C_childlist4 = new ArrayList<String>();
            C_childlist4.add("• Concept of Loop");
            C_childlist4.add("• For loop");
            C_childlist4.add("• While loop");
            C_childlist4.add("• Do while loop");
            C_childlist4.add("• Jumping in Loop");
            C_childlist4.add("• break and continue statement");
            listDataChild.put(listDataHeader.get(3), C_childlist4); // Header, Child data

            List<String> C_childlist5 = new ArrayList<String>();
            C_childlist5.add("• Introduction of Array");
            C_childlist5.add("• One - D Array");
            C_childlist5.add("• Two - D Array");
            C_childlist5.add("• Mutlidimensional Array");
            C_childlist5.add("• Dynmaic Arrays");
            C_childlist5.add("• Implementing String Variables");
            C_childlist5.add("• String handling Functions");
            listDataChild.put(listDataHeader.get(4), C_childlist5); // Header, Child data


            List<String> C_childlist6 = new ArrayList<String>();
            C_childlist6.add("• Need of Pointers");
            C_childlist6.add("• Types of Pointers ");
            C_childlist6.add("• Pointer Expression");
            C_childlist6.add("• Arrays of Pointers ");
            C_childlist6.add("• Pointers and Functions");
            listDataChild.put(listDataHeader.get(5), C_childlist6); // Header, Child data


            List<String> C_childlist7 = new ArrayList<String>();
            C_childlist7.add("• Concept of Function");
            C_childlist7.add("• User defined Function");
            C_childlist7.add("• System Defined Function");
            C_childlist7.add("• Types of parameter passing in function ");
            listDataChild.put(listDataHeader.get(6), C_childlist7); // Header, Child data

            List<String> C_childlist8 = new ArrayList<String>();
            C_childlist8.add("• Need of Structure Implementing ");
            C_childlist8.add("• Structure Variable ");
            C_childlist8.add("• Arrays of Structure");
            C_childlist8.add("• Structure within Structure");
            C_childlist8.add("• Introduction of Unions");
            C_childlist8.add("• Difference between Structure and Unions");
            listDataChild.put(listDataHeader.get(7), C_childlist8); // Header, Child data

            List<String> C_childlist9 = new ArrayList<String>();
            C_childlist9.add("• Opening and Closing File");
            C_childlist9.add("• Input / Output operations on File");
            C_childlist9.add("• Random Access to Files");
            listDataChild.put(listDataHeader.get(8), C_childlist9); // Header, Child data

            List<String> C_childlist10 = new ArrayList<String>();
            C_childlist10.add("• Concept of Dynamic Allocation");
            C_childlist10.add("• Implementing Malloc and Calloc");
            C_childlist10.add("• Functions Releasing the free space");

            listDataChild.put(listDataHeader.get(9), C_childlist10); // Header, Child data


            List<String> C_childlist11 = new ArrayList<String>();
            C_childlist11.add("• Introduction of Preprocessor");
            C_childlist11.add("• Macro Substitution");
            C_childlist11.add("• Macro Programming");
            listDataChild.put(listDataHeader.get(10), C_childlist11); // Header, Child data

            List<String> C_childlist12 = new ArrayList<String>();
            C_childlist12.add("• Concept of Data Structure");
            C_childlist12.add("• Types of Data Structure ");
            C_childlist12.add("• Implementing Stack");
            C_childlist12.add("• Implementing Linked List");
            listDataChild.put(listDataHeader.get(11), C_childlist12); // Header, Child data

         /*   for(int i=0;i<CHeader.length;i++)
            {
                listDataChild.put(listDataHeader.get(i), C_childlist1); // Header, Child data
            }*/

        } else if (str_mod_course.equalsIgnoreCase("cpluslang")) {
            for (int i = 0; i < CPlusHeader.length; i++) {
                listDataHeader.add(CPlusHeader[i]);
            }


            // Adding child data
            List<String> Cplus_childlist1 = new ArrayList<String>();
            Cplus_childlist1.add("• Concept of OOP");
            Cplus_childlist1.add("• Features of OOP");
            Cplus_childlist1.add("• Introduction of ‘C++’");
            Cplus_childlist1.add("• Structure of ‘C++’ program");
            Cplus_childlist1.add("• Executing and Debugging a ‘C++’ Program");

            listDataChild.put(listDataHeader.get(0), Cplus_childlist1); // Header, Child data

            // Adding child data
            List<String> Cplus_childlist2 = new ArrayList<String>();
            Cplus_childlist2.add("• Call by reference, Return by reference");
            Cplus_childlist2.add("• Function overloading and default arguments");
            Cplus_childlist2.add("• Inline function");
            Cplus_childlist2.add("• Static class members");
            Cplus_childlist2.add("• Friend functions");
            Cplus_childlist2.add("• Virtual Functions");
            listDataChild.put(listDataHeader.get(1), Cplus_childlist2); // Header, Child data

            // Adding child data
            List<String> Cplus_childlist3 = new ArrayList<String>();
            Cplus_childlist3.add("• The Control-Flow Program Statements");
            Cplus_childlist3.add("• Looping Statements");
            listDataChild.put(listDataHeader.get(2), Cplus_childlist3); // Header, Child data

            List<String> Cplus_childlist4 = new ArrayList<String>();
            Cplus_childlist4.add("• Classes & Object specifiers");
            Cplus_childlist4.add("• Defining data members and member functions");
            Cplus_childlist4.add("• Array of objects");
            Cplus_childlist4.add("• Managing console I/O");
            Cplus_childlist4.add("• ‘C++’ stream classes");
            Cplus_childlist4.add("• Formatted and unformatted console I/O");
            listDataChild.put(listDataHeader.get(3), Cplus_childlist4); // Header, Child data

            List<String> Cplus_childlist5 = new ArrayList<String>();
            Cplus_childlist5.add("• Concept of Constructor");
            Cplus_childlist5.add("• Types of Constructor");
            Cplus_childlist5.add("• Memory allocation (new and delete) ");
            Cplus_childlist5.add("• Usage of destructor ");

            listDataChild.put(listDataHeader.get(4), Cplus_childlist5); // Header, Child data

            List<String> Cplus_childlist6 = new ArrayList<String>();
            Cplus_childlist6.add("• Types of inheritance");
            Cplus_childlist6.add("• Virtual base classes and abstract base classes");
            Cplus_childlist6.add("• Constructor and destructor in derived class");

            listDataChild.put(listDataHeader.get(5), Cplus_childlist6); // Header, Child data

            List<String> Cplus_childlist7 = new ArrayList<String>();
            Cplus_childlist7.add("• Overloading Unary and Binary operators ");
            Cplus_childlist7.add("• Overloading using friend function");

            listDataChild.put(listDataHeader.get(6), Cplus_childlist7); // Header, Child data

            List<String> Cplus_childlist8 = new ArrayList<String>();
            Cplus_childlist8.add("• Types of Polymorphism");
            Cplus_childlist8.add("• Function Overloading");
            Cplus_childlist8.add("• Function Overriding");

            listDataChild.put(listDataHeader.get(7), Cplus_childlist8); // Header, Child data

            List<String> Cplus_childlist9 = new ArrayList<String>();
            Cplus_childlist9.add("• Abstraction Implementing ");
            Cplus_childlist9.add("• Real Time Example");
            Cplus_childlist9.add("• Encapsulation Implementing");
            Cplus_childlist9.add("• Real Time Example");
            listDataChild.put(listDataHeader.get(8), Cplus_childlist9); // Header, Child data

            List<String> Cplus_childlist10 = new ArrayList<String>();
            Cplus_childlist10.add("• Various Exception Handling classes");
            Cplus_childlist10.add("• Implementing try and catch block");
            Cplus_childlist10.add("• Use of throw keyword");

            listDataChild.put(listDataHeader.get(9), Cplus_childlist10); // Header, Child data

            List<String> Cplus_childlist11 = new ArrayList<String>();
            Cplus_childlist11.add("• Introduction to Templates");
            Cplus_childlist11.add("• Class templates");
            Cplus_childlist11.add("• Function Templates");

            listDataChild.put(listDataHeader.get(10), Cplus_childlist11); // Header, Child data


        } else if (str_mod_course.equalsIgnoreCase("corejava")) {
            for (int i = 0; i < CorejavaHeader.length; i++) {
                listDataHeader.add(CorejavaHeader[i]);
            }


            // Adding child data
            List<String> Corejava_childlist1 = new ArrayList<String>();
            Corejava_childlist1.add("• Classes and Objects");
            Corejava_childlist1.add("• Aggregation and Composition");
            Corejava_childlist1.add("• Static and Dynamic Binding");
            Corejava_childlist1.add("• Abstract class and Interface");
            Corejava_childlist1.add("• Encapsulation");

            listDataChild.put(listDataHeader.get(0), Corejava_childlist1); // Header, Child data


            // Adding child data
            List<String> Corejava_childlist2 = new ArrayList<String>();
            Corejava_childlist2.add("• What is Java?");
            Corejava_childlist2.add("• Execution Model Of Java");
            Corejava_childlist2.add("• Complier Sequence ");
            Corejava_childlist2.add("• A First Java Program");
            Corejava_childlist2.add("• Compiling and Interpreting Applications Using Eclipse");

            listDataChild.put(listDataHeader.get(1), Corejava_childlist2); // Header, Child data


            // Adding child data
            List<String> Corejava_childlist3 = new ArrayList<String>();
            Corejava_childlist3.add("• Data Types & Variables");
            Corejava_childlist3.add("• Methods");
            Corejava_childlist3.add("• Operators & Expressions");
            Corejava_childlist3.add("• Control Flow Statements");
            listDataChild.put(listDataHeader.get(2), Corejava_childlist3); // Header, Child data

            // Adding child data
            List<String> Corejava_childlist4 = new ArrayList<String>();
            Corejava_childlist4.add("• Defining Classes");
            Corejava_childlist4.add("• Access Modifiers");
            Corejava_childlist4.add("• Creating Objects");
            Corejava_childlist4.add("• Constructors and Destructors");
            Corejava_childlist4.add("• Call by value, Call by reference");
            listDataChild.put(listDataHeader.get(3), Corejava_childlist4); // Header, Child data


            List<String> Corejava_childlist5 = new ArrayList<String>();
            Corejava_childlist5.add("• What is a Package?");
            Corejava_childlist5.add("• Types Of Packages");
            Corejava_childlist5.add("• Naming Convention");
            Corejava_childlist5.add("• The import Statement");
            Corejava_childlist5.add("• Static Imports");
            Corejava_childlist5.add("• CLASSPATH and Import");
            Corejava_childlist5.add("• Defining Packages");
            Corejava_childlist5.add("• Package Scope");

            listDataChild.put(listDataHeader.get(4), Corejava_childlist5); // Header, Child data


            List<String> Corejava_childlist6 = new ArrayList<String>();
            Corejava_childlist6.add("• Types of Inheritance");
            Corejava_childlist6.add("• Super Keyword");
            Corejava_childlist6.add("• Polymorphism");
            Corejava_childlist6.add("• Types of Polymorphism");

            listDataChild.put(listDataHeader.get(5), Corejava_childlist6); // Header, Child data


            List<String> Corejava_childlist7 = new ArrayList<String>();
            Corejava_childlist7.add("• What is an Interface");
            Corejava_childlist7.add("• Defining Interfaces");
            Corejava_childlist7.add("• Separating Interface and Implementation");
            Corejava_childlist7.add("• Implementing and Extending Interfaces");
            Corejava_childlist7.add("• Abstract Classes");

            listDataChild.put(listDataHeader.get(6), Corejava_childlist7); // Header, Child data

            List<String> Corejava_childlist8 = new ArrayList<String>();
            Corejava_childlist8.add("• Exception Handling Overview");
            Corejava_childlist8.add("• Catch and Finally Blocks");
            Corejava_childlist8.add("• Throw");
            Corejava_childlist8.add("• Exception Methods");
            Corejava_childlist8.add("• Errors and Runtime Exception");

            listDataChild.put(listDataHeader.get(7), Corejava_childlist8); // Header, Child data


            List<String> Corejava_childlist9 = new ArrayList<String>();
            Corejava_childlist9.add("• Introduction to Threads");
            Corejava_childlist9.add("• Life cycle of thread");
            Corejava_childlist9.add("• Creating Thread and Thread Scheduler");
            Corejava_childlist9.add("• Sleeping and Joining Thread");
            Corejava_childlist9.add("• Thread Priority");

            listDataChild.put(listDataHeader.get(8), Corejava_childlist9); // Header, Child data

            List<String> Corejava_childlist10 = new ArrayList<String>();
            Corejava_childlist10.add("• Introduction to Swing");
            Corejava_childlist10.add("• Swing GUI Components");
            Corejava_childlist10.add("• Event Handling in Swing");

            listDataChild.put(listDataHeader.get(9), Corejava_childlist10); // Header, Child data


            List<String> Corejava_childlist11 = new ArrayList<String>();
            Corejava_childlist11.add("• Introduction to Applet");
            Corejava_childlist11.add("• The Applet Hierarchy");
            Corejava_childlist11.add("• Life Cycle of an Applet");
            Corejava_childlist11.add("• Lifecycle Methods for Applet");
            Corejava_childlist11.add("• Applet Layout Manager");
            Corejava_childlist11.add("• Bounding Box Concept");
            Corejava_childlist11.add("• Relative Coordinate System");
            listDataChild.put(listDataHeader.get(10), Corejava_childlist11); // Header, Child data

            List<String> Corejava_childlist12 = new ArrayList<String>();
            Corejava_childlist12.add("• Introduction to JDBC");
            Corejava_childlist12.add("• Types Of JDBC Drivers & Differences");
            Corejava_childlist12.add("• Common JDBC Components");
            Corejava_childlist12.add("• Importing Packages");
            Corejava_childlist12.add("• Registering JDBC Drivers");
            Corejava_childlist12.add("• Opening Connection");
            Corejava_childlist12.add("• Connecting a Java program to a Database");
            Corejava_childlist12.add("• Executing Query");
            Corejava_childlist12.add("• Statement Class & Objects");
            Corejava_childlist12.add("• Getting Information from Database");
            Corejava_childlist12.add("• Obtaining Result Set Information");
            listDataChild.put(listDataHeader.get(11), Corejava_childlist12); // Header, Child data


            List<String> Corejava_childlist13 = new ArrayList<String>();
            Corejava_childlist13.add("• Set Interface & Methods");
            Corejava_childlist13.add("• Life cycle of thread");
            Corejava_childlist13.add("• List Interface & Classes");
            Corejava_childlist13.add("• Map Interface & Classes");
            Corejava_childlist13.add("• Utility Classes");
            listDataChild.put(listDataHeader.get(12), Corejava_childlist13); // Header, Child data


        } else if (str_mod_course.equalsIgnoreCase("advjava")) {
            for (int i = 0; i < AdvancedjavaHeader.length; i++) {
                listDataHeader.add(AdvancedjavaHeader[i]);
            }


            // Adding child data
            List<String> Advjava_childlist1 = new ArrayList<String>();
            Advjava_childlist1.add("• HTML Basics");
            Advjava_childlist1.add("• HTML Elements");
            Advjava_childlist1.add("• CSS Introduction");
            Advjava_childlist1.add("• CSS Syntax");
            Advjava_childlist1.add("• Javascript Overview ");

            listDataChild.put(listDataHeader.get(0), Advjava_childlist1); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist2 = new ArrayList<String>();
            Advjava_childlist2.add("• Reflection Overview");
            Advjava_childlist2.add("• Annotation Overview");
            Advjava_childlist2.add("• Uses of annotation ");

            listDataChild.put(listDataHeader.get(1), Advjava_childlist2); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist3 = new ArrayList<String>();
            Advjava_childlist3.add("• Introduction To JDBC");
            Advjava_childlist3.add("• JDBC Driver");
            Advjava_childlist3.add("• Connection with JDBC");
            Advjava_childlist3.add("• Prepared Statement");
            Advjava_childlist3.add("• ResultSet");

            listDataChild.put(listDataHeader.get(2), Advjava_childlist3); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist4 = new ArrayList<String>();
            Advjava_childlist4.add("• Introduction to Web Server");
            Advjava_childlist4.add("• Web Application");
            Advjava_childlist4.add("• Web Pages");
            Advjava_childlist4.add("• HTTP Protocol");
            Advjava_childlist4.add("• HTTP request & response");
            Advjava_childlist4.add("• HTTP content types");
            Advjava_childlist4.add("• HTTP request method");

            listDataChild.put(listDataHeader.get(3), Advjava_childlist4); // Header, Child data

            // Adding child data
            List<String> Advjava_childlist5 = new ArrayList<String>();
            Advjava_childlist5.add("• Servlet Overview and Architecture");
            Advjava_childlist5.add("• Servlet Life Cycle");
            Advjava_childlist5.add("• GenericServlet class");
            Advjava_childlist5.add("• HttpServlet class");
            Advjava_childlist5.add("• Compilation/Execution of servlet");
            Advjava_childlist5.add("• Servlet Navigation");
            Advjava_childlist5.add("• Servlet Annotation");
            Advjava_childlist5.add("• Cookie");
            Advjava_childlist5.add("• HttpSession");
            Advjava_childlist5.add("• Session Tracking (Cookie, HttpSession, URL rewriting)");
            Advjava_childlist5.add("• ServletContext");

            listDataChild.put(listDataHeader.get(4), Advjava_childlist5); // Header, Child data

            // Adding child data
            List<String> Advjava_childlist6 = new ArrayList<String>();
            Advjava_childlist6.add("• Introduction JSP");
            Advjava_childlist6.add("• JSP Architecture");
            Advjava_childlist6.add("• JSP Life Cycle");
            Advjava_childlist6.add("• JSTL,JSP Tags ");
            Advjava_childlist6.add("• JSP Actions");
            Advjava_childlist6.add("• JSP EL");
            Advjava_childlist6.add("• Custom Tags");

            listDataChild.put(listDataHeader.get(5), Advjava_childlist6); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist7 = new ArrayList<String>();
            Advjava_childlist7.add("• Introduction to ServletContextListener");
            Advjava_childlist7.add("• Introduction to HttpSessionListener");
            Advjava_childlist7.add("• Filters Programming");
            Advjava_childlist7.add("• POP");
            Advjava_childlist7.add("• OOP");
            Advjava_childlist7.add("• SOP");
            Advjava_childlist7.add("• AOP");

            listDataChild.put(listDataHeader.get(6), Advjava_childlist7); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist8 = new ArrayList<String>();
            Advjava_childlist8.add("• Beans Concept");
            Advjava_childlist8.add("• Event In Beans");
            Advjava_childlist8.add("• Preparing class to Java Bean");


            listDataChild.put(listDataHeader.get(7), Advjava_childlist8); // Header, Child data

            // Adding child data
            List<String> Advjava_childlist9 = new ArrayList<String>();
            Advjava_childlist9.add("• Maven, Graddle");
            Advjava_childlist9.add("• Creation of project with Maven");
            Advjava_childlist9.add("• Dependency Libraries ");
            Advjava_childlist9.add("• Build Phases");
            Advjava_childlist9.add("• Repositories");
            Advjava_childlist9.add("• maven Project");

            listDataChild.put(listDataHeader.get(8), Advjava_childlist9); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist10 = new ArrayList<String>();
            Advjava_childlist10.add("• Introduction to MVC");
            Advjava_childlist10.add("• MVC architecture");
            Advjava_childlist10.add("• Model I architecture");
            Advjava_childlist10.add("• Model II architecture");

            listDataChild.put(listDataHeader.get(9), Advjava_childlist10); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist11 = new ArrayList<String>();
            Advjava_childlist11.add("• Introduction to hibernate");
            Advjava_childlist11.add("• Hibernate architecture");
            Advjava_childlist11.add("• ORM-Object Relation Mapping");
            Advjava_childlist11.add("• ORM Mapping using XML");
            Advjava_childlist11.add("• ORM Mapping using annotation");
            Advjava_childlist11.add("• Hibernate Query Language");
            Advjava_childlist11.add("• Hibernate Relations");
            Advjava_childlist11.add("• One to one Mapping");
            Advjava_childlist11.add("• One to Many Mapping");
            Advjava_childlist11.add("• Many to one Mapping");
            Advjava_childlist11.add("• Many to Many Mapping");
            Advjava_childlist11.add("• Inheritance mapping");
            Advjava_childlist11.add("• Criteria Query");
            Advjava_childlist11.add("• Hibernate Entity Life Cycle");
            Advjava_childlist11.add("• JPA Life Cycle");
            Advjava_childlist11.add("• Forward v/s Reverse Engineering");
            Advjava_childlist11.add("• Caching and Transactions ");
            Advjava_childlist11.add("• Fetch Mode & Fetch Type");
            Advjava_childlist11.add("• Hibernate Application");

            listDataChild.put(listDataHeader.get(10), Advjava_childlist11); // Header, Child data


            // Adding child data
            List<String> Advjava_childlist12 = new ArrayList<String>();
            Advjava_childlist12.add("• Introduction of spring");
            Advjava_childlist12.add("• Spring Architecture");
            Advjava_childlist12.add("• Spring Features");
            Advjava_childlist12.add("• Spring Container (IoC)");
            Advjava_childlist12.add("• Dependency Injection");
            Advjava_childlist12.add("• Auto Wiring (XML & Annotation based)");
            Advjava_childlist12.add("• Configuration (XML, Annotation & Mixed)");
            Advjava_childlist12.add("• Stereo-Type Annotations");
            Advjava_childlist12.add("• Spring Hibernate Integration");
            Advjava_childlist12.add("• Spring JUnit integration");
            Advjava_childlist12.add("• Spring EL");
            Advjava_childlist12.add("• Spring AOP");
            Advjava_childlist12.add("• Spring MVC");
            Advjava_childlist12.add("• Spring Transaction Management ");

            listDataChild.put(listDataHeader.get(11), Advjava_childlist12); // Header, Child data
        } else if (str_mod_course.equalsIgnoreCase("android")) {


            for (int i = 0; i < AndroidHeader.length; i++) {
                listDataHeader.add(AndroidHeader[i]);
            }


            // Adding child data
            List<String> Android_childlist1 = new ArrayList<String>();
            Android_childlist1.add("• What is Android");
            Android_childlist1.add("• History of Android");
            Android_childlist1.add("• Features of Android");
            Android_childlist1.add("• Android Application");

            listDataChild.put(listDataHeader.get(0), Android_childlist1); // Header, Child data


            // Adding child data
            List<String> Android_childlist2 = new ArrayList<String>();
            Android_childlist2.add("• Setup java Development Kit (JDK)");
            Android_childlist2.add("• Setup Android SDK");
            Android_childlist2.add("• Setup Eclipse IDE & Android Studio");
            Android_childlist2.add("• Setup ADT-Android Development Tools");
            Android_childlist2.add("• Virtual Devices");

            listDataChild.put(listDataHeader.get(1), Android_childlist2); // Header, Child data

            // Adding child data
            List<String> Android_childlist3 = new ArrayList<String>();
            Android_childlist3.add("• Linux Kernel");
            Android_childlist3.add("• Libraries");
            Android_childlist3.add("• Android Runtime");
            Android_childlist3.add("• Application Framework");

            listDataChild.put(listDataHeader.get(2), Android_childlist3); // Header, Child data


            // Adding child data
            List<String> Android_childlist4 = new ArrayList<String>();
            Android_childlist4.add("• Basic Building Blocks-Activities, Services, Broadcast Receivers & Content Provider");
            Android_childlist4.add("• Basic UI Components");
            Android_childlist4.add("• Advanced UI Design");
            Android_childlist4.add("• Create Basic Android App");
            Android_childlist4.add("• What is manifest File");
            Android_childlist4.add("• Resources, Graddle, APK File");
            Android_childlist4.add("• App on Basics");

            listDataChild.put(listDataHeader.get(3), Android_childlist4); // Header, Child data

            // Adding child data
            List<String> Android_childlist5 = new ArrayList<String>();
            Android_childlist5.add("• Intent Objects");
            Android_childlist5.add("• Action");
            Android_childlist5.add("• Data");
            Android_childlist5.add("• Flags");
            Android_childlist5.add("• Extras");
            Android_childlist5.add("• Communication Activity through Intent");
            Android_childlist5.add("• Types of Intent");
            Android_childlist5.add("• App on Intents");

            listDataChild.put(listDataHeader.get(4), Android_childlist5); // Header, Child data


            // Adding child data
            List<String> Android_childlist6 = new ArrayList<String>();
            Android_childlist6.add("• Layout Types");
            Android_childlist6.add("• Layout Attributes");
            Android_childlist6.add("• View Identification");
            Android_childlist6.add("• UI Controls");
            Android_childlist6.add("• Apps UI Layouts & Control");

            listDataChild.put(listDataHeader.get(5), Android_childlist6); // Header, Child data

            // Adding child data
            List<String> Android_childlist7 = new ArrayList<String>();
            Android_childlist7.add("• SQLITE");
            Android_childlist7.add("• Curd Operation");
            Android_childlist7.add("• Shared Preferences ");
            Android_childlist7.add("• App on Persistence");

            listDataChild.put(listDataHeader.get(6), Android_childlist7); // Header, Child data

            // Adding child data
            List<String> Android_childlist8 = new ArrayList<String>();
            Android_childlist8.add("• Menu");
            Android_childlist8.add("• Option Menu");
            Android_childlist8.add("• Sub Menu ");
            Android_childlist8.add("• Menu Via Code");
            Android_childlist8.add("• App on  menu");

            listDataChild.put(listDataHeader.get(7), Android_childlist8); // Header, Child data

            // Adding child data
            List<String> Android_childlist9 = new ArrayList<String>();
            Android_childlist9.add("• Fragments Life cycle");
            Android_childlist9.add("• Create Tab");
            Android_childlist9.add("• App on Fragments");

            listDataChild.put(listDataHeader.get(8), Android_childlist9); // Header, Child data

            // Adding child data
            List<String> Android_childlist10 = new ArrayList<String>();
            Android_childlist10.add("• List View");
            Android_childlist10.add("• Animation In List View");
            Android_childlist10.add("• Recycler View");
            Android_childlist10.add("• Card View");
            Android_childlist10.add("• App on List View");
            Android_childlist10.add("• App on Recycler View With Card View");
            Android_childlist10.add("• Web View");
            Android_childlist10.add("• App on Web View");

            listDataChild.put(listDataHeader.get(9), Android_childlist10); // Header, Child data


            // Adding child data
            List<String> Android_childlist11 = new ArrayList<String>();
            Android_childlist11.add("• JSON Elements");
            Android_childlist11.add("• JSON Parser");
            Android_childlist11.add("• Internet Packages");
            Android_childlist11.add("• Permission");
            Android_childlist11.add("• App on JSON");

            listDataChild.put(listDataHeader.get(10), Android_childlist11); // Header, Child data

            // Adding child data
            List<String> Android_childlist12 = new ArrayList<String>();
            Android_childlist12.add("• Telephony API");
            Android_childlist12.add("• App on Call API");
            Android_childlist12.add("• Messaging API");
            Android_childlist12.add("• App on Messaging API");

            listDataChild.put(listDataHeader.get(11), Android_childlist12); // Header, Child data

            // Adding child data
            List<String> Android_childlist13 = new ArrayList<String>();
            Android_childlist13.add("• Uses of Toast");
            Android_childlist13.add("• App on Toast ");
            Android_childlist13.add("• Alert Dialog Box");
            Android_childlist13.add("• App on Alert Dialog");
            Android_childlist13.add("• Custom Dialog Box");
            Android_childlist13.add("• App on Custom Dialog");

            listDataChild.put(listDataHeader.get(12), Android_childlist13); // Header, Child data


            // Adding child data
            List<String> Android_childlist14 = new ArrayList<String>();
            Android_childlist14.add("• Adding Google map");
            Android_childlist14.add("• Integrating Google maps");
            Android_childlist14.add("• Download & Configure, Google Play services SDK");
            Android_childlist14.add("• Obtaining API KEY");
            Android_childlist14.add("• Specify Android Manifest Settings ");
            Android_childlist14.add("• Add marker");
            Android_childlist14.add("• Add Circle on Map");
            Android_childlist14.add("• App on Google map");

            listDataChild.put(listDataHeader.get(13), Android_childlist14); // Header, Child data


            // Adding child data
            List<String> Android_childlist15 = new ArrayList<String>();
            Android_childlist15.add("• Introduction of GPS");
            Android_childlist15.add("• Location Object");
            Android_childlist15.add("• Get Current Location");
            Android_childlist15.add("• Get Updated Location");
            Android_childlist15.add("• Display Location Object");
            Android_childlist15.add("• App on Location Based");

            listDataChild.put(listDataHeader.get(14), Android_childlist15); // Header, Child data

            // Adding child data
            List<String> Android_childlist16 = new ArrayList<String>();
            Android_childlist16.add("• Camera API");
            Android_childlist16.add("• App on Camera ");
            Android_childlist16.add("• Gallery Access (Read Image, Docs File, PDF)");
            Android_childlist16.add("• App on Gallery");

            listDataChild.put(listDataHeader.get(15), Android_childlist16); // Header, Child data


            // Adding child data
            List<String> Android_childlist17 = new ArrayList<String>();
            Android_childlist17.add("• App on Image Switcher");
            Android_childlist17.add("• Broadcast Receiver");
            Android_childlist17.add("• MVC Structure Coding");
            Android_childlist17.add("• Calculator App");
            Android_childlist17.add("• App on Video (Multimedia)");

            listDataChild.put(listDataHeader.get(16), Android_childlist17); // Header, Child data


        }


        listExpandableAdapter = new ListExpandableAdapter(Modular_Details.this, listDataHeader, listDataChild);
        lvExp.setAdapter(listExpandableAdapter);

    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Modular_Details.this, ModularCourses.class));
        finish();
    }
}
