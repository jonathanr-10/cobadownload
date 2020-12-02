package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.model.MainActivity;
import com.sammymanunggal.tugasBesarPBP.model.ProfileActivity;
import com.sammymanunggal.tugasBesarPBP.model.admin.NewsMainActivity;
import com.sammymanunggal.tugasBesarPBP.model.orderticket.User;

public class SignIn extends AppCompatActivity {
    TextInputEditText emailInputan, passwordInputan;
    Button buttonnSignUp, buttonSignIn;
    private Preferensi preferensi;


    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    TextView tvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailInputan= findViewById(R.id.editTextEmailAddress);
        passwordInputan = findViewById(R.id.editTextPassword);
        buttonnSignUp = findViewById(R.id.buttonSignUp);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        tvSignUp = findViewById(R.id.SignUpHere);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){

                }
                else{
                    Toast.makeText(SignIn.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInputan.getText().toString();
                String pwd = passwordInputan.getText().toString();

                if(email.equals("admin")&& pwd.equals("admin")){

                    Intent intent = new Intent(SignIn.this, NewsMainActivity.class);
                    startActivity(intent);
                }
                else {
                    if (email.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(SignIn.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    } else if (email.isEmpty()) {
                        Toast.makeText(SignIn.this, "Email Invalid", Toast.LENGTH_SHORT).show();
                    } else if (pwd.isEmpty()) {
                        Toast.makeText(SignIn.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    } else if (pwd.length() < 6) {
                        Toast.makeText(SignIn.this, "Password too short", Toast.LENGTH_SHORT).show();
                    } else if (!(email.isEmpty() && pwd.isEmpty())) {
                        //PAKAI FIREBASE

                        mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignIn.this, "Email Invalid", Toast.LENGTH_SHORT).show();
                                } else {

                                    SharedPreferences mSettings = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = mSettings.edit();
                                    editor.putInt("isLogin", 1);
                                    editor.putString("email", emailInputan.getText().toString());
                                    editor.apply();

                                    Toast.makeText(SignIn.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    Intent intToHome = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intToHome);
                                    SignIn.this.finish();
                                }
                            }

                        });


                    } else {
                        Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent(SignIn.this, SignUp.class);
                startActivity(intSignUp);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}