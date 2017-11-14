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

public class ShopperLoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_login);

        final EditText etshopemaillogin = (EditText) findViewById(R.id.etshopemaillogin);
        final EditText etshoppasswordlogin = (EditText) findViewById(R.id.etshoppasswordlogin);
        final TextView shopsignup = (TextView) findViewById(R.id.shopsignup);
        final CardView cvShopperlogin = (CardView) findViewById(R.id.cvShopperlogin);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),UserActivity.class));
        }

        shopsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shopsignupIntent = new Intent(ShopperLoginActivity.this,ShopperRegisterActivity.class);
                ShopperLoginActivity.this.startActivity(shopsignupIntent);
            }
        });

        cvShopperlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2){
                String password=etshoppasswordlogin.getText().toString().trim();
                String email=etshopemaillogin.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ShopperLoginActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(ShopperLoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(ShopperLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),ShopProfileActivity.class));
                        }

                    }
                });
            }
        });
    }
}
