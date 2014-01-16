package com.slengineering.cursorexplorer;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CursorExplorer {

	// region Properties

	private Context context;

	// endregion

	// region Constructors

	public CursorExplorer(Context context) {
		this.context = context;
	}

	// endregion

	// region Methods

	public TableLayout explore(Cursor cursor) {

		TableLayout tableLayout = new TableLayout(context);
		tableLayout.setBackgroundResource(R.drawable.shape_table_border);

		tableLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		if (cursor.isClosed()) {
			throw new RuntimeException(
					"The cursor is closed! It have to be open to explore it");
		}

		int count = cursor.getColumnCount();

		{
			TableRow tableRow = new TableRow(context);

			for (int i = 0; i < count; i++) {

				tableRow.addView(createHeaderTextView(cursor.getColumnName(i)));
			}

			tableLayout.addView(tableRow);
		}

		cursor.moveToFirst();

		for (int row = 0; row < cursor.getCount(); row++) {

			TableRow tableRow = new TableRow(context);

			for (int i = 0; i < count; i++) {
				tableRow.addView(createTextView(cursor.getString(i)));
			}

			tableLayout.addView(tableRow);

			cursor.moveToNext();
		}

		for (int i = 0; i < count; i++) {
			tableLayout.setColumnStretchable(i, true);

		}

		return tableLayout;
	}

	private TextView createTextView(String text) {
		TextView textView = new TextView(context);
		textView.setText((text == null) ? "null" : text);
		if (text == null) {
			textView.setTypeface(null, Typeface.ITALIC);
		}
		textView.setGravity(Gravity.CENTER);
		textView.setPadding(10, 10, 10, 10);
		textView.setTextColor(0xFF7f8c8d);
		textView.setBackgroundResource(R.drawable.shape_table_border);

		return textView;
	}

	private TextView createHeaderTextView(String text) {
		TextView textView = createTextView(text);
		textView.setTypeface(null, Typeface.BOLD);
		textView.setTextColor(0xFFecf0f1);
		textView.setPadding(20, 20, 20, 20);
		textView.setTextSize(20);
		textView.setBackgroundResource(R.drawable.shape_table_border_header);

		return textView;
	}
	// endregion

}
