package com.shivaneeshindegmail.orc;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 17/02/2017.
 */

public class ProfileRequest extends StringRequest {


    private static final String LOGIN_REQUEST_URL ="http://tradersdiary.comxa.com/andro/aprofile.php";
    private Map<String,String> params;

    public ProfileRequest(int id,Response.Listener<String>listener){
        super(Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("id",id + "");
    }
    public Map<String,String> getParams(){
        return params;
    }



}
