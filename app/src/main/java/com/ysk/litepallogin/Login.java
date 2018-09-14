package com.ysk.litepallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText et_user,et_password;
    private ImageButton login,registe;
    private List<Person> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login= (ImageButton) findViewById(R.id.denglu);
        registe= (ImageButton) findViewById(R.id.zhuce);
        et_user= (EditText) findViewById(R.id.zhanghao);
        et_password= (EditText) findViewById(R.id.mima);
        login.setOnClickListener(this);
        registe.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        String user=et_user.getText().toString();
        String password=et_password.getText().toString();
        switch (v.getId())
        {
            case R.id.zhuce:
                Intent intent=new Intent(Login.this,Registe.class);
                startActivity(intent);
                break;
            case R.id.denglu:
                list= DataSupport.findAll(Person.class);
                Iterator<Person> it=list.iterator();
                for (Person p:list)//遍历数据库中的注册信息
                {
                    if(p.getName().equals(user)&&p.getPassword().equals(password)) {
                        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(Login.this,MainActivity.class);
                        startActivity(intent1);
                        break;
                    } else {
                        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            default:
                break;
        }
    }

}
