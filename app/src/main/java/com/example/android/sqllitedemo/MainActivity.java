package com.example.android.sqllitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
        SQLiteDatabase myDataBase = this.openOrCreateDatabase("NotesDB",MODE_PRIVATE,null);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS notes (content VARCHAR, color INT(10))");
        myDataBase.execSQL("INSERT INTO notes (content,color) VALUES ('Hi I am content of this note',662200)");
        Cursor c =myDataBase.rawQuery("SELECT * FROM notes",null);
        c.moveToFirst();
        while(c!=null){
            Log.i("content",c.getString(0));
            Log.i("colorid",String.valueOf(c.getInt(1)));
            c.moveToNext();
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
