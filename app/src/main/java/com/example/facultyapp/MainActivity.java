package com.example.facultyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;
    SharedPreferences logInfo;
    String name,department,imageURL;
    TextView TV_name1,TV_name2,TV_department;
    Button btnmenu,circular,timetable,ecamp,so;
    RelativeLayout maincontent;
    LinearLayout mainmenu;
    Animation fromtop,frombottomm;
    ImageView userpicbig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Button
        btnmenu =  findViewById(R.id.btnmenu);
        circular =  findViewById(R.id.circular);
        timetable =  findViewById(R.id.timetable);
        ecamp =  findViewById(R.id.ecamp);
        so =  findViewById(R.id.so);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        frombottomm = AnimationUtils.loadAnimation(this,R.anim.frombottomm);

        //ImageView
        userpicbig = findViewById(R.id.userpicbig);
        logInfo = getSharedPreferences("LogInfo",MODE_PRIVATE);
        imageURL = logInfo.getString("imageUrl","Error");

        maincontent =  findViewById(R.id.maincontent);
        mainmenu =  findViewById(R.id.mainmenu);

        Picasso.get().load(imageURL).resize(400,350).into(userpicbig);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        //clover = (ImageView) findViewById(R.id.clover);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        TV_name1 = findViewById(R.id.name1);
        TV_name2 = findViewById(R.id.name2);
        TV_department = findViewById(R.id.department);

        logInfo = getSharedPreferences("FacultyLoginInfo",MODE_PRIVATE);
        name = logInfo.getString("name","Error");
        department = logInfo.getString("department","Error");
        TV_name1.setText(name);
        TV_name2.setText(name);
        TV_department.setText(department);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        //clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);



        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //name.setText(userName);
               // rollno.setText(rollNo);
                maincontent.animate().translationX(0);
                mainmenu.animate().translationX(0);

                circular.startAnimation(frombottomm);
                timetable.startAnimation(frombottomm);
                ecamp.startAnimation(frombottomm);
                so.startAnimation(frombottomm);

                //name.startAnimation(fromtop);
               // rollno.startAnimation(fromtop);
                userpicbig.startAnimation(fromtop);

            }
        });
        maincontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maincontent.animate().translationX(-735);
                mainmenu.animate().translationX(-735);
            }
        });





    }
}
