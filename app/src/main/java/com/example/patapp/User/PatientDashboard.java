package com.example.patapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.patapp.Common.LoginSignUp.PatientStartUp;
import com.example.patapp.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.example.patapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.patapp.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.patapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PatientDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //variables
    static final float END_SCALE = 0.7f;

    LinearLayout contentView;

    RecyclerView featuredRecycler;
    RecyclerView viewRecycler;
    RecyclerView categoryRecycler;

    RecyclerView.Adapter adapter;

    RecyclerView.Adapter catAdapter;

    RecyclerView.Adapter mostAdapter;

    ImageView menuIcon;
    //drawer menu
  DrawerLayout drawerLayout;
  NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager
                .LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_dashboard);

        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();

        viewRecycler = findViewById(R.id.view_recycler);

        viewRecycler();

        categoryRecycler = findViewById(R.id.category_recycler);

        categoryRecycler();


        navigationDrawer();

        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        contentView = findViewById(R.id.content);

    }

    //Navigation Drawer function
    private void navigationDrawer() {
        //menu hooks

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else drawerLayout.openDrawer(GravityCompat.START);
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.card1));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                //Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    private void categoryRecycler() {

        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> categoryHelper = new ArrayList<>();

        categoryHelper.add(new CategoryHelperClass(R.drawable.appointment_doc, "Doctor"));
        categoryHelper.add(new CategoryHelperClass(R.drawable.diagnosis_survey, "Diagnosis Survey"));
        categoryHelper.add(new CategoryHelperClass(R.drawable.drug_store, "Pharmacy"));
        categoryHelper.add(new CategoryHelperClass(R.drawable.nearby_hospitals, "Nearby Hospitals"));

        catAdapter = new CategoryAdapter(categoryHelper);
        categoryRecycler.setAdapter(catAdapter);

    }

    private void viewRecycler() {

        viewRecycler.setHasFixedSize(true);
        viewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostView = new ArrayList<>();

        mostView.add(new MostViewedHelperClass(R.drawable.adi_coco, "Dr. Adi", "she is precise and caring."));
        mostView.add(new MostViewedHelperClass(R.drawable.humberto_chavez, "Dr. Chavez", "she is precise and caring."));
        mostView.add(new MostViewedHelperClass(R.drawable.brian_mercado, "Dr. Brian", "she is precise and caring."));
        mostView.add(new MostViewedHelperClass(R.drawable.bruno_rodrigues, "Dr. Rodrigues", "she is precise and caring."));


        mostAdapter = new MostViewedAdapter(mostView);
        viewRecycler.setAdapter(mostAdapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true); //load views that are visible to users
        featuredRecycler
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredDoctors = new ArrayList<>();

        featuredDoctors.add(new FeaturedHelperClass(R.drawable.adi_coco, "Dr. Adi", "Dr. Austin is just plain Awesome!!"));
        featuredDoctors.add(new FeaturedHelperClass(R.drawable.brian_mercado, "Dr. Brian", "Dr. Austin is just plain Awesome!!"));
        featuredDoctors.add(new FeaturedHelperClass(R.drawable.humberto_chavez, "Dr. Humberto", "Dr. Austin is just plain Awesome!!"));


        adapter = new FeaturedAdapter(featuredDoctors);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    // normal functions
    public void callPatientStartup(View view){
        startActivity(new Intent(getApplicationContext(), PatientStartUp.class));

    }


}