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

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etmainemaillogin = (EditText) findViewById(R.id.etmainemaillogin);
        final EditText etmainpasswordlogin = (EditText) findViewById(R.id.etmainpasswordlogin);
        final CardView cvlogin = (CardView) findViewById(R.id.cvlogin);
        final TextView signup = (TextView) findViewById(R.id.signup);
        final TextView shoppersignup = (TextView) findViewById(R.id.shoppersignup);  //shopperlogin goto1
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),UserActivity.class));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signupIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(signupIntent);
            }
        });

        shoppersignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2){
                Intent shoppersignupIntent = new Intent(LoginActivity.this,ShopperLoginActivity.class);
                LoginActivity.this.startActivity(shoppersignupIntent);
            }
        });


        cvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=etmainpasswordlogin.getText().toString().trim();
                String email=etmainemaillogin.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        }

                    }
                });
            }
        });
    }
}
