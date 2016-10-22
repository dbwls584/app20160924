package com.abc.my.app160924.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abc.my.app160924.R;

public class MemberUpdateActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService servive;
    TextView tv_id,tv_name;
    EditText et_pw,et_email,et_addr,et_phone;
    Button bt_submit,bt_cancel;
    MemberDTO member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_update);
        servive = new MemberSeriviceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id"); //스트링으로
        member = new MemberDTO();
        member.setId(id);
        member = servive.getOne(member);

        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id.setText(member.getId());
        tv_name.setText(member.getName());

        et_pw = (EditText) findViewById(R.id.et_pw);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pw.setHint(member.getPw());
        et_email.setHint(member.getEmail());
        et_addr.setHint(member.getAddr());
        et_phone.setHint(member.getPhone());

        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel.setOnClickListener(this);
        bt_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cancel:
                Intent intent2 = new Intent(MemberUpdateActivity.this,MemberDetailActivity.class);
                intent2.putExtra("id",member.getId()); //눌렀을때 기존의값을 잘라버리고 홍길동선택 또 다른거누르면 또 잘라버리고 다른거 선택.
                startActivity(intent2);
                break;
            case R.id.bt_submit:
                MemberDTO param = new MemberDTO();
                param.setId(tv_id.getText().toString());
                param.setName(tv_name.getText().toString());
                param.setPw((et_pw.getText().toString().equals("")) ? member.getPw() : et_pw.getText().toString()); //멤버서비스에있던 값을 넣을래? 아님 있던값을 넣을래.
                param.setEmail((et_email.getText().toString().equals("")) ? member.getEmail() : et_email.getText().toString());
                param.setAddr((et_addr.getText().toString().equals("")) ? member.getAddr() : et_addr.getText().toString());
                param.setPhone((et_phone.getText().toString().equals("")) ? member.getPhone() : et_phone.getText().toString()); //공백은 공백, null은 데이터베이스에서 아무것도없는상태
                /*
                if(et_pw.getText().toString()==""){
                    param.setPw(member.getPw());
                }else{
                    param.setPw(et_pw.getText().toString());
                }
                */
                servive.update(param);
                Intent intent = new Intent(MemberUpdateActivity.this,MemberDetailActivity.class);
                intent.putExtra("id",member.getId()); //눌렀을때 기존의값을 잘라버리고 홍길동선택 또 다른거누르면 또 잘라버리고 다른거 선택.
                startActivity(intent);
                break;
        }

    }
}
