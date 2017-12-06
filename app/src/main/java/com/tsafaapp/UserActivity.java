package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    String[] c_names = { "women","men","bags","watches","jewls","sunglasses","accessories","kids"};

    int [] a_items = {R.drawable.women1,R.drawable.men1,R.drawable.bags1,R.drawable.watches1,R.drawable.jewls1,
            R.drawable.sunglasses1 ,R.drawable.accessories1,R.drawable.kids1};


    android.support.v7.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<Items> arrayList = new ArrayList<>();



    //private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;
        for (String Name : c_names)
        {
            arrayList.add(new Items(Name,a_items[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);


      /*  TextView tvemail=(TextView)findViewById(R.id.tvemail);
        Button bcshop=(Button)findViewById(R.id.bcshop);
        Button blogout=(Button)findViewById(R.id.bLogout1);

        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();


        //Read Data from the Database about recycleview menu (peter)
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recyler_data");
        ////////////////////////////////////////////////////////////////////

















        tvemail.setText("Welcome "+user.getEmail());

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(UserActivity.this,LoginActivity.class));
            }
        });

        bcshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),ShopperRegisterActivity.class));
            }
        });


*/





    }


}
