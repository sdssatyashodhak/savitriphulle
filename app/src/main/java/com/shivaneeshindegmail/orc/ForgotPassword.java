package com.shivaneeshindegmail.orc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;


public class ForgotPassword extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);


        final EditText id1= (EditText)findViewById(R.id.sidno);
        final EditText name1= (EditText)findViewById(R.id.foodans);
        final EditText npass1= (EditText)findViewById(R.id.npass);

        final Button bSubmit = (Button) findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                String id2= id1.getText().toString();
                int id=Integer.parseInt(id2);
                final String ans=name1.getText().toString();
                final String npass=npass1.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent= new Intent(ForgotPassword.this,Login.class);
                                ForgotPassword.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(ForgotPassword.this);
                                builder.setMessage("Changing Password is Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };
                ForgotRequest forgotRequest=new ForgotRequest(id,ans,npass,responseListener);
                RequestQueue queue= Volley.newRequestQueue(ForgotPassword.this);
                queue.add(forgotRequest);

            }
        });
    }
}
