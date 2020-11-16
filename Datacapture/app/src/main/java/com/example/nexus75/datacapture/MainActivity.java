package com.example.nexus75.datacapture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    EditText edt1,edt2,edt3,edt4,edt5,edt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText) findViewById(R.id.editTextname);
        edt2=(EditText) findViewById(R.id.editText2surname);
        edt3=(EditText) findViewById(R.id.editText4email);
        edt4=(EditText) findViewById(R.id.editText3phone);
        edt5=(EditText) findViewById(R.id.editText5country);
        edt6=(EditText)findViewById(R.id.editTextOccupation);
        Button button=(Button)findViewById(R.id.buttoncapture);
        final String Name,email,phone,country,occupation;
        Name=edt1.getText().toString()+" "+edt2.getText().toString();
        email=edt3.getText().toString();
        phone=edt4.getText().toString();
        country=edt5.getText().toString();
        occupation=edt6.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Comfirm.class);
                intent.putExtra("name",Name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("country",country);
                intent.putExtra("occupation",occupation);
                setResult(2,intent);
                startActivity(intent);
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
