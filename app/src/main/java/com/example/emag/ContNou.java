package com.example.emag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContNou extends AppCompatActivity {
private Button btn;
Intent intent;
Cont cont;
private EditText editText_nume, editText_email, editText_parola;
boolean isPasswordValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_nou);
        intent=getIntent();

        cont= new Cont();

        btn=findViewById(R.id.btnCreeazaCont);
        editText_nume=findViewById(R.id.ed_numeprenume);
        editText_email=findViewById(R.id.ed_email);
        editText_parola=findViewById(R.id.ed_parola);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValid()) {

                    cont.setNume(editText_nume.getText().toString());
                    cont.setEmail(editText_email.getText().toString());
                    cont.setParola(editText_parola.getText().toString());
                    //Bundle bundle= new Bundle();
                    //bundle.putParcelable("OK",cont);
                    intent.putExtra("AAA", cont);
                    setResult(RESULT_OK, intent);
                    finish();


                }
            }


        });
    }
    private Boolean isValid() {
        if (editText_nume.getText().toString().isEmpty()) {
            Toast.makeText(ContNou.this, "Campul pentru nume nu este completat", Toast.LENGTH_LONG).show();
            return false;
        }

        if(!isEmailValid(editText_email.getText().toString()))
        {
            Toast.makeText(ContNou.this, "Emailul nu respecta formatul", Toast.LENGTH_LONG).show();
            return false;
        }

        if (editText_parola.getText().toString().isEmpty()) {
            Toast.makeText(ContNou.this, "Campul pentru parola nu este completat", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }




}