package com.example.onessegain;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    Button login;
    EditText emailt ,pass;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.button);
        emailt = findViewById(R.id.editText3);
        pass = findViewById(R.id.editText4);




        login.setOnClickListener(this);
    }
     private void loginpage(){

         email = "visionhackers@svce.com";
         password = "kishore99";

         mAuth.signInWithEmailAndPassword(email, password)
                 .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             // Sign in success, update UI with the signed-in user's information
                             FirebaseUser user = mAuth.getCurrentUser();
                             updateUI(user);
                         } else {
                             // If sign in fails, display a message to the user.

                             updateUI(null);
                         }

                         // ...
                     }
                 });
     }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {

        if(currentUser!= null) {
            Toast.makeText(this, "Signed-In verified ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

            if (view == login)
            {
                loginpage();
            }
    }
}
