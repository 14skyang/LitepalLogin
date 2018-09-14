package com.ysk.litepallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

public class Registe extends AppCompatActivity {
    private EditText account,password;
    private ImageButton save;
    private String username,userpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        account= (EditText) findViewById(R.id.account);
        password= (EditText) findViewById(R.id.password);
        save= (ImageButton)findViewById(R.id.save);
        Connector.getDatabase();
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Person person=new Person();
                person.setName(account.getText().toString());
                person.setPassword(password.getText().toString());
                person.save();
                Toast.makeText(Registe.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Registe.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
