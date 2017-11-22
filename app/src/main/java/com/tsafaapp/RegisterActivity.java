package com.tsafaapp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    DatabaseReference Users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth =firebaseAuth.getInstance();
        Users=FirebaseDatabase.getInstance().getReference("User");

        final EditText etname = (EditText) findViewById(R.id.etname);
        final EditText etsurname = (EditText) findViewById(R.id.etsurname);
        final EditText etusernamelogin = (EditText) findViewById(R.id.etusernamelogin);
        final EditText etpasswordlogin = (EditText) findViewById(R.id.etpasswordlogin);
        final EditText etemail = (EditText) findViewById(R.id.etemail);
        CardView cvregister = (CardView) findViewById(R.id.cardView);

        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),UserActivity.class));
        }

        cvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString().trim();
                final String surname=etsurname.getText().toString().trim();
                String username=etusernamelogin.getText().toString().trim();
                String password=etpasswordlogin.getText().toString().trim();
                String email=etemail.getText().toString().trim();
                final  String id=Users.push().getKey();
                final   PelatisData pelatisData=new PelatisData(id,name,surname,username,email);

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(surname)){
                    Toast.makeText(RegisterActivity.this, "Please enter surname", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(username)) {
                    Toast.makeText(RegisterActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }



                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Users.child(id).setValue(pelatisData);
                            finish();
                            startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Could not register,please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



    }

}
