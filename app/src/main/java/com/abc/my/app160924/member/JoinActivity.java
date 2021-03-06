package com.abc.my.app160924.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.my.app160924.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_id,et_pw,et_name,et_email,et_addr,et_phone;
    Button bt_submit, bt_cancel;
    //MemberService service = new MemberSeriviceImpl();
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service  = new MemberSeriviceImpl(this.getApplicationContext()); //메소드를 끊어놔서 공유한다. 위처럼 한번에 선언하는건뎅..응.. this를 막쓸수없어서끊는다.
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_submit = (Button) findViewById(R.id.bt_submit);


        bt_cancel.setOnClickListener(this);
        bt_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        MemberDTO member = new MemberDTO();
        member.setId(et_id.getText().toString());
        member.setPw(et_pw.getText().toString());
        member.setName(et_name.getText().toString());
        member.setEmail(et_email.getText().toString());
        member.setAddr(et_addr.getText().toString());
        member.setPhone(et_phone.getText().toString());
        switch (v.getId()){
            case(R.id.bt_submit) :
                service.regist(member);
                startActivity(new Intent(JoinActivity.this,LoginActivity.class));
                break;
            case(R.id.bt_cancel) :
                startActivity(new Intent(JoinActivity.this,LoginActivity.class));
                break;
        }

    }
}
