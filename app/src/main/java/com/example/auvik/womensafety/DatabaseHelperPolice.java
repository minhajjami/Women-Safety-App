package com.example.auvik.womensafety;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 1/27/2017.
 */

public class DatabaseHelperPolice extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Police_Information.db";
    public static final String TABLE_NAME = "Police_Station";
    public static final String COL_POLICEID = "ID_Police";
    public static final String COL_POLICENAME = "Police_Name";
    public static final String COL_POLICENO = "Police_Phno";
    public static final String COL_POLICELOC = "Police_Location";
    public static final String COL_POLICEGEO = "Police_Geo";

    String CREATE_POLICE_TABLE="CREATE TABLE "+ TABLE_NAME +"("
            + COL_POLICEID +" INTEGER PRIMARY KEY not null,"
            + COL_POLICENAME +" TEXT not null, "
            + COL_POLICENO +" TEXT not null, "
            + COL_POLICELOC +" TEXT not null, "
            + COL_POLICEGEO +" TEXT not null "+")";

    SQLiteDatabase db;
    public DatabaseHelperPolice(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public  String searchpolicename(String uid)
    {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String tableID,thanaName;
        thanaName = " Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                tableID = cursor.getString(cursor.getColumnIndex("ID_Police"));
                if(tableID.equals(uid))
                {
                    thanaName = cursor.getString(cursor.getColumnIndex("Police_Name"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        return thanaName;
    }

    public  String searchpolicecall(String uid)
    {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String tableID,thanaCall;
        thanaCall = " Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                tableID = cursor.getString(cursor.getColumnIndex("ID_Police"));
                if(tableID.equals(uid))
                {
                    thanaCall = cursor.getString(cursor.getColumnIndex("Police_Phno"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        return thanaCall;
    }

    public  String searchpoliceloc(String uid)
    {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String tableID,thanaLoc;
        thanaLoc = " Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                tableID = cursor.getString(cursor.getColumnIndex("ID_Police"));
                if(tableID.equals(uid))
                {
                    thanaLoc = cursor.getString(3);
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        return thanaLoc;
    }

    public  String searchpolicegeo(String uid)
    {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String tableID,thanaGeo;
        thanaGeo = " Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                tableID = cursor.getString(cursor.getColumnIndex("ID_Police"));
                if(tableID.equals(uid))
                {
                    thanaGeo = cursor.getString(4);
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        return thanaGeo;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_POLICE_TABLE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        this.onCreate(db);
    }
}
