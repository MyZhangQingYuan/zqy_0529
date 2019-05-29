package com.example.msi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class zhuye extends Activity implements View.OnClickListener{

    //引入工具类
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuye);
        Button save_data = (Button)findViewById(R.id.save_data);
        save_data.setOnClickListener(this);
        Button get_data = (Button)findViewById(R.id.get_data);
        get_data.setOnClickListener(this);
        Button goto_login = (Button)findViewById(R.id.goto_login);
        goto_login.setOnClickListener(this);
        Button create_database = (Button)findViewById(R.id.create_database);
        create_database.setOnClickListener(this);
        Button add_shu = (Button)findViewById(R.id.add_shu);
        add_shu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_shu:
                Intent k = new Intent(zhuye.this,OptionsDatabase.class);
                startActivity(k);
                break;

            case R.id.delete_shu:
                Intent a = new Intent(zhuye.this,delete.class);
                startActivity(a);
                break;
            case R.id.book:
                Intent b = new Intent(zhuye.this,book.class);
                startActivity(b);
                break;


            case R.id.create_database:
                //指定需要创建的数据库
                dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,3);
                //进行建库操作
                dbHelper.getWritableDatabase();
                break;
            case R.id.goto_login:
                Intent i = new Intent(zhuye.this,index.class);
                startActivity(i);
                break;
            case R.id.get_data:
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age",1);
                String job = pref.getString("job","");
                boolean married = pref.getBoolean("married",false);
                Toast.makeText(zhuye.this,name + "的年龄是：" +
                        age + ",职业是：" + job + "," +
                        "是否结婚：" + married,Toast.LENGTH_LONG).show();
                break;
            case R.id.save_data:
                //使用键值对存储数据
                SharedPreferences.Editor editor =
                        getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","帅哥");
                editor.putInt("age",23);
                editor.putString("job","全能");
                editor.putBoolean("married",false);
                //实现存储
                editor.apply();
                Toast.makeText(zhuye.this,"数据设置成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
