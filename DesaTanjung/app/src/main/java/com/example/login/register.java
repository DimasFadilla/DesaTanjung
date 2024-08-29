package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
    private Button btnLogin,btnDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getSupportActionBar().hide();
        final EditText nama,username,password;
        nama = (EditText) findViewById(R.id.inputNama);
        username = (EditText) findViewById(R.id.inputUser);
        password = (EditText) findViewById(R.id.inputPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefer =
                        getSharedPreferences("MYDATA",MODE_PRIVATE);
                String newNama = nama.getText().toString();
                String newUser = username.getText().toString();
                String newPass = password.getText().toString();
                SharedPreferences.Editor edit = prefer.edit();
                edit.putString("nama",newNama);
                edit.putString("user",newUser);
                edit.putString("pass",newPass);
                edit.putString(newUser + newPass + "data", newUser + "\n" + newNama);
                edit.commit();
                Intent iLogin = new Intent(register.this,
                        login.class);
                startActivity(iLogin);}
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogin = new Intent(register.this,
                        login.class);
                startActivity(iLogin);
            }
        });
    }
}
