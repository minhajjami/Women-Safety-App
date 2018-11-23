package com.example.auvik.womensafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2/3/2017.
 */

public class DatabaseHelperUser extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="User.db";
    private static final String TABLE_NAME="User";
    private static final String COLUMN_ID="Id";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PASS="pass";
    private static final String COLUMN_MOB="mobileno";
    private static final String COLUMN_EMMOB="emergencymob";
    private static final String COLUMN_MESSAGE="message";
    private static final String COLUMN_BIRTH="birthdate";

    String CREATE_USER_TABLE="CREATE TABLE "+ TABLE_NAME +"("
            + COLUMN_ID +" INTEGER PRIMARY KEY not null,"
            + COLUMN_USERNAME +" TEXT not null, "
            + COLUMN_EMAIL +" TEXT not null, "
            + COLUMN_PASS +" TEXT not null, "
            + COLUMN_MOB +" TEXT not null, "
            + COLUMN_EMMOB +" TEXT not null, "
            + COLUMN_MESSAGE +" TEXT not null, "
            + COLUMN_BIRTH +" TEXT not null "+")";
    SQLiteDatabase db;
    public DatabaseHelperUser(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void insertUser(User c){

        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from User";
        Cursor cursor=db.rawQuery(query,null);
        int count =cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPassword());
        values.put(COLUMN_MOB, c.getMobileno());
        values.put(COLUMN_EMMOB, c.getEmmobileno());
        values.put(COLUMN_MESSAGE, c.getMessage());
        values.put(COLUMN_BIRTH, c.getBirthdate());

        db.insert(TABLE_NAME, null, values);
            db.close();
    }

    String searchPass(String email){
        String password="not found";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,  "email=?",new String[]{email},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(COLUMN_PASS));
            cursor.close();

        }
        return password;
    }

    String searchemergencymob(String email){
        String emergencymob="not found";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,  "email=?",new String[]{email},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            emergencymob = cursor.getString(cursor.getColumnIndex(COLUMN_EMMOB));
            cursor.close();

        }
        return emergencymob;
    }

    String searchmessage(String email){
        String msg="not found";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,  "email=?",new String[]{email},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            msg = cursor.getString(cursor.getColumnIndex(COLUMN_MESSAGE));
            cursor.close();

        }
        return msg;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        this.db=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        this.onCreate(db);
    }

}
