package com.shivaneeshindegmail.orc;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 07/06/2016.
 */
public class RailwayRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL ="http://vjtiorc.freeiz.com/acrconnection.php";
    private Map<String,String> params;

    public RailwayRequest(int id, String starting_station , String DOB, String ticket, String pclass, String pestation, String vovno, String estation, String period,
                          String cclass, int sdate, int smonth, int syear, int edate, int emonth, int eyear,
                           Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("id",id + "");
        params.put("DOB",DOB);
        params.put("starting_station",starting_station);
        params.put("ticket",ticket);
        params.put("pclass",pclass);
        params.put("pestation",pestation);
        params.put("vovno",vovno);
        params.put("estation",estation);
        params.put("period",period);
        params.put("cclass",cclass);
        params.put("sdate",sdate + "");
        params.put("smonth",smonth + "");
        params.put("syear",syear + "");
        params.put("edate",edate + "");
        params.put("emonth",emonth + "");
        params.put("eyear",eyear + "");
    }
    public Map<String,String> getParams(){
        return params;
    }
}
