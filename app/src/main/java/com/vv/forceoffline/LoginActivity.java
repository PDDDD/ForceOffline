package com.vv.forceoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText userNameEdit;
    private EditText pwdEdit;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEdit = (EditText) findViewById(R.id.et_username);
        pwdEdit = (EditText) findViewById(R.id.et_pwd);
        loginButton = (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEdit.getText().toString();
                String pwd = pwdEdit.getText().toString();
                if (userName.equals("admin") && pwd.equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this, FirstActivity.class);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    userNameEdit.setText("");
                    pwdEdit.setText("");
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
