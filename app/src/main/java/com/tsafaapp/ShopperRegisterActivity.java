package com.tsafaapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopperRegisterActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    DatabaseReference Sellers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_register);
        firebaseAuth =firebaseAuth.getInstance();
        Sellers=FirebaseDatabase.getInstance().getReference("Seller");

        final EditText Shopetname = (EditText) findViewById(R.id.Shopetname);
        final EditText Shopetaddress = (EditText) findViewById(R.id.Shopetaddress);
        final EditText Shopetusername = (EditText) findViewById(R.id.Shopetusername);
        final EditText Shopetpassword = (EditText) findViewById(R.id.Shopetpassword);
        final EditText Shopetemail = (EditText) findViewById(R.id.Shopetemail);
        final EditText ShopetLongitude = (EditText) findViewById(R.id.ShopetLongitude);
        final EditText ShopetLatitude = (EditText) findViewById(R.id.ShopetLatitude);
        CardView cvShopregister = (CardView) findViewById(R.id.cardView);

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),ShopProfileActivity.class));
        }

        cvShopregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    String name=Shopetname.getText().toString().trim();
                    String address=Shopetaddress.getText().toString().trim();
                    String username=Shopetusername.getText().toString().trim();
                    String password=Shopetpassword.getText().toString().trim();
                    String email=Shopetemail.getText().toString().trim();
                    String longtitude=ShopetLongitude.getText().toString().trim();
                    String latitude=ShopetLatitude.getText().toString().trim();
                    final  String id=Sellers.push().getKey();
                    final   PolitisData politisData=new PolitisData(id,name,address,username,email,longtitude,latitude);

                    if(TextUtils.isEmpty(email)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(password)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(name)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(address)){
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter address", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(username)) {
                        Toast.makeText(ShopperRegisterActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
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



                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(ShopperRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ShopperRegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Sellers.child(id).setValue(politisData);
                                finish();
                                startActivity(new Intent(getApplicationContext(),ShopProfileActivity.class));
                            }else{
                                Toast.makeText(ShopperRegisterActivity.this, "Could not register,please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}
