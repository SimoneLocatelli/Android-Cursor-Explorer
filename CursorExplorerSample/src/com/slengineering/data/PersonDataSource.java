package com.slengineering.data;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PersonDataSource {

	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;

	public PersonDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Cursor getCursor() {

		return database.query("Person", null, null, null, null, null, null);
	}

	public void insert(ArrayList<Person> people) {

		for (Person person : people) {
			ContentValues values = new ContentValues();
			values.put("Name", person.getName());
			values.put("Age", person.getAge());
			values.put("Sex", person.getSex());
			values.put("City", person.getCity());
			database.insert("Person", null, values);
		}

	}

}