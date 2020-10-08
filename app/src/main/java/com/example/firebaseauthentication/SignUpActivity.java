package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
RadioGroup radioGroup;
Button signUpButton;
EditText emailEditText,passwordEditText;
RadioButton radioButton;
DatabaseReference databaseReference,sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        signUpButton=(Button)findViewById(R.id.signUpButton);
        emailEditText=(EditText)findViewById(R.id.emailEditText);
        passwordEditText=(EditText)findViewById(R.id.passwordEditText);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();

                int selectedId=radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(selectedId);

                if(radioButton.getText().equals("Detector")){

                    Log.e("Hello",String.valueOf(1));
                    sendDataToFirebaseDatabase(1,email,password);


                }else if(radioButton.getText().equals("Resolver")){
                    Log.e("Hello",String.valueOf(2));
                    sendDataToFirebaseDatabase(2,email,password);
                }else if (radioButton.getText().equals("Financer")){
                    Log.e("Hello",String.valueOf(3));
                    sendDataToFirebaseDatabase(3,email,password);
                }

            }
        });
    }

    private void sendDataToFirebaseDatabase(int a, String receivedEmail, String receivedPassword) {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

                String temp = databaseReference.push().getKey();
                sid = databaseReference.child(temp);
                HashMap<String, Object> map = new HashMap<>();
                map.put("RoleId", a);
                map.put("Email", receivedEmail);
                map.put("Password", receivedPassword);

                sid.updateChildren(map);
    }
}
