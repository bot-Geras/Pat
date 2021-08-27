package com.example.patapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.patapp.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.example.patapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.patapp.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.patapp.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.patapp.R;

import java.util.ArrayList;

public class PatientDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView viewRecycler;
    RecyclerView categoryRecycler;

    RecyclerView.Adapter adapter;

    RecyclerView.Adapter catAdapter;

    RecyclerView.Adapter mostAdapter;

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


}