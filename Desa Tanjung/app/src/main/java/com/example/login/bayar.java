package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bayar extends AppCompatActivity {
    String CO;
    int CheckOut, bayarfinal, totalbayar;
    EditText bayar;
    TextView kembalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bayar);
        CO = getIntent().getStringExtra("Data");

        TextView CO1 = (TextView) findViewById(R.id.CheckOut);
        CO1.setText(CO);





    }

    public void BtnBayar(View view) {
        try {
            CheckOut = Integer.parseInt(CO);
        }
        catch (NumberFormatException e){
            CheckOut = 0;
        }
        bayar =(EditText)findViewById(R.id.Ed_bayar);
        kembalian =(TextView)findViewById(R.id.KembalianText);
        bayarfinal = Integer.parseInt(bayar.getText().toString());

        totalbayar = bayarfinal-CheckOut;
        kembalian.setText(Integer.toString(totalbayar));
    }
}

