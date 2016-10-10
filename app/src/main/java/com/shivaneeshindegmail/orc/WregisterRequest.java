package com.shivaneeshindegmail.orc;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class WregisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL ="http://vjtiorc.freeiz.com/awconnectreg.php";
    private Map<String,String> params;

    public WregisterRequest(String fullname, int id, String pass, String course, int date, int month, int year, String add, String gender, String cast, String from, String phon , String email, String ans,
                           Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("id",id + "");
        params.put("fullname",fullname);
        params.put("course",course);
        params.put("year",year + "");
        params.put("month",month + "");
        params.put("date",date + "");
        params.put("add",add);
        params.put("pass",pass);
        params.put("acedemicyear",gender);
        params.put("cast",cast);
        params.put("from",from);
        params.put("phon",phon);
        params.put("email",email);
        params.put("ans",ans);
    }
    public Map<String,String> getParams(){
        return params;
    }
}
