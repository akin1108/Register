package com.akin.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button registerbtn;
    EditText editname,editpassword,editpno;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new DatabaseHelper(this);
        editname = (EditText) findViewById(R.id.editText);
        editpassword = (EditText) findViewById(R.id.editText2);
        editpno = (EditText) findViewById(R.id.editText3);
        registerbtn = (Button) findViewById(R.id.button2);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strname = editname.getText().toString();
                String strpassword = editpassword.getText().toString();
                String strpno = editpno.getText().toString();

                if(strname.isEmpty()||strpassword.isEmpty()||strpno.isEmpty()== true){
                    Toast.makeText(Main2Activity.this,"Please Fill All The Mandatory Details",Toast.LENGTH_SHORT).show();
                }

                else {

                   db.insertquery(strname,strpassword,strpno);
                    Toast.makeText(Main2Activity.this,"Congrats !! You have successfully registered",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

    }

