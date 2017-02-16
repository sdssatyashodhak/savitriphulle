package com.shivaneeshindegmail.orc;

/**
 * Created by DELL on 16/02/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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


public class Newform extends Fragment {

    private Session session;
    FragmentManager mFragmentManager;
    String DOB,starting_station;
    int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.newform, container, false);

        session = new Session(getActivity());
        id=session.getid();
        DOB=session.getdob();
        starting_station=session.getstation();
        mFragmentManager = getActivity().getSupportFragmentManager();


        final EditText estation1= (EditText)view.findViewById(R.id.estation);
        final EditText duration1= (EditText)view.findViewById(R.id.period);
        final EditText cclass1= (EditText)view.findViewById(R.id.cclass);
        final Button bsubmit=(Button)view.findViewById(R.id.btnSubmit);

        bsubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                final String estation=estation1.getText().toString();
                final String period=duration1.getText().toString();
                final String cclass=cclass1.getText().toString();

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

                NewRequest formRequest=new NewRequest(id,starting_station,DOB,estation,period,cclass,responseListener);
                RequestQueue queue= Volley.newRequestQueue(getActivity());
                queue.add(formRequest);

            }
        });

        return view;

    }
}
