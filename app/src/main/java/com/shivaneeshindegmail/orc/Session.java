package com.shivaneeshindegmail.orc;

/**
 * Created by DELL on 15/02/2017.
 */
import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public static final String Uid = "id";
    public static final String Dob = "dob";
    public static final String Station = "station";

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin){
        editor.putBoolean("loggedInmode",logggedin);
        editor.commit();
    }

    public void setId(int id){
        editor.putInt(Uid,id);
        editor.commit();
    }

    public void setdob(String dob){
        editor.putString(Dob,dob);
        editor.commit();
    }

    public void setstation(String station){
        editor.putString(Station,station);
        editor.commit();
    }

    public void clearid(){
        editor.remove(Uid);
        editor.clear();
        editor.commit();
    }

    public void cleardob(){
        editor.remove(Dob);
        editor.clear();
        editor.commit();
    }

    public void clearstation(){
        editor.remove(Station);
        editor.clear();
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode", false);
    }

    public int getid(){
        return prefs.getInt(Uid,0);
    }

    public String getdob(){
        return prefs.getString(Dob,null);
    }

    public String getstation(){
        return prefs.getString(Station,null);
    }
}