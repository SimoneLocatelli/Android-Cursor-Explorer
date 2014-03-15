Android Cursor Explorer
=======================

**Android Cursor Explorer** is library that allow you to show the content from a **Cursor** into a **TableLayout View**.

For example it is useful when you need to read data through ContentResolver and you want to know the table scheme and the record in the table.


Usage
----- 
	ScrollView scrollView = (ScrollView) findViewById(R.id.activity_main_scrollView_main);

CursorExplorer cursorExplorer = new CursorExplorer(this);

personDataSource.open();

Cursor cursor = personDataSource.getCursor();

if (cursor.getCount() == 0) {
intialize();
}

scrollView
.addView(cursorExplorer.explore(personDataSource.getCursor()));

There are two projects in this repository:
 
1. CursorExplorer
2. CursorExplorerSampleApp
