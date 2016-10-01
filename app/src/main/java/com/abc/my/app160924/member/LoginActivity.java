package com.abc.my.app160924.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.my.app160924.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login, bt_join;
    EditText et_id, et_pw;

    MemberService service = new MemberSeriviceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login = (Button) findViewById(R.id.bt_login);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);

        bt_join.setOnClickListener(this);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id = et_id.getText().toString(),
                pw = et_pw.getText().toString();
        MemberDTO member = new MemberDTO();
        switch (v.getId()){
            case R.id.bt_login :
             /*
                Toast.makeText(LoginActivity.this
                               ,"ID :"+id+", PASS : "+pw
                               ,Toast.LENGTH_SHORT).show();
                        */
                member.setId(id);
                member.setPw(pw);
                member = service.login(member);
                if(member.getId().equals("NONE")){
                    Toast.makeText(LoginActivity.this
                            , "존재하지 않는 아이디 입니다.",
                            Toast.LENGTH_SHORT).show();
                }else if(member.getId().equals("NO_MATCH")){
                    Toast.makeText(LoginActivity.this
                            , "비밀번호가 일치하지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this
                            , "환영합니다. "+member.getName()+" 님",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_join :

                break;
        }
    }
}
