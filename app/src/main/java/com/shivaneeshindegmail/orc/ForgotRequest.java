package com.shivaneeshindegmail.orc;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class ForgotRequest  extends StringRequest{
    private static final String REGISTER_REQUEST_URL ="http://vjtiorc.freeiz.com/aforgot.php";
    private Map<String,String> params;

    public ForgotRequest(int id,  String ans, String npass , Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("id",id + "");
        params.put("ans",ans);
        params.put("npass",npass);
    }
    public Map<String,String> getParams(){
        return params;
    }
}
