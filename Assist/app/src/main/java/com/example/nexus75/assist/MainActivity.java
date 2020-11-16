package com.example.nexus75.assist;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.sip.SipSession;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Locale;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    EditText tosay;
    Button say;
    TextToSpeech tts;
    MediaPlayer mp;
    TextView customer;
    ImageButton bigsmall,network,donthave,nchange,welcom,wduwant,fhmuch,listen;
    protected static final int RESULT_SPEACH=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tosay=(EditText)findViewById(R.id.output);
        say=(Button)findViewById(R.id.say);
        customer=(TextView)findViewById(R.id.customer);
        bigsmall=(ImageButton) findViewById(R.id.btn_bosmall);
        bigsmall.setOnClickListener(this);
        network=(ImageButton) findViewById(R.id.btn_network);
        network.setOnClickListener(this);
        donthave=(ImageButton) findViewById(R.id.btn_idhave);
        donthave.setOnClickListener(this);
        nchange=(ImageButton) findViewById(R.id.btn_nchange);
        nchange.setOnClickListener(this);
        welcom=(ImageButton) findViewById(R.id.btn_welcome);
        welcom.setOnClickListener(this);
        wduwant=(ImageButton) findViewById(R.id.btn_wduneed);
        wduwant.setOnClickListener(this);
        fhmuch=(ImageButton)findViewById(R.id.btn_fhmuch);
        fhmuch.setOnClickListener(this);
        listen=(ImageButton)findViewById(R.id.btn_listen);
        listen.setOnClickListener(this);
        say.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.castlewalls);
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak(tosay.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                }); }
        });

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_bosmall:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("Do You want Big or Small",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_welcome:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("Welcome, how do i assist you?",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_idhave:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("Am sorry i dont have that product, please check the other Kantembaas",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_nchange:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("Am sorry i dont have change to that note",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_network:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("What network do you want? Airtel.  or M T N or Zamtel",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_wduneed:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("What do you need please?",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_fhmuch:
                tts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            tts.setLanguage(Locale.UK); }
                        try{
                            tts.speak("For How much Please?",TextToSpeech.QUEUE_FLUSH,null);
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                });
                break;
            case R.id.btn_listen:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en_ZW");
                try{
                    startActivityForResult(intent,RESULT_SPEACH);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please Install Voice Search",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                break;

            default:


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEACH:{
                if(resultCode == RESULT_OK && null!=data){
                    ArrayList<String> text=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    customer.setText(text.get(0));
                 }

            }break;
            default:

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
    @Override
    public void onDestroy(){
        mp.stop();
        super.onDestroy();
    }
    @Override
    public void onPause(){
        //mp.pause();
        super.onPause();
    }
    @Override
    public void onResume(){

        super.onResume();
    }


}
