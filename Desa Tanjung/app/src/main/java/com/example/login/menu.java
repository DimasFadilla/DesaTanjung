package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class menu extends AppCompatActivity implements View.OnClickListener  {
    public int total = 0;
    private CardView D1, D2, D3, D4, D5,D6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        D1 = (CardView) findViewById(R.id.item1);
        D2 = (CardView) findViewById(R.id.item2);
        D3 = (CardView) findViewById(R.id.item3);
        D4 = (CardView) findViewById(R.id.item4);
        D5 = (CardView) findViewById(R.id.item5);
        D6 = (CardView) findViewById(R.id.item6);

        D1.setOnClickListener((View.OnClickListener) this);
        D2.setOnClickListener((View.OnClickListener) this);
        D3.setOnClickListener((View.OnClickListener) this);
        D4.setOnClickListener((View.OnClickListener) this);
        D5.setOnClickListener((View.OnClickListener) this);
        D6.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.item1 : i = new Intent(this, d1.class);startActivity(i);break;
            case R.id.item2 : i = new Intent(this, d2.class);startActivity(i);break;
            case R.id.item3 : i = new Intent(this, d3.class);startActivity(i);break;
            case R.id.item4 : i = new Intent(this, d4.class);startActivity(i);break;
            case R.id.item5 : i = new Intent(this, d5.class);startActivity(i);break;
            case R.id.item6 : i = new Intent(this, d6.class);startActivity(i);break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Call) {
            startActivity(new Intent(this, callcenter.class));
        } else if (item.getItemId() == R.id.SMS) {
            startActivity(new Intent(this, sms_center.class));
        } else if (item.getItemId() == R.id.lokasi) {
            startActivity(new Intent(this, maps.class));
        } else if (item.getItemId() == R.id.update) {
            startActivity(new Intent(this, update.class));
        }
        return true;
    }


    public void total_harga(){
        TextView txtTotal = (TextView)findViewById(R.id.jumlah_total);
        DecimalFormat decimalFormat = new DecimalFormat("##,##0.00");
        txtTotal.setText("Total : Rp"+decimalFormat.format(total));
    }

    public void harga_item1(View view) {
        total = total+20000;
        total_harga();
        return;
    }

    public void harga_item2(View view) {
        total = total+30000;
        total_harga();
        return;
    }

    public void harga_item3(View view) {
        total = total+35000;
        total_harga();
        return;
    }

    public void harga_item4(View view) {
        total = total+25000;
        total_harga();
        return;
    }

    public void harga_item5(View view) {
        total = total+30000;
        total_harga();
        return;
    }

    public void harga_item6(View view) {
        total = total+23000;
        total_harga();
        return;
    }

    public void bayarBtn(View view) {
        String parsedata = Integer.toString(total);
        TextView txtTotal = (TextView)findViewById(R.id.jumlah_total);
        Intent intent = new Intent(menu.this, bayar.class);
        intent.putExtra("Data", parsedata);
        startActivity(intent);
    }


}