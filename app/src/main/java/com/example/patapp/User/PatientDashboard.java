package com.example.patapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.patapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.patapp.R;

import java.util.ArrayList;

public class PatientDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager
                .LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_dashboard);

        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true); //load views that are visible to users
        featuredRecycler
                .setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredDoctors = new ArrayList<>();

        featuredDoctors.add(new FeaturedHelperClass(R.drawable.adi_coco,"Dr. Adi","Dr. Austin is just plain Awesome!!"));
        featuredDoctors.add(new FeaturedHelperClass(R.drawable.brian_mercado,"Dr. Brian","Dr. Austin is just plain Awesome!!"));
        featuredDoctors.add(new FeaturedHelperClass(R.drawable.humberto_chavez,"Dr. Humberto","Dr. Austin is just plain Awesome!!"));


        adapter = new FeaturedAdapter(featuredDoctors);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }
}