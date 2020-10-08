package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpFirebaseAuth extends AppCompatActivity {
EditText emailEditText, passwordEditText;
Button signUpButton;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_firebase_auth);

        mAuth=FirebaseAuth.getInstance();
        emailEditText=(EditText)findViewById(R.id.emailEditText);
        passwordEditText=(EditText)findViewById(R.id.passwordEditText);
        signUpButton=(Button)findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                sendData(email,password);
            }
        });
    }

    private void sendData(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                          //  Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        }                             // If sign in fails, display a message to the user.
                        Toast.makeText(SignUpFirebaseAuth.this, "Working", Toast.LENGTH_SHORT).show();
                        // ...
                    }
                });
    }
}
