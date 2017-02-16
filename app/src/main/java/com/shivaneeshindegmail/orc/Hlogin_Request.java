package com.shivaneeshindegmail.orc;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by DELL on 29/06/2016.
 */
public class Hlogin_Request extends StringRequest{

    private static final String LOGIN_REQUEST_URL ="http://tradersdiary.comxa.com/andro/anewFirstpage.php";
    private Map<String,String> params;

    public Hlogin_Request(int id,String email,Response.Listener<String>listener){
        super(Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("uname",id + "");
        params.put("upassword",email);
    }
    public Map<String,String> getParams(){
        return params;
    }


}
