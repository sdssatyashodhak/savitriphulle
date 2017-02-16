package com.shivaneeshindegmail.orc;


import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL on 15/02/2017.
 */

public class Logout extends Fragment {
    private Session session;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout, container, false);

        session = new Session(getActivity());
        if(!session.loggedin()){
            logout();
        }

        logout();

        return view;
    }

    private void logout(){
        session.setLoggedin(false);
        session.clearid();
        session.cleardob();
        session.clearstation();
        getActivity().finish();
        startActivity(new Intent(getActivity(),Login.class));
    }

}
