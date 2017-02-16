package com.shivaneeshindegmail.orc;

/**
 * Created by DELL on 15/02/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Profile extends Fragment {

    private Session session;
    FragmentManager mFragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile, container, false);

        session = new Session(getActivity());
        int uid=session.getid();
        String DOB=session.getdob();
        String starting_station=session.getstation();
        mFragmentManager = getActivity().getSupportFragmentManager();

        return view;
    }
}
