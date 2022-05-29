package com.example.projectdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {
    Button forgotBtn;
    EditText forgotEmail;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotBtn=findViewById(R.id.forgot);
        forgotEmail=findViewById(R.id.forgotemail);

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email=forgotEmail.getText().toString();

                if(Email.isEmpty())
                {
                    Toast.makeText(forgot_password.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    forgotpass();
                }
            }
        });
    }

    private void forgotpass() {
        FirebaseAuth auth =FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(Email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(forgot_password.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),StudentSignIn.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(forgot_password.this, "Email Not Sent "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}