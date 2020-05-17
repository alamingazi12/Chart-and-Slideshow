package com.gktech.barchartmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.crypto.AEADBadTagException;

public class RecyclerData extends AppCompatActivity {

    ArrayList<Employee> employees=new ArrayList<>();

    RequestQueue mrequestQueue;
    public static  String url="https://unworried-angle.000webhostapp.com/practise.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_data);
        mrequestQueue= Volley.newRequestQueue(this);
        jSonParsing();
    }


    private void jSonParsing() {
        //Toast.makeText(getActivity(),"json parsing calling",Toast.LENGTH_LONG).show();
        employees.clear();

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(RecyclerData.this,"No Data found"+employees.size(),Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray=response.getJSONArray("result");

                    for(int i=0;i<jsonArray.length();i++){

                        JSONObject hit=jsonArray.getJSONObject(i);
                        String cid= hit.getString("cid");

                       //String name= new String(hit.getString("name").getBytes("ISO-8859-1"), "UTF-8");
                        String name= hit.getString("name");
                        Log.d("name",name);
                        employees.add(new Employee(cid,name));

                    }

                    if(employees.size()>0){

                        Toast.makeText(RecyclerData.this,"No Data found"+employees.get(7).getName(),Toast.LENGTH_LONG).show();
                    }else {

                        //Toast.makeText(getActivity(),"No Data found"+projects.size(),Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("message",e.getMessage());
                    Toast.makeText(RecyclerData.this,"message"+e.getMessage().toString(),Toast.LENGTH_LONG).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  Toast.makeText(RecyclerData.this,"wrong"+error.getMessage(),Toast.LENGTH_LONG).show();
//            Log.e("error",error.getMessage());
            }
        });
        mrequestQueue.add(jsonObjectRequest);
    }

}
