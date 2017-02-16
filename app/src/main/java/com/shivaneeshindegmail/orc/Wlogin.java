package com.shivaneeshindegmail.orc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import helper.SessionManager;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Wlogin extends AppCompatActivity {

    private static final String TAG = Registration.class.getSimpleName();
    private Button btnLogin;
    private Button btnLinkToRegister;
    private Button btnLinkToForgot;
    private EditText inputEmail;
    private EditText inputPassword;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        session = new Session(this);

        final EditText inputEmail = (EditText) findViewById(R.id.idno);
        final EditText inputPassword = (EditText) findViewById(R.id.password);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        final Button btnLinkToForgot = (Button) findViewById(R.id.btnLinkToForgotPasswordScreen);

        if(session.loggedin()){
            Intent intent= new Intent(Wlogin.this,WActivityMain.class);
            Wlogin.this.startActivity(intent);
        }

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        Wregistration.class);
                startActivity(i);
            }
        });

        // Link to Forgot Screen
        btnLinkToForgot.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        ForgotPassword.class);
                startActivity(i);
            }
        });


        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final String email1=inputEmail.getText().toString();
                final int email= Integer.parseInt(email1);
                final String password = inputPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener= new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){
                                int id =Integer.parseInt(jsonResponse.getString("St_id"));
                                String starting_station=jsonResponse.getString("starting_station");
                                String dob=jsonResponse.getString("St_DOB");

                                session.setLoggedin(true);
                                session.setId(id);
                                session.setdob(dob);
                                session.setstation(starting_station);

                                Intent intent= new Intent(Wlogin.this,WActivityMain.class);
                                intent.putExtra("id",id);
                                intent.putExtra("DOB",dob);
                                intent.putExtra("starting_station",starting_station);
                                Wlogin.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(Wlogin.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                Wlogin_Request login_request=new Wlogin_Request(email,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Wlogin.this);
                queue.add(login_request);
            }

        });

    }

}

