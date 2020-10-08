package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
EditText emailEditText, passwordEditText;
Button loginButton;
DatabaseReference databaseReference;
int flag=0;
Query query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText=(EditText)findViewById(R.id.emailEditText);
        passwordEditText=(EditText)findViewById(R.id.passwordEditText);
        loginButton=(Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
                query=databaseReference.orderByChild("Users");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String email = emailEditText.getText().toString();
                        String password = passwordEditText.getText().toString();
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            //If email exists then toast shows else store the data on new key
                            Log.e("data", "" + data);
                            String receivedRoleId = data.child("RoleId").getValue().toString();
                            String receivedEmail = data.child("Email").getValue().toString();
                            String receivedPassword = data.child("Password").getValue().toString();

                            if(email.equals(receivedEmail)&&password.equals(receivedPassword)){
                                Toast.makeText(LoginActivity.this, "User Found and his role id is"+receivedRoleId, Toast.LENGTH_SHORT).show();
                                flag=1;
                                break;
                            }

                        }

                        if(flag==0){
                            Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
