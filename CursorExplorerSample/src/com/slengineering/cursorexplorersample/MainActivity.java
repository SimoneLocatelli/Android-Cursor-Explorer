package com.slengineering.cursorexplorersample;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ScrollView;

import com.slengineering.cursorexplorer.CursorExplorer;
import com.slengineering.data.Person;
import com.slengineering.data.PersonDataSource;

public class MainActivity extends Activity {

	// region Properties

	PersonDataSource personDataSource = new PersonDataSource(this);

	// endregion

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ScrollView scrollView = (ScrollView) findViewById(R.id.activity_main_scrollView_main);

		CursorExplorer cursorExplorer = new CursorExplorer(this);

		personDataSource.open();

		Cursor cursor = personDataSource.getCursor();

		if (cursor.getCount() == 0) {
			intialize();
		}

		scrollView
				.addView(cursorExplorer.explore(personDataSource.getCursor()));

		personDataSource.close();
	}

	private void intialize() {
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new Person().setName("Mark").setAge(32).setSex("M")
				.setCity("London"));
		people.add(new Person().setName("John").setAge(24).setSex("M"));
		people.add(new Person().setName("Sarah").setAge(36).setSex("F"));

		personDataSource.insert(people);
	}
}
