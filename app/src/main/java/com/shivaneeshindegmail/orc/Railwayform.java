package com.shivaneeshindegmail.orc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Railwayform extends Fragment {

    private Session session;
    FragmentManager mFragmentManager;
    String DOB,starting_station;
    int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.railwayform, container, false);

        session = new Session(getActivity());
        id=session.getid();
        DOB=session.getdob();
        starting_station=session.getstation();
        mFragmentManager = getActivity().getSupportFragmentManager();



        final EditText ticket1= (EditText)view.findViewById(R.id.ticketno);
        final EditText pclass1= (EditText)view.findViewById(R.id.pclass);
        final EditText pestation1= (EditText)view.findViewById(R.id.pestation);
        final EditText vovno1= (EditText)view.findViewById(R.id.vov);
        final EditText estation1= (EditText)view.findViewById(R.id.estation);
        final EditText duration1= (EditText)view.findViewById(R.id.period);
        final EditText cclass1= (EditText)view.findViewById(R.id.cclass);
        final EditText sdate1= (EditText)view.findViewById(R.id.sdate);
        final EditText smonth1= (EditText)view.findViewById(R.id.smonth);
        final EditText syear1= (EditText)view.findViewById(R.id.syear);
        final EditText edate1= (EditText)view.findViewById(R.id.edate);
        final EditText emonth1= (EditText)view.findViewById(R.id.emonth);
        final EditText eyear1= (EditText)view.findViewById(R.id.eyear);
        final Button bsubmit=(Button)view.findViewById(R.id.btnSubmit);

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

                                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                                    fragmentTransaction.replace(R.id.containerView,new Profile()).commit();
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
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

            RailwayRequest formRequest=new RailwayRequest(id,starting_station,DOB,ticket,pclass,pestation,vovno,estation,period,cclass,sdate,smonth,syear,edate,emonth,
                    eyear,responseListener);
            RequestQueue queue= Volley.newRequestQueue(getActivity());
            queue.add(formRequest);

            }
         });

        return view;

    }
}
