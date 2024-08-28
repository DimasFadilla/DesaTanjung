package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update extends AppCompatActivity {

    private Button btnUpdate;
    SharedPreferences preferences;
    private static final String sharedpref="MYDATA";
    private static final String username="user";
    private static final String password1="pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);


        getSupportActionBar().hide();
        final EditText user, password;
        user = (EditText) findViewById(R.id.username) ;
        password = (EditText) findViewById(R.id.pwBaru);
        preferences = getSharedPreferences(sharedpref, MODE_PRIVATE);
        String oldUser = preferences.getString(username, null);
        String oldPass = preferences.getString(password1, null);
        if(oldUser!=null||oldPass!=null){
            user.setText(oldUser);
            password.setText(oldPass);
        }
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefer =
                        getSharedPreferences("MYDATA",MODE_PRIVATE);
                String newUser = user.getText().toString();
                String newPass = password.getText().toString();
                SharedPreferences.Editor edit = prefer.edit();
                edit.putString("user", newUser);
                edit.putString("pass",newPass);
                edit.commit();
                Intent iLogin = new Intent(update.this,login.class);
                startActivity(iLogin);}
        });
    }
}
