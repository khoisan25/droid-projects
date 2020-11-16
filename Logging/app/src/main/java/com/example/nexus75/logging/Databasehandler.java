package com.example.nexus75.logging;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NEXUS75 on 3/31/2016.
 */
public class Databasehandler extends SQLiteOpenHelper {
    private static final String dbname="NexusUsers";
    private static final int dbversion=1;
    private static final String table="users";
    private static final String key_username="username";
    private static final String key_password="password";
    private static final String key_id="id";

    public Databasehandler(Context context){
        super(context,dbname,null,dbversion);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String create_table="CREATE TABLE "+table+"("+key_id+" INTEGER PRIMARY KEY,"+key_username+
                " TEXT NOT NULL,"+key_password+" TEXT NOT NULL"+")";
        db.execSQL(create_table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldversion,int newversion){
        db.execSQL("DROP IF EXIST "+ table);
        onCreate(db);
    }
    void adduser(String username,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_username,username);
        values.put(key_password,pass);
        db.insert(table, null, values);
        db.close();
    }
    String searchuser(String username,String pass){
        String allow;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.query(table, new String[]{key_id,key_username,key_password},key_username+"=? AND "+key_password+ "=?",
                new String[]{String.valueOf(username),String.valueOf(pass)}, null, null, null, null);
        if(cursor.moveToFirst()){
          allow="okay";
        }else {
            allow="no";}
        return allow;

    }

}
