package com.tsafaapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tsafaapp.domain.PelatisData;
import com.tsafaapp.service.RegisterService;
import com.tsafaapp.utils.ServiceResponse;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference usersRef;

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;

    public RegisterActivity() {
        database = FirebaseDatabase.getInstance();
        usersRef = database.getReference("Users");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();

        nameEditText     = findViewById(R.id.etname);
        surnameEditText  = findViewById(R.id.etsurname);
        emailEditText    = findViewById(R.id.etemail);
        usernameEditText = findViewById(R.id.etusernamelogin);
        passwordEditText = findViewById(R.id.etpasswordlogin);
        final CardView registerCardView = findViewById(R.id.cardView);

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),UserActivity.class));
        }

        registerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterClickListener();
            }
        });
    }

    private void onRegisterClickListener() {
        final PelatisData pelatis = new PelatisData();
        pelatis.setName(nameEditText.getText().toString().trim());
        pelatis.setSurname(surnameEditText.getText().toString().trim());
        pelatis.setUsername(usernameEditText.getText().toString().trim());
        pelatis.setEmail(emailEditText.getText().toString().trim());
        final String password = passwordEditText.getText().toString().trim();

        RegisterService registerService = new RegisterService();
        ServiceResponse resp = registerService.validateUserData(pelatis, password);

        if(resp.isError() || !resp.getMessage().isEmpty()) {
            Toast.makeText(RegisterActivity.this, resp.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(pelatis.getEmail(), password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        onCreateUserComplete(task, pelatis);
                    }
                });
    }

    private void onCreateUserComplete(@NonNull Task<AuthResult> task, PelatisData pelatis) {
        if (task.isSuccessful()) {
            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            String user1 = firebaseAuth.getCurrentUser().getUid();
            usersRef.child(user1).setValue(pelatis);
            startActivity(new Intent(getApplicationContext(), UserActivity.class));
            finish();
        } else {
            Log.e("Register", task.getException().getMessage());
            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
