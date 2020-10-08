package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
DatabaseReference databaseReference,sid;
Button logInButton, signUpButton, loginWithFirebaseAuthButton, signUpWithFirebaseAuthButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInButton=(Button)findViewById(R.id.logInButton);
        signUpButton=(Button)findViewById(R.id.signUpButton);
        loginWithFirebaseAuthButton=(Button)findViewById(R.id.logInWithFirebaseAuthButton);
        signUpWithFirebaseAuthButton=(Button)findViewById(R.id.signUpWithFirebaseAuthButton);
        logInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        loginWithFirebaseAuthButton.setOnClickListener(this);
        signUpWithFirebaseAuthButton.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "On click working", Toast.LENGTH_SHORT).show();
//                databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
//
//                String temp = databaseReference.push().getKey();
//                sid = databaseReference.child(temp);
//                HashMap<String, Object> map = new HashMap<>();
//                map.put("RoleId", "1");
//                map.put("Email", "siddharthbhatheja30@gmail.com");
//                map.put("Password", "abcdef");
//
//                sid.updateChildren(map);
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logInButton:
                Intent logInIntent=new Intent(this,LoginActivity.class);
                startActivity(logInIntent);
                break;
            case R.id.signUpButton:
                Intent signUpIntent=new Intent(this,SignUpActivity.class);
                startActivity(signUpIntent);
                break;

            case R.id.logInWithFirebaseAuthButton:
                Intent logInWithFirebaseAuthIntent=new Intent(this,LoginFirebaseAuth.class);
                startActivity(logInWithFirebaseAuthIntent);
                break;

            case R.id.signUpWithFirebaseAuthButton:
                Intent signUpWithFirebaseAuthIntent=new Intent(this,SignUpFirebaseAuth.class);
                startActivity(signUpWithFirebaseAuthIntent);
                break;
        }
    }
}
