package com.tsafaapp;

/**
 * Created by WHAAAZAAAP on 5/10/2017.
 */

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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;  //Log in FB
    CallbackManager callbackManager; //Log in FB
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etmainemaillogin = (EditText) findViewById(R.id.etmainemaillogin);
        final EditText etmainpasswordlogin = (EditText) findViewById(R.id.etmainpasswordlogin);
        final CardView cvlogin = (CardView) findViewById(R.id.cvlogin);
        final TextView signup = (TextView) findViewById(R.id.signup);

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
        ////////////////////Edw ksekinaei o kwdikas gia to log in tou fb
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("email","public_profile");
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                startActivity(new Intent(getApplicationContext(),UserActivity.class));



            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        ///////////////////////////Edw teleiwnei o kwdikas gia to log in tou fb


    }




}

