package com.fabvest_inc.ru.instaphiz.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fabvest_inc.ru.instaphiz.TabAdd;

/**
 * Created by fab on 24.02.2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PhizDB.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + InstaPhizContract.PhizCols.TABLE_NAME + "(" +
        "_id integer primary key autoincrement, " +
        InstaPhizContract.PhizCols.COLUMN_NAME_ID + ", " +
        InstaPhizContract.PhizCols.COLUMN_NAME_NAME + ", " +
        InstaPhizContract.PhizCols.COLUMN_NAME_LESSON + ", " +
        InstaPhizContract.PhizCols.COLUMN_MAME_MARK + ", " +
        InstaPhizContract.PhizCols.COLUMN_NAME_PRICE + ", " +
        InstaPhizContract.PhizCols.COLUMN_NAME_KAFEDRA + ", " +
        InstaPhizContract.PhizCols.COLUMN_NAME_SEMESTR + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
