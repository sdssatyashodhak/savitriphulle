package com.shivaneeshindegmail.orc;

/**
 * Created by DELL on 16/02/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class NewRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL ="http://tradersdiary.comxa.com/andro/anewpass.php";
    private Map<String,String> params;

    public NewRequest(int id, String starting_station , String DOB, String estation, String period,
                           String cclass, Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("id",id + "");
        params.put("DOB",DOB);
        params.put("starting_station",starting_station);
        params.put("estation",estation);
        params.put("period",period);
        params.put("cclass",cclass);
    }
    public Map<String,String> getParams(){
        return params;
    }
}
