package com.example.nexus75.datacapture;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText name,email,number,ip;
    TextView feedback;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.editName);
        email=(EditText)findViewById(R.id.editEmail);
        number=(EditText)findViewById(R.id.editphone);
        ip=(EditText) findViewById(R.id.ip);
        feedback=(TextView)findViewById(R.id.feedback);

    }
    public void send(View v){
        new Send().execute();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    class Send extends AsyncTask<String, Void,Long > {
        protected Long doInBackground(String... urls) {

            /*String Name=name.getText().toString();
            String Email=email.getText().toString();
            String Number=number.getText().toString();*/

            HttpClient httpClient =new DefaultHttpClient();
            String ipadr="http://"+ip.getText().toString()+"/logger/save.php";
            HttpPost post =new HttpPost(ipadr);
            try {
                List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("Name",name.getText().toString()));
                nameValuePairs.add(new BasicNameValuePair("Email",email.getText().toString()));
                nameValuePairs.add(new BasicNameValuePair("Number",number.getText().toString()));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response=httpClient.execute(post);
                HttpEntity feedbac=response.getEntity();
                feedback.setText(feedbac.toString());


            }catch (Exception e){
                e.printStackTrace();
            }
            return null;

        }
        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(Long result) {


        }






    }}
