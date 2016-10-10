package com.shivaneeshindegmail.orc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        final EditText id1= (EditText)findViewById(R.id.editText);
        final EditText name1= (EditText)findViewById(R.id.editText2);
        final EditText city1= (EditText)findViewById(R.id.dob);
        final EditText add1= (EditText)findViewById(R.id.editText3);
        final EditText pass1= (EditText)findViewById(R.id.pass);
        final EditText contact1= (EditText)findViewById(R.id.editText4);
        final EditText email1= (EditText)findViewById(R.id.editText5);
        final EditText date1= (EditText)findViewById(R.id.editText6);
        final EditText month1= (EditText)findViewById(R.id.editText7);
        final EditText year1= (EditText)findViewById(R.id.editText8);
        final EditText course1= (EditText)findViewById(R.id.editText11);
        final EditText ans1= (EditText)findViewById(R.id.foodans);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.cast);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.gender);
        final Button bregister=(Button)findViewById(R.id.btnSubmit);

        int selected1=rg1.getCheckedRadioButtonId();
        RadioButton rb1=(RadioButton)findViewById(selected1);
        int selected2=rg2.getCheckedRadioButtonId();
        RadioButton rb2=(RadioButton)findViewById(selected2);

        final String gender = ((RadioButton)findViewById(rg1.getCheckedRadioButtonId() )).getText().toString();
        final String cast = ((RadioButton)findViewById(rg2.getCheckedRadioButtonId() )).getText().toString();

        bregister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                String id2= id1.getText().toString();
                int id=Integer.parseInt(id2);
                final String fullname=name1.getText().toString();
                final String from=city1.getText().toString();
                final String add=add1.getText().toString();
                final String pass=pass1.getText().toString();
                final String phon=contact1.getText().toString();
                final String email=email1.getText().toString();
                String date2=date1.getText().toString();
                int date=Integer.parseInt(date2);
                String month2=month1.getText().toString();
                int month=Integer.parseInt(month2);
                String year2=year1.getText().toString();
                int year=Integer.parseInt(year2);
                final String course=course1.getText().toString();
                final String ans=ans1.getText().toString();

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent= new Intent(Registration.this,Login.class);
                                Registration.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(Registration.this);
                                builder.setMessage("Registration Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                RegisterRequest registerRequest=new RegisterRequest(fullname,id,pass,course,date,month,year,add,gender,cast,from,phon,email,ans,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Registration.this);
                queue.add(registerRequest);

            }
        });
    }
}
