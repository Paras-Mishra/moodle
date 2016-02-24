package com.example.ashishrajput.abcd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    String starry[] =  new String[7];
    //array of strings is being created

    public String s0="";
    public String s1="";
    public String s2="";
    public String s3="";
    public String s4="";
    public String s5="";
    public String s6="";

    public EditText v0;
    public EditText v1;
    public EditText v2;
    public EditText v3;
    public EditText v4;
    public EditText v5;
    public EditText v6;




    public void button(View view) {
        //Pressing the submit button will start this process
        v0 = (EditText) findViewById(R.id.e0);
        //the the text from editing coloumns is being retrieved
        v1 = (EditText) findViewById(R.id.e1);
        v2 = (EditText) findViewById(R.id.e2);
        v3 = (EditText) findViewById(R.id.e3);
        v4 = (EditText) findViewById(R.id.e4);
        v5 = (EditText) findViewById(R.id.e5);
        //the the text from editing columns is being retrieved
        v6 = (EditText) findViewById(R.id.e6);
        s0 = v0.getText().toString();
        // text from editing columns is converted into string
        s1 = v1.getText().toString();
        s2 = v2.getText().toString();
        s3 = v3.getText().toString();
        s4 = v4.getText().toString();
        s5 = v5.getText().toString();
        // text from editing columns is converted into string
        s6 = v6.getText().toString();

        starry[1] = s1;
        starry[2] = s3;
        starry[3] = s5;
        // Strings are saved to the array (starry).
        starry[4] = s2;
        starry[5] = s4;
        starry[6] = s6;
        char x; // initiation of a character

        String p = ""; //initiation of a string
        int i = 6; // initiation for a loop
        int ascii = 0; // integer to store ascii value
        int k = 0; // index for the different strings during error analysis of the strings
        int go = 0;// if a error in in the editing field is found then this variable becomes "1" and the process is stopped.

      /*  while ((i != 0) && (go == 0)) {
            p = starry[i];
            // storing a string at index i in " p".
            k = 0;

            if (p.equals("") || p == null) {// condition for null or empty string
                Toast.makeText(getApplicationContext(), "empty field :", Toast.LENGTH_LONG).show();
                go = 1;
            } else {

                if (i == 1 || i == 2 || i == 3) {// condition for checking the names

                    while (k < p.length()) {
                        x = p.charAt(k);
                        ascii = (int) x;

                        p.toLowerCase();

                        x = p.charAt(k);
                        ascii = (int) x;
                        k++;

                        if (((ascii <= 64 || ascii >= 91) && (ascii <= 96 || ascii >= 123)) && (ascii != 32)) { // conditon of name check using ascii values
                            Toast.makeText(getApplicationContext(), "error in name : " + Integer.toString(i), Toast.LENGTH_LONG).show();
                            go = 1;
                        }
                    }
                } else {
                    if (p.length() != 11) {// condition on length of entry no. which is being submited
                        Toast.makeText(getApplicationContext(), "error in entry no : " + Integer.toString(i - 3), Toast.LENGTH_LONG).show();
                        go = 1;
                    } else {

                        while (k < p.length()) {// condition on alphabets in entry no.
                            if (k < 4 || k > 5) {

                                x = p.charAt(k);

                                ascii = (int) x;

                                if (ascii <= 47 || ascii >= 58) {// condition on numerically expected digits on different indexs
                                    Toast.makeText(getApplicationContext(), "error in entry no : " + Integer.toString(i - 3), Toast.LENGTH_LONG).show();
                                    go = 1;
                                } else {
                                    p.toUpperCase();
                                    x = p.charAt(k);
                                    ascii = (int) x;


                                }
                            } else if (k == 4 || k == 5) {
                                x = p.charAt(k);
                                ascii = (int) x;

                                if ((ascii <= 64 || ascii >= 91) && (ascii <= 96 || ascii >= 123)) {
                                    Toast.makeText(getApplicationContext(), "error in entry no  : " + Integer.toString(i - 3), Toast.LENGTH_LONG).show();
                                    go = 1;
                                }

                            }
                            k++;
                        }
                    }
                }

            }
            ;
            i = i - 1;
        }*/


        StringRequest stringRequest = new StringRequest("http://192.168.0.109:8000/login.json?userid=cs1110200&password=john",
                new Response.Listener<String>() {
                // posting the data on the given server
                    @Override
                    public void onResponse(String response) {
                         EditText p0 = (EditText) findViewById(R.id.e1);
                        p0.setText("ashish");
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                    }
                },     // Response is taken from the server
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "No Connectivity or the server is down", Toast.LENGTH_LONG).show();
                    }  // for error in response or connectivity  issues
                });/*{

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
        go=0;

        if (go == 0) { // condotion of error found in posting data.
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest); // command for posting the datato the server  or called the making of request to the server
        }

    }
    public void clear(View view){

       EditText t0 = (EditText) findViewById(R.id.e0);
        EditText t1 = (EditText) findViewById(R.id.e1);
        EditText t2 = (EditText) findViewById(R.id.e2);
        EditText t3 = (EditText) findViewById(R.id.e3);
        EditText t4 = (EditText) findViewById(R.id.e4);
        EditText t5 = (EditText) findViewById(R.id.e5);
        EditText t6 = (EditText) findViewById(R.id.e6);

        t0.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        Toast.makeText(getApplicationContext(), " text cleared", Toast.LENGTH_LONG).show();
    }
    }

