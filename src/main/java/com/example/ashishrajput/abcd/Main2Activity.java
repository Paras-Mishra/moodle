package com.example.ashishrajput.abcd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.widget.Toast;
import java.io.StringWriter;
import java.net.CookieHandler;
import java.net.CookieManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main2Activity extends AppCompatActivity {
String p=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void submit(View view) throws JSONException{
        EditText user = (EditText) findViewById(R.id.user);
        String user_name = user.getText().toString();
        EditText pswrd = (EditText) findViewById(R.id.pass);
        String pass_word = pswrd.getText().toString();

        //Toast.makeText(getApplicationContext(), user_name, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), pass_word, Toast.LENGTH_LONG).show();
        String url = "http://192.168.0.109:8000/login.json?userid=" + user_name + "&password=" + pass_word + "";
        //String t=    "http://192.168.0.109:8000/login.json?userid=cs1110200&password=john";
        /*if (url.compareTo(t)== 0){
            EditText p1 = (EditText) findViewById(R.id.pass);
            p1.setText("ashish");

        }*/
        // "http://192.168.0.109:8000/login.json?userid=cs1110200&password=john"
        /**/
                /*{

            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("teamname", s0);
                // maping of parameters to be sent to the sever
                // maping is done on the basis of receiving strategy of the server
                params.put("name1", s1);
                params.put("name2", s2);
                params.put("name3", s3);
                params.put("entry1", s4);
                params.put("entry2", s5);
                params.put("entry3", s6);


                return params;
            }


        };*/
      /* int go=0;

        if (go == 0) { // condotion of error found in posting data.
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest); // command for posting the datato the server  or called the making of request to the server
        }*/

        //Rqst k1 = new Rqst();
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        String p = rqst(url);

        //Toast.makeText(getApplicationContext(), p, Toast.LENGTH_LONG).show();

    }



   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    public String rqst(String url) throws JSONException {


        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    // posting the data on the given server
                    @Override
                    public void onResponse(String response) throws JSONException {
                        EditText p0 = (EditText) findViewById(R.id.user);
                       // p0.setText("ashish");

                        JSONObject jsonObject= null;

                            jsonObject = new JSONObject(response);

                   /* JSONArray users = null;
                    users = jsonObject.getJSONArray("user");*/
            if (jsonObject.getString("success").compareTo("true") == 0) {

                Intent k;
                k = new Intent(getApplicationContext(), Main22Activity.class);
                k.putExtra(Main22Activity.EXTRA_MESSAGE,"ashish");
                startActivity(k);
            }
                        Toast.makeText(getApplicationContext(), jsonObject.getString("success"), Toast.LENGTH_LONG).show();

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



