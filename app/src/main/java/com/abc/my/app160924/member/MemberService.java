package com.abc.my.app160924.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    // CREATE
    public void regist(MemberDTO member);
    // READ
    public ArrayList<MemberDTO> getList();
    public ArrayList<MemberDTO> getListByName(MemberDTO member);
    public MemberDTO getOne(MemberDTO member);
    public int count();
    // UPDATE
    public void update(MemberDTO member); //회원수정
    // DELETE
    public void unregist(MemberDTO member); //회원탈퇴
}
