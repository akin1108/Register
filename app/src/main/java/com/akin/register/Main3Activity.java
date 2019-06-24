package com.akin.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button loginbtn;
    EditText edituname,editpwd;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = new DatabaseHelper(this);
        edituname = (EditText)findViewById(R.id.editText);
        editpwd= (EditText)findViewById(R.id.editText3);
        loginbtn = (Button)findViewById(R.id.button4);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Boolean bool;
           String name = edituname.getText().toString();
           String pwd = editpwd.getText().toString();
           if(name.isEmpty() && pwd.isEmpty()){
               Toast.makeText(Main3Activity.this,"Please fill all Details",Toast.LENGTH_SHORT).show();
           }
           else{
           bool = db.logincheck(name,pwd);
           if(bool==true){
               Intent intent= new Intent(Main3Activity.this,Main4Activity.class);
               startActivity(intent);
           }
           else{
               Toast.makeText(Main3Activity.this,"Please check the values",Toast.LENGTH_SHORT).show();
                }}
            }
        });
    }

}
