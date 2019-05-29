package com.example.msi;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        Button delete = (Button) findViewById(R.id.delete_shu);
        delete.setOnClickListener(this);

        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(this);


    }

   @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_shu:
                //获取到用户填写信息
                EditText shuming = (EditText) findViewById(R.id.shuming);
                String shumingText = shuming.getText().toString();

                EditText chubanshe = (EditText) findViewById(R.id.chubanshe);
                String chubansheText = chubanshe.getText().toString();

                EditText jiage = (EditText) findViewById(R.id.jiage);
                String jiageText = jiage.getText().toString();

                EditText yema = (EditText) findViewById(R.id.yema);
                String yemaText = yema.getText().toString();

                EditText zuozhe = (EditText) findViewById(R.id.zuozhe);
                String zuozheText = zuozhe.getText().toString();
                MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 4);

                //删除数据库表--shu
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("shu", "pages > ?", new String[]{"500"});
                Toast.makeText(delete.this, "删除成功！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
