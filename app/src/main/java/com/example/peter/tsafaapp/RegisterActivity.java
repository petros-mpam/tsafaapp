package com.example.peter.tsafaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etname = (EditText) findViewById(R.id.etname);
        final EditText etsurname = (EditText) findViewById(R.id.etsurname);
        final EditText etusernamelogin = (EditText) findViewById(R.id.etusernamelogin);
        final EditText etpasswordlogin = (EditText) findViewById(R.id.etpasswordlogin);
        final EditText etrenterpassword = (EditText) findViewById(R.id.etrenterpassword);
        final EditText etemail = (EditText) findViewById(R.id.etemail);






    }
}
