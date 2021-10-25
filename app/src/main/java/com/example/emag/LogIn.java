package com.example.emag;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {

    private Button btnContNou, btnApple, btnGoogle, btnFacebook;
    private final int MAIN_ACTIVITY_REQUEST_CODE = 100;
    private EditText editText_email, editText_parola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        editText_email = findViewById(R.id.email);
        editText_parola = findViewById(R.id.parola);
        btnApple = findViewById(R.id.btnApple);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnContNou = findViewById(R.id.btnContNou);
        btnContNou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, ContNou.class);
                //startActivity(intent);
                startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
            }
        });
        btnApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://appleid.apple.com/"));
                startActivity(appleIntent);
            }
        });


        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signin/v2/identifier?hl=ro&continue=https%3A%2F%2Fmail.google.com&service=mail&ec=GAlAFw&flowName=GlifWebSignIn&flowEntry=AddSession"));
                startActivity(googleIntent);
            }
        });
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(facebookIntent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAIN_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    // Bundle bundle=data.getExtras();
                    // Cont cont=bundle.getParcelable("ok");
                    Cont cont = data.getParcelableExtra("AAA");
                    editText_email.setText(cont.getEmail());
                    editText_parola.setText(cont.getParola());


                }

            }
        }

    }



}