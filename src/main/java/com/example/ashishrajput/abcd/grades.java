package com.example.ashishrajput.abcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;

public class grades extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message1";

        String p="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(), "done1", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
        Intent kk = getIntent();
        String messageText = kk.getStringExtra(EXTRA_MESSAGE);

        try {
            String  p = rqst();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String rqst() throws JSONException {


        Toast.makeText(getApplicationContext(), "doneask", Toast.LENGTH_LONG).show();
        StringRequest stringRequest = new StringRequest("http://192.168.0.109:8000/courses/list.json",
                new Response.Listener<String>() {
                    // posting the data on the given server
                    @Override
                    public void onResponse(String response) throws JSONException {
                        EditText p0 = (EditText) findViewById(R.id.user);
                        // p0.setText("ashish");
                        Toast.makeText(getApplicationContext(), "done23", Toast.LENGTH_LONG).show();
                        JSONObject jsonObject= null;

                        jsonObject = new JSONObject(response);



                        Toast.makeText(getApplicationContext(), "done221", Toast.LENGTH_LONG).show();
                        JSONArray cors = null;//jsonObject.getJSONArray("courses");
                        JSONArray grd = null;//jsonObject.getJSONArray("grades");
                        Toast.makeText(getApplicationContext(), "done222", Toast.LENGTH_LONG).show();
                        String str1=jsonObject.getString("current_year");
                        Toast.makeText(getApplicationContext(), "done223", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_LONG).show();
                        String[] course = null;
                        String[] grade_item = null;
                        String[] score = null;
                        String[] absolute_marks = null;
                        String[] weight = null;
                        for (int i=0 ; i< cors.length() ; i++  ){
                            course[i] =cors.getJSONObject(i).getString("code");
                            grade_item[i] =grd.getJSONObject(i).getString("name");
                            score[i] =grd.getJSONObject(i).getString("score")+"/"+grd.getJSONObject(i).getString("out_of");
                            //absolute_marks[i] =grd.getJSONObject(i).getString("score");
                            weight[i] =grd.getJSONObject(i).getString("weightage");

                        }
                        Toast.makeText(getApplicationContext(), "done56", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), course[1], Toast.LENGTH_LONG).show();

                   /* JSONArray users = null;
                    users = jsonObject.getJSONArray("user");*/
                      /*  if (jsonObject.getString("success").compareTo("true") == 0) {

                            Intent k;
                            k = new Intent(getApplicationContext(), Main22Activity.class);
                            k.putExtra(Main22Activity.EXTRA_MESSAGE,"ashish");
                            startActivity(k);
                        }
                        Toast.makeText(getApplicationContext(), jsonObject.getString("success"), Toast.LENGTH_LONG).show();*/

                    }
                },     // Response is taken from the server
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "No Connectivity or the server is down", Toast.LENGTH_LONG).show();
                        p= "xyzdexd";
                    }  // for error in response or connectivity  issues
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        //Intent k = new Intent(this, Main2Activity.class);
        //k.putExtra(Main2Activity.EXTRA_MESSAGE,p);
        //startActivity(k);
        return p;
    }
}
