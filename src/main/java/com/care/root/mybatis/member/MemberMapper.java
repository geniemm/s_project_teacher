package com.care.root.mybatis.member;

import java.util.List;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO user_check(String id);
	public List<MemberDTO> memberInfo();
	public MemberDTO info(String userId);
	public int register(MemberDTO member);
}
