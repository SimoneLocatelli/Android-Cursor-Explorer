Android Cursor Explorer
=======================

**Android Cursor Explorer** is library that allow you to show the content from a **Cursor** into a **TableLayout View**.

For example it is useful when you need to read data through ContentResolver and you want to know the table scheme and the record in the table.


Usage
----- 

Your Activity Layout
 
 ```xml
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent" android:id="@+id/activity_main_scrollView_main"
    android:layout_height="match_parent"
    android:scrollbarAlwaysDrawHorizontalTrack="true"
    android:scrollbarAlwaysDrawVerticalTrack="true"
    tools:context=".MainActivity" >

</ScrollView>
```

And here the code to create the TableLayoutView

```java
ScrollView scrollView = (ScrollView) findViewById(R.id.activity_main_scrollView_main);

CursorExplorer cursorExplorer = new CursorExplorer(this);
   
Cursor cursor = getCursor();

scrollView.addView(cursorExplorer.explore(personDataSource.getCursor()));
```

Project structure
----- 

There are two projects in this repository:
 
* CursorExplorer
* CursorExplorerSampleApp

###### H6
