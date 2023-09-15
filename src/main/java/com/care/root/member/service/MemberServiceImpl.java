package com.care.root.member.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper mapper;
	public int user_check(String id, String pw ) {
		MemberDTO dto = mapper.user_check( id );
		if(dto != null) {
			if( pw.equals(dto.getPw()) ) {
				return 0;
			}
		}
		return 1;
	}
	public List<MemberDTO> memberInfo() {
		List<MemberDTO> list = null;
		try {
			list = mapper.memberInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public MemberDTO info( String userId) {
		MemberDTO dto = null;
		try {
			dto = mapper.info(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public int register(MemberDTO member) {
		try {
			return mapper.register(member);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
