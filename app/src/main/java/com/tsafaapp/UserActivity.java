package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
Button clickme;
public static TextView textclickme;
    private FirebaseAuth firebaseAuth;

    final FirebaseDatabase Usersdatabase=FirebaseDatabase.getInstance();
    DatabaseReference Users=Usersdatabase.getReference("Users");
    DatabaseReference Shop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView tvemail=(TextView)findViewById(R.id.tvemail);
        Button bcshop=(Button)findViewById(R.id.bcshop);
        Button blogout=(Button)findViewById(R.id.bLogout1);
        firebaseAuth =firebaseAuth.getInstance();
        clickme = (Button) findViewById(R.id.clickme);
        textclickme = (TextView)findViewById(R.id.textclickme);

        Shop=FirebaseDatabase.getInstance().getReference("Shop");
        Users =FirebaseDatabase.getInstance().getReference("Users");


        clickme.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

fetchData process = new fetchData();
process.execute();
            }
        });


        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
       String user1=firebaseAuth.getCurrentUser().getUid();


/*
        Users.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot pelatisSnapshot: dataSnapshot.getChildren()) {
                    PelatisData pelatisData=pelatisSnapshot.getValue(PelatisData.class);

                  //  if (pelatisData.getIdpro()==("-L-rWXcK9An-72PCVBlU"))
                  //  {
                        startActivity(new Intent(getApplicationContext(),ShopProfileActivity.class));
                   // }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

*/
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }




        //Read Data from the Database about recycleview menu (peter)
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recyler_data");
        ////////////////////////////////////////////////////////////////////






        tvemail.setText("Welcome "+user.getUid());

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
                startActivity(new Intent(getApplicationContext(),ShopperRegisterActivity.class));
            }
        });








    }
}
