package com.shivaneeshindegmail.orc;

/**
 * Created by DELL on 15/02/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Profile extends Fragment {

    FragmentManager mFragmentManager;
    private Session session;
    String  name, course, address, contact, email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile, container, false);

        session = new Session(getActivity());
        final int uid=session.getid();
        final String DOB=session.getdob();
        final String starting_station=session.getstation();
        mFragmentManager = getActivity().getSupportFragmentManager();

        final TextView id1=(TextView)view.findViewById(R.id.id);
        final TextView name1=(TextView)view.findViewById(R.id.name);
        final TextView course1=(TextView)view.findViewById(R.id.course);
        final TextView address1=(TextView)view.findViewById(R.id.address);
        final TextView starting_station1=(TextView)view.findViewById(R.id.city);
        final TextView contact1=(TextView)view.findViewById(R.id.contact);
        final TextView dob1=(TextView)view.findViewById(R.id.dob);
        final TextView email1=(TextView)view.findViewById(R.id.email);

// Response received from the server
        Response.Listener<String> responseListener= new Response.Listener<String>(){
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    boolean success= jsonResponse.getBoolean("success");

                    if(success){
                            name=jsonResponse.getString("name");
                            course=jsonResponse.getString("course");
                            address=jsonResponse.getString("address");
                            contact=jsonResponse.getString("contact");
                            email=jsonResponse.getString("email");

                        //set in textview
                        id1.setText(uid+"");
                        name1.setText(name);
                        course1.setText(course);
                        address1.setText(address);
                        starting_station1.setText(starting_station);
                        contact1.setText(contact);
                        dob1.setText(DOB);
                        email1.setText(email);

                    }else {
                        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
                        builder.setMessage("Failed")
                                .setNegativeButton("Retry",null)
                                .create()
                                .show();
                    }

                } catch(JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        ProfileRequest profile_Request=new ProfileRequest(uid,responseListener);
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        queue.add(profile_Request);

        return view;
    }
}
