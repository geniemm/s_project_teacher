package com.care.root.member.service;

import java.util.List;


import com.care.root.member.dto.MemberDTO;

public interface MemberService {
    public int user_check(String id, String pw );
    public List<MemberDTO> memberInfo();
    public MemberDTO info( String userId);
    public int register(MemberDTO member);
}
