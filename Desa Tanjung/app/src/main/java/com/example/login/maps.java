package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class maps extends AppCompatActivity {
    Button setMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
        setMaps=findViewById(R.id.mapsBtn);


        //set onclicklistener untuk tiap button
        setMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmaps();
            }
        });
    }
    public void openGmaps(){
        //z adalah level zoom. paling tinggi nilainya=23
        String latnLong="@-7.00099160,110.3862600,15z";
        String location="jl.Candi Pawon Tim.VI.no5+Manyaran,+Kec.+Semarang Barat,+Kota+Semarang,+Jawa+Tengah";
        // Map point based on address
        Uri locations = Uri.parse("geo:-7.00099160,110.3862600?q=jl.Candi Pawon Tim.VI.no5+Manyaran,+Kec.+Semarang Barat,+Kota+Semarang,+Jawa+Tengah");
        // Or map point based on latitude/longitude
        //Uri locationz = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent intentPeta = new Intent(Intent.ACTION_VIEW, locations);
        startActivity(intentPeta);
    }
}