package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tsafaapp.mRecycler.MyAdapter;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    //for search
    RecyclerView rv;
    SearchView sv;
    MyAdapter adapter;
    String[] spacecrafts = {
            "Men Clothes", "Women Clothes", "Accessories", "Kids Clothes", "Other"
    };

    ArrayList<String> spacecraftsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView tvemail = (TextView) findViewById(R.id.tvemail);

        Button blogout = (Button) findViewById(R.id.bLogout1);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        tvemail.setText("Welcome " + user.getEmail());

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(UserActivity.this, LoginActivity.class));
            }
        });

        //Refference views
        rv = (RecyclerView) findViewById(R.id.rv);
        sv = (SearchView) findViewById(R.id.sv);

        //Recycler props
        rv.setLayoutManager(new LinearLayoutManager(this));

        //Fill data
        spacecraftsList = getSpacecrafts();

        //Adapter
        adapter = new MyAdapter(this, spacecraftsList);
        rv.setAdapter(adapter);

        //Events
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });


    }

    private ArrayList<String> getSpacecrafts() {

        for (String s: spacecrafts)
        {
        spacecraftsList.add(s);
        }
        return spacecraftsList;



    }

}
