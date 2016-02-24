package com.example.ashishrajput.abcd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
public class Main22Activity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent kk = getIntent();
        String messageText = kk.getStringExtra(EXTRA_MESSAGE);
        // TextView messageView = (TextView)findViewById(R.id.textView4);
        // messageView.setText(messageText);
        //EditText m1 = (EditText)findViewById(R.id.e3);
        //m1.setText(messageText);
         String[] mobileArray = {"OverView", "Grades", "Notification", "my courses"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.act, mobileArray);


        listView = (ListView) findViewById(R.id.l1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position ,long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "abcdsjh", Toast.LENGTH_LONG).show();
                        Intent k1;
                        k1 = new Intent(Main22Activity.this, grades.class);
                        //k1.putExtra(grades.EXTRA_MESSAGE,"ashish");
                        startActivity(k1);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "abcasjkjdsjh", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "abcdsjajshkjh", Toast.LENGTH_LONG).show();
                        break;
                    //add more if you have more items in listview
                    //0 is the first item 1 second and so on...
                }
                // startActivity(intent);
            }

        });
    }

    public void pqr(){
        String[] mobileArray = {"Grades", "Notification","OverView",  "courses", "WebOS", "Ubuntu", "Windows7", "Max OS X"};
        //ListView listView1 = (ListView) findViewById(R.id.l2);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.act1, mobileArray);
        listView.setAdapter(adapter);
    }
}
