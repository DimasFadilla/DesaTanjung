package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class callcenter extends AppCompatActivity {
    Button  setPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callcenter);

        setPhone=findViewById(R.id.kontakButton);

        setPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhone();
            }
        });
    }
    public void openPhone(){
        Uri callNumber=Uri.parse("tel:087817584136");
        Intent callIntent=new Intent(Intent.ACTION_DIAL,callNumber);
        startActivity(callIntent);
    }
}