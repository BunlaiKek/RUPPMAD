package kh.edu.rupp.fe.ruppmad.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;

/**
 * Created by Kek Bunlai on 08-May-17.
 */

public class DBManager extends SQLiteOpenHelper{
    public DBManager( Context context)
    {
        super(context,"ruppassigment.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tblAssignmentSql = "create table tblAssignment(_id integer primary key autoincrement,_img_thumnail_url text,_title text,_deadline text)";
        db.execSQL(tblAssignmentSql);
        Log.d("Bunlai","DB is created");

        // Insert Manual Data to Db
        Assignment a1 = new Assignment("OOAD","",getDate());
        insertAssignment(a1,db);
        Assignment a2 = new Assignment("MAD","",getDate());
        insertAssignment(a2,db);
        Assignment a3 = new Assignment("Computer Graphic","",getDate());
        insertAssignment(a3,db);
        Assignment a4 = new Assignment("Network Engineering","",getDate());
        insertAssignment(a4,db);
        Assignment a5 = new Assignment("Web Technology","",getDate());
        insertAssignment(a5,db);
        Assignment a6 = new Assignment("English","",getDate());
        insertAssignment(a6,db);
        Assignment a7 = new Assignment("Practicum","",getDate());
        insertAssignment(a7,db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private String getDate()
    {
        long time = System.currentTimeMillis();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(time);
        return dateFormat.format(date);
    }
    public boolean insertAssignment(Assignment assignment, SQLiteDatabase database)
    {
        ContentValues row = new ContentValues();
        row.put("_title",assignment.getTitle());
        row.put("_img_thumnail_url",assignment.getThumnaiUrl());
        row.put("_deadline",assignment.getDeadLine());
        long newId = database.insert("tblAssignment",null,row);
        return (newId > -1);
    }
    public Assignment[] getAllAssignments()
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"_id","_img_thumnail_url","_title","_deadline"};
        Cursor cursor = db.query("tblAssignment",columns,null,null,null,null,"_id");
        Assignment[] assignments = new Assignment[cursor.getCount()];
        int i =0;
        while (cursor.moveToNext())
        {
            String imgUrl = cursor.getString(1);
            Log.d("Bunlai","imgurl");
            String title = cursor.getString(2);
            Log.d("Bunlai",title);
            String deadlline = cursor.getString(3);
            Log.d("Bunlai",deadlline);
            Assignment assignment = new Assignment(title,imgUrl,deadlline);
            assignments[i] = assignment;
            i++;
        }
        return assignments;
    }
}
