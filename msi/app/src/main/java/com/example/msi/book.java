package com.example.msi;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class book extends Activity {
    private MyDatabaseHelper dbHelper;
    List<book>bookList;

    public book(int id, String book_name, String press, double price, int pages, String writer) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 4);
        ArrayList book = new ArrayList<book>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("book",null,null,null,null,null,null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String book_name = c.getString(c.getColumnIndex("book_name"));
            String press = c.getString(c.getColumnIndex("press"));
            double price = c.getDouble(c.getColumnIndex("price"));
            int pages = c.getInt(c.getColumnIndex("pages"));
            String writer = c.getString(c.getColumnIndex("writer"));
            book be = new book(id, book_name, press, price, pages, writer) {
            };
            book.add(be);
        }
        Button ll = findViewById(R.id.book);

        for (book u :bookList){

            TextView tv = new TextView(this);

            tv.setText(u.toString());
            tv.setTextSize(18);
            ll.getViewTreeObserver();
        }
    }

}
