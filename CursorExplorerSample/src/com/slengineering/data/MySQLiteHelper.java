package com.slengineering.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "commments.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String CREATE_PERSON = "create table Person "
			+ "(_id integer primary key autoincrement, "
			+ " Name text not null," + "Age integer," + "Sex text not null,"
			+ " City text null" + ");";

	public MySQLiteHelper(Context context) {
		super(context, MySQLiteHelper.DATABASE_NAME, null,
				MySQLiteHelper.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(MySQLiteHelper.CREATE_PERSON);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

}