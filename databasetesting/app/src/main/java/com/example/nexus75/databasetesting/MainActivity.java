package com.example.nexus75.databasetesting;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText txtview,name,barcode,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        //Log.d("Insert: ", "Inserting ..");
       // db.addProduct(new Product("Boom", "4.5", "9100000000"));
       // db.addProduct(new Product("CandleBig","4.7", "9199999999"));
        //db.addProduct(new Product("Batteries", "6.5","9522222222"));
        //db.addProduct(new Product("Milk_Bonita","4.9", "9533333333"));


        // Reading all contacts
        //Log.d("Reading: ", "Reading all contacts..");
        //List<Product> product = db.getAllproducts();

        //for (Product prodct : product) {
            //String log = "Id: "+prodct.getID()+" ,Name: " + prodct.getName() + " ,Barcode: " +
            //        prodct.getBarcode()+" ,Price: "+prodct.getPrice();
            // Writing Contacts to log
            //Log.d("Name: ", log);
           // txtview.setText(log);
       // }
    }
    public  void storeData(View view){
        name=(EditText)findViewById(R.id.editTextprodct);
        barcode=(EditText)findViewById(R.id.editTextBarcode);
        price=(EditText)findViewById(R.id.editTextprice);
        String name1,price1,barcode1;
        name1=name.getText().toString();
        price1=price.getText().toString();
        barcode1=barcode.getText().toString();
        DatabaseHandler db=new DatabaseHandler(this);
        db.addProduct(new Product(name1,price1,barcode1));

    }
    public void SearchData(View view){
        barcode=(EditText)findViewById(R.id.editTextBarcode);
        String barcode2=barcode.getText().toString();
        DatabaseHandler db= new DatabaseHandler(this);
        Product product=db.search(barcode2);

        String product_price,product_name;
        product_name=product.getName();
        product_price=product.getPrice();
        if(product_price!=null&&product_name!=null){
            Toast.makeText(getApplicationContext(),"Product Exist!! price is K"+product_price,Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(getApplicationContext(),"No such product", Toast.LENGTH_LONG).show();
    }
    public void readData(View view){
        txtview=(EditText)findViewById(R.id.editText);
        DatabaseHandler db=new DatabaseHandler(this);
        Log.d("Reading: ", "Reading all contacts..");
        List<Product> product = db.getAllproducts();

        for (Product prodct : product) {
            String log = "Id: "+prodct.getID()+" ,Name: " + prodct.getName() + " ,Barcode: " +
                    prodct.getBarcode()+" ,Price: "+prodct.getPrice();
            // Writing Contacts to log
            Log.d("Name: ", log);
            txtview.setText(log);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}