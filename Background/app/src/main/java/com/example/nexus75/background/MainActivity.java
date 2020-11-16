package com.example.nexus75.background;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    ProgressBar bar;
    TextView feed;
    String values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar=(ProgressBar)findViewById(R.id.progressBar1);


    }
    public void startprogress(View view){
        Task task=new Task();
        feed=(TextView)findViewById(R.id.feed);
        bar.setProgress(0);
        feed.setText(String.valueOf(bar.getProgress()));
        new Thread(new Task()).start();
    }
    class Task implements Runnable{
        int valus;
        @Override
        public void run(){

            for (int i=0;i<=100;i++){
                final int value=i;
                valus=i;
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                bar.setProgress(value);

            }
        }
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
