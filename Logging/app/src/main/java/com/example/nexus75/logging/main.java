package com.example.nexus75.logging;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class main extends ActionBarActivity {
    EditText user,pass;
    Button signin;
    Databasehandler dbhandler=new Databasehandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.editText2password);
        signin=(Button)findViewById(R.id.buttonLog);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(dbhandler.searchuser(user.getText().toString(),pass.getText().toString()).equalsIgnoreCase("okay")){
                  Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_LONG).show();
              }else if(dbhandler.searchuser(user.getText().toString(),pass.getText().toString()).equalsIgnoreCase("no")){
                  Toast.makeText(getApplicationContext(),"your are not a member!!!",Toast.LENGTH_LONG).show();
              }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
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
    }
}
