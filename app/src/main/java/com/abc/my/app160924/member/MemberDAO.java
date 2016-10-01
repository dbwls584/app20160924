package com.abc.my.app160924.member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO {
    public MemberDTO select(MemberDTO param){
        Log.i("*** DAO 에서 받은 ID값 :",param.getId());
        Log.i("*** DAO 에서 받은 PW값 :",param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("hong"); //set을주면 null이 되지않는다.
        member.setPw("1");
        member.setName("홍길동");
        return member;
    }
    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
}
