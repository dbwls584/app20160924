package com.abc.my.app160924.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.my.app160924.R;
import com.abc.my.app160924.util.Phone;


public class MemberDetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService servive;
    TextView tv_id,tv_pw,tv_name,tv_email,tv_addr,tv_phone;
    Button bt_call,bt_list,bt_update,bt_map;
    MemberDTO member; //필드에있는 것은 초기화하지않는다. MemberDTO member = new MemberDTO(); 이렇게하면 자바의 하이얼러키를 어기는거라서..안된다. 메소드안에는된다. 아래의 메소드..!
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        servive = new MemberSeriviceImpl(this.getApplicationContext());
        phone = new Phone(this,this); //phone이 엑티비티에 접근가능해진다.
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id"); //스트링으로
        member = new MemberDTO();
        member.setId(id);
        member = servive.getOne(member); //객체를 생성하는 일종의 방식인데 2번 방식이다.
        // member = new MemberDTO(); //>이거는 1번 생성자 방식.
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        tv_phone = (TextView) findViewById(R.id.tv_phone);

        tv_id.setText(member.getId());
        tv_pw.setText(member.getPw());
        tv_name.setText(member.getName());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());
        tv_phone.setText(member.getPhone()); // 계산기 calc처럼 클릭할때마다가아니라 연결하자마자 바로 값을 보여줘야하기때문에 set으로.

        bt_call = (Button) findViewById(R.id.bt_call);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_map = (Button) findViewById(R.id.bt_map);

        bt_map.setOnClickListener(this);
        bt_call.setOnClickListener(this);
        bt_list.setOnClickListener(this);
        bt_update.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_call:
                phone.dial(member.getPhone());
                //phone.directCall(member.getPhone());
                break;
            case R.id.bt_map:
                break;
            case R.id.bt_list:
                //startActivity(new Intent(MemberDetailActivity.this,ListActivity.class));
                startActivity(new Intent(this,ListActivity.class));
                break;
            case R.id.bt_update:
                Intent intent = new Intent(MemberDetailActivity.this,MemberUpdateActivity.class);
                intent.putExtra("id",member.getId()); //눌렀을때 기존의값을 잘라버리고 홍길동선택 또 다른거누르면 또 잘라버리고 다른거 선택.
                startActivity(intent); // 자바에서 클래스 내부의 값은 선언된 객체의 인스턴스로하고 외부는? 스트링으로 처리한다.
                break;
        }
    }
}
