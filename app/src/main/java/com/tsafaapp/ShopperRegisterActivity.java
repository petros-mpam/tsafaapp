package com.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tsafaapp.domain.PolitisData;

public class ShopperRegisterActivity extends AppCompatActivity {
    DatabaseReference Shop;
    DatabaseReference Users ;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_register);
        firebaseAuth =firebaseAuth.getInstance();
        Shop=FirebaseDatabase.getInstance().getReference("Shop");
        Users =FirebaseDatabase.getInstance().getReference("Users");
        final EditText Shopetname = (EditText) findViewById(R.id.Shopetname);
        final EditText Shopetaddress = (EditText) findViewById(R.id.Shopetaddress);
        final EditText ShopetLongitude = (EditText) findViewById(R.id.ShopetLongitude);
        final EditText ShopetLatitude = (EditText) findViewById(R.id.ShopetLatitude);
        CardView cvShopregister = (CardView) findViewById(R.id.cardView);



        cvShopregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    String name=Shopetname.getText().toString().trim();
                    String address=Shopetaddress.getText().toString().trim();
                    String longtitude=ShopetLongitude.getText().toString().trim();
                    String latitude=ShopetLatitude.getText().toString().trim();
                    String id=Shop.push().getKey();
                    final PolitisData politisData=new PolitisData(name,address,longtitude,latitude,id);


                    if(TextUtils.isEmpty(name)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(address)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter address", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(longtitude)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter longitude", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(latitude)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter latitude", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    Shop.child(id).setValue(politisData);
                    String user=firebaseAuth.getCurrentUser().getUid();
                    Users.child(user).child("idpro").setValue(id);
                    Toast.makeText(ShopperRegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),ShopProfileActivity.class));

                    }}});}};