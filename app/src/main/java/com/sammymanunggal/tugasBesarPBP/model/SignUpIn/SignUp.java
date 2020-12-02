package com.sammymanunggal.tugasBesarPBP.model.SignUpIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.sammymanunggal.tugasBesarPBP.R;
import com.sammymanunggal.tugasBesarPBP.database.DatabaseClientPreferensi;
import com.sammymanunggal.tugasBesarPBP.model.MainActivity;

public class SignUp extends AppCompatActivity {
    TextInputEditText emailText, passwordText, nameText, addressText, phoneNumberText;
    Button buttonnSignUp, buttonSignIn;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser user;
    TextView tvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mFirebaseAuth = FirebaseAuth.getInstance();
        user = mFirebaseAuth.getCurrentUser();

        emailText= findViewById(R.id.editTextTextEmailAddress);
        passwordText = findViewById(R.id.editTextTextPassword);
        nameText = findViewById(R.id.editTextName);
        addressText = findViewById(R.id.editTextTextAddress);
        phoneNumberText = findViewById(R.id.editTextTextNumber);


        buttonnSignUp = findViewById(R.id.buttonSignUp);
        tvSignIn = findViewById(R.id.SignInHere);
        buttonnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Add ke database client
                addUser();
                Toast.makeText(SignUp.this, "Register berhasil, Please Verify your email", Toast.LENGTH_SHORT).show();
                //untuk login
                final String email = emailText.getText().toString();
                final String pwd = passwordText.getText().toString();

                if(email.isEmpty()){
                    emailText.setError("Please fill Email correctly");
                }
                else if (pwd.isEmpty()){
                    passwordText.setError("Please fill Password correctly");
                } else if (pwd.length()<6){
                    Toast.makeText(SignUp.this, "Password too short, minimum 6 ", Toast.LENGTH_SHORT).show();
                }else if (!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Failed to register", Toast.LENGTH_SHORT).show();
                            }else{
                                mFirebaseAuth.getCurrentUser().sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {

                                                }
                                            }
                                        });
                                startActivity(new Intent(SignUp.this, SignIn.class));
                            }
                        }
                    });
                }else {
                    Toast.makeText(SignUp.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this,SignIn.class);
                startActivity(i);
            }
        });
    }

    private void addUser() {
        final String email = emailText.getText().toString();
        final String pwd = passwordText.getText().toString();
        final String nama = nameText.getText().toString();
        final String address = addressText.getText().toString();
        final String number = phoneNumberText.getText().toString();

        if(nama.isEmpty()){
            nameText.setError("Please fill name correctly");
        } else if( number.isEmpty() ){
            phoneNumberText.setError("Please fill Number correctly");
        } else if (address.isEmpty() ){
            addressText.setError("Please fill address corectly");
        }
        else {
            class AddUser extends AsyncTask<Void, Void, Void> {
                @Override
                protected Void doInBackground(Void... voids) {
                    Preferensi user = new Preferensi();
                    user.setNamePreferensi(nama);
                    user.setPhoneNumber(number);
                    user.setAddress(address);
                    user.setEmailPreferensi(email);
                    user.setPassword(pwd);

                    DatabaseClientPreferensi.getInstance2(getApplicationContext()).getDatabasePreferensi()
                            .PreferensiDao()
                            .insert(user);

                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);

                }
            }
            AddUser add = new AddUser();
            add.execute();
        }
    }
}