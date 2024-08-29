package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class login extends AppCompatActivity {
    private Button btnLogin,btnRegis;
    private EditText username, password;
    private SignInButton login;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegis = (Button) findViewById(R.id.btnRegis);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString(); //ambil dr android
                String pass = password.getText().toString();
                SharedPreferences prefer =
                        getSharedPreferences("MYDATA",MODE_PRIVATE);
                String username = prefer.getString("user",null); //dari prefer MYDATA
                String password = prefer.getString("pass",null);
                System.out.println("User : "+user+" = "+username + ", dan pass = "+pass+"="+
                        password);
                if ((username != null && password != null) && (username.equals(user) &&
                        password.equals(pass)))
                { //username and password are present, do your stuff
                    Intent iMain = new Intent(login.this, menu.class);
                    startActivity(iMain);
                }else
                {       Toast.makeText(getApplicationContext(),
                        "Belum register....!!! atau User & Password tidak cocok...!!",
                        Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iRegis = new Intent(login.this,
                        register.class);startActivity(iRegis);
                finish();
            }
        });

            login = findViewById(R.id.sign_in_button);
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LoginGoogle();            }
            });    }

        private void LoginGoogle() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);    }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RC_SIGN_IN) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);        }
        }
        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
            try {
                final GoogleSignInAccount account = completedTask.getResult(ApiException.class);
                if (!account.getId().equals("")&&!account.getId().equals(null)){
                    Intent i = new Intent(login.this, menu.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();            }
            } catch (ApiException e) {
                Log.d("error", ""+e);
                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();        }
        }
}

