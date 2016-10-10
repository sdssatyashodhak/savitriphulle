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

public class Hrailwayform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.railwayform);

        Intent intent = getIntent();
        final String starting_station = intent.getStringExtra("starting_station");
        final String DOB = intent.getStringExtra("DOB");
        final int id = intent.getIntExtra("id", -1);


        final EditText ticket1= (EditText)findViewById(R.id.ticketno);
        final EditText pclass1= (EditText)findViewById(R.id.pclass);
        final EditText pestation1= (EditText)findViewById(R.id.pestation);
        final EditText vovno1= (EditText)findViewById(R.id.vov);
        final EditText estation1= (EditText)findViewById(R.id.estation);
        final EditText duration1= (EditText)findViewById(R.id.period);
        final EditText cclass1= (EditText)findViewById(R.id.cclass);
        final EditText sdate1= (EditText)findViewById(R.id.sdate);
        final EditText smonth1= (EditText)findViewById(R.id.smonth);
        final EditText syear1= (EditText)findViewById(R.id.syear);
        final EditText edate1= (EditText)findViewById(R.id.edate);
        final EditText emonth1= (EditText)findViewById(R.id.emonth);
        final EditText eyear1= (EditText)findViewById(R.id.eyear);
        final Button bsubmit=(Button)findViewById(R.id.btnSubmit);

        bsubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                final String ticket=ticket1.getText().toString();
                final String pclass=pclass1.getText().toString();
                final String pestation=pestation1.getText().toString();
                final String vovno=vovno1.getText().toString();
                final String estation=estation1.getText().toString();
                final String period=duration1.getText().toString();
                final String cclass=cclass1.getText().toString();
                String sdate2=sdate1.getText().toString();
                int sdate=Integer.parseInt(sdate2);
                String smonth2=smonth1.getText().toString();
                int smonth=Integer.parseInt(smonth2);
                String syear2=syear1.getText().toString();
                int syear=Integer.parseInt(syear2);
                String edate2=edate1.getText().toString();
                int edate=Integer.parseInt(edate2);
                String emonth2=emonth1.getText().toString();
                int emonth=Integer.parseInt(emonth2);
                String eyear2=eyear1.getText().toString();
                int eyear=Integer.parseInt(eyear2);

                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent= new Intent(Hrailwayform.this,Hlogin.class);
                                Hrailwayform.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(Hrailwayform.this);
                                builder.setMessage("Failed to fill Form")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                HrailwayRequest formRequest=new HrailwayRequest(id,starting_station,DOB,ticket,pclass,pestation,vovno,estation,period,cclass,sdate,smonth,syear,edate,emonth,
                        eyear,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Hrailwayform.this);
                queue.add(formRequest);

            }
        });
    }
}
