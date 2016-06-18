package com.hanbit.user.myapp.Group;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016-06-18.
 */
public class GroupDBHelper extends SQLiteOpenHelper {
    public GroupDBHelper(Context context) {
        super(context, "hanbitDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table Group (_id INTEGER PRIMARY KEY,name TEXT,age INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists Group");
        onCreate(db);
    }
}
