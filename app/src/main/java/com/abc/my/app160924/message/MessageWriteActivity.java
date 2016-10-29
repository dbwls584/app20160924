package com.abc.my.app160924.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abc.my.app160924.R;
import com.abc.my.app160924.member.MemberDTO;
import com.abc.my.app160924.member.MemberSeriviceImpl;
import com.abc.my.app160924.member.MemberService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageWriteActivity extends AppCompatActivity implements View.OnClickListener{
    MessageService service;
    MemberDTO member;
    MemberService memberService;

    TextView tv_receiver,tv_id;
    Button bt_send,bt_cancel;
    EditText et_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_write);
        service = new MessageServiceImpl(this.getApplicationContext());
        memberService = new MemberSeriviceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id"); //스트링으로
        member = new MemberDTO();
        member.setId(id);
        member = memberService.getOne(member);

        tv_receiver = (TextView) findViewById(R.id.tv_receiver);
        tv_id = (TextView) findViewById(R.id.tv_id);

        tv_receiver.setText(member.getName());
        tv_id.setVisibility(View.INVISIBLE); //보이지않지만 값은 존재한다.

        et_write = (EditText) findViewById(R.id.et_write);
        bt_send = (Button) findViewById(R.id.bt_send);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_send.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cancel:
                break;
            case R.id.bt_send:
                String content = et_write.getText().toString();
                Log.d("메세지내용 : ",content); //디버그용
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); //JAVA IMPORT 1개
                String sendDate = sdf.format(new Date()); //JAVA IMPORT 1개
                Log.d("보낸 날짜 : ", sendDate); //디버그용
                //String receiver = member.getId(); //이게가능한이유 memberDTO member;를 선언햇기때문
                String receiver = tv_id.getText().toString();
                Log.d("받는 사람 : ",receiver);
                MessageDTO message = new MessageDTO();
                message.setContent(content);
                message.setReceiver(receiver);
                message.setSendDate(sendDate);
                service.write(message);
                break;
        }
    }
}
