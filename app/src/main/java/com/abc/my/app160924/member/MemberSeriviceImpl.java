package com.abc.my.app160924.member;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberSeriviceImpl implements MemberService {

    MemberDAO dao = new MemberDAO();

    @Override
    public MemberDTO login(MemberDTO param) {
        MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if(member == null){
            member.setId("NONE");
            return member;
        }else if(member.getPw().equals(param.getPw())){
            return member;
        }else{
            member.setId("NO_MATCH");
            return member;
        }
    }

    @Override
    public MemberDTO Join(MemberDTO param) {
        return null;
    }
}
