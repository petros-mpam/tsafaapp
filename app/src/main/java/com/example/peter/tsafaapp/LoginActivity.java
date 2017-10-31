package com.example.peter.tsafaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etmainusernamelogin = (EditText) findViewById(R.id.etmainusernamelogin);
        final EditText etmainpasswordlogin = (EditText) findViewById(R.id.etmainpasswordlogin);
        final CardView cvlogin = (CardView) findViewById(R.id.cvlogin);
        final TextView signup = (TextView) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signupIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(signupIntent);
            }
        });
    }
}
