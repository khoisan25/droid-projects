package com.example.nexus75.datacapture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Comfirm extends ActionBarActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);
        button=(Button) findViewById(R.id.buttonview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Comfirm.this,MainActivity.class);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comfirm, menu);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode ,int resultCode,Intent data){
        if(resultCode==2){
        EditText edt1,edt2,edt3,edt4,edt5;
        edt1=(EditText) findViewById(R.id.editTextname);
        edt2=(EditText) findViewById(R.id.editText4email);
        edt3=(EditText) findViewById(R.id.editText3phone);
        edt4=(EditText)findViewById(R.id.editText5country);
        edt5=(EditText) findViewById(R.id.editTextOccupation);
        String name,email,phone,country,occupation;
        name=data.getStringExtra("name");
        edt1.setText(name);
        email=data.getStringExtra("email");
        edt2.setText(email);
        phone=data.getStringExtra("phone");
        edt3.setText(phone);
        country=data.getStringExtra("country");
        edt4.setText(country);
        occupation=data.getStringExtra("occupation");
        edt5.setText(occupation);}
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
