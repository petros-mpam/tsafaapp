package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView tvemail=(TextView)findViewById(R.id.tvemail);
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








    }
}
