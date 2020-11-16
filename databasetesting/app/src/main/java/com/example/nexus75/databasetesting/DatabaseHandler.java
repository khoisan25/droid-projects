package com.example.nexus75.databasetesting;

/**
 * Created by NEXUS75 on 3/8/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Productz";
    private static final String TABLE_PRODUCT = "product";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BARCODE = "bar_code";
    private static final String KEY_PRICE = "price";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT NOT NULL,"
                + KEY_BARCODE + " TEXT NOT NULL," + KEY_PRICE + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
// Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName()); // product Name
        values.put(KEY_BARCODE, product.getBarcode()); // product barcode
        values.put(KEY_PRICE, product.getPrice());
        // Inserting Row
        db.insert(TABLE_PRODUCT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCT, new String[]{KEY_ID,
                        KEY_NAME, KEY_BARCODE, KEY_PRICE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return product;
    }

    Product search(String barcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Product prodct = new Product();
        String productlookup = "Select * FROM " + TABLE_PRODUCT + " WHERE " + KEY_BARCODE + " = \"" + barcode + "\"";
        /*Cursor cursor=db.query(TABLE_PRODUCT,new String[]{KEY_ID,KEY_NAME,KEY_BARCODE,KEY_PRICE},KEY_BARCODE+"=?",
                new String[]{String.valueOf(barcode)},null,null,null,null);*/
        Cursor cursor = db.rawQuery(productlookup, null);
        if (cursor.moveToFirst()) {
            //cursor.moveToFirst();
            Product product = new Product(cursor.getString(1), cursor.getString(3), cursor.getString(2));
            prodct = product;
        } else {
            Product pro = new Product();
            pro = prodct;
        }


        return prodct;
    }

    // code to get all products in a list view
    public List<Product> getAllproducts() {
        List<Product> productList = new ArrayList<Product>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setID(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setBarcode(cursor.getString(2));
                product.setPrice(cursor.getString(3));
                // Adding product to list
                productList.add(product);
            } while (cursor.moveToNext());
        }

// return contact list
        return productList;
    }

    //code to update the single product
    public int updateproduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_BARCODE, product.getBarcode());
        values.put(KEY_PRICE, product.getPrice());

        // updating row
        return db.update(TABLE_PRODUCT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(product.getID())});
    }

    // Deleting single product
    public void deleteProduct(Product product1) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCT, KEY_ID + " = ?",
                new String[]{String.valueOf(product1.getID())});
        db.close();
    }

    // Getting product Count
    public int getProductCount() {
        String countQuery = "SELECT * FROM " + TABLE_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
