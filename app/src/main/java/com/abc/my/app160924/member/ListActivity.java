package com.abc.my.app160924.member;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.abc.my.app160924.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity { //button이없으므로 onclick을 걸지않는다.
    ListView lv_memberlist;
    MemberService service;
    final String[] arr = new String[1]; //id값만 저장하면되므로 한개만잇으면됌. 상수풀에다가 1개만 주면된당.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        service = new MemberSeriviceImpl(this.getApplicationContext()); //context가 같아지니까 service객체를 액티비로 가져올수있다.
        ArrayList<MemberDTO> list = service.getList();//이 list가 아래의 셋 어댑터 list로 들어간다.
        Log.d("서비스에서 불러온 데이터 갯수 : ",String.valueOf(list.size())); //log.d는 스트링값 인식을 못함...그래서 벨류of를 써서 스트링으로 변환.
        lv_memberlist.setAdapter(new MemberAdapter(this,list));//list를 입력받는다.
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                //Object o = lv_memberlist.getItemAtPosition(i);
                //MemberDTO member = (MemberDTO) o;
                MemberDTO member = (MemberDTO) lv_memberlist.getItemAtPosition(i);
                Toast.makeText(ListActivity.this,"선택한 이름"+member.getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this,MemberDetailActivity.class);
                intent.putExtra("id",member.getId()); //눌렀을때 기존의값을 잘라버리고 홍길동선택 또 다른거누르면 또 잘라버리고 다른거 선택.
                startActivity(intent); // 자바에서 클래스 내부의 값은 선언된 객체의 인스턴스로하고 외부는? 스트링으로 처리한다.
            }
        }); //짧게 눌렀을 때.
        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                final MemberDTO member = (MemberDTO) lv_memberlist.getItemAtPosition(i);
                //Toast.makeText(ListActivity.this,"선택한 이름"+member.getName(),
                //        Toast.LENGTH_LONG).show();
                arr[0] = member.getId();
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("삭제 OK?")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            service.unregist(arr[0]); //상수풀 파이널에있었어서 arr[0]라고 바로들어올수있다.
                                startActivity(new Intent(ListActivity.this,ListActivity.class));
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                             }
                         }).show();

                return true;
            }
        }); //길게 눌렀을 때.
    }
}
