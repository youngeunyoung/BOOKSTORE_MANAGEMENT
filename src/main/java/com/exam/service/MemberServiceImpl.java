package com.exam.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.exam.dto.MemberDTO;
import com.exam.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	MemberMapper memberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public MemberDTO idCheck(String member_id) {
		return memberMapper.idCheck(member_id);
	}

	@Override
	public int memberAdd(MemberDTO dto) {
		return memberMapper.memberAdd(dto);
	}

	@Override
	public MemberDTO login(Map<String, String> map) {
		return memberMapper.login(map);
	}

	@Override
	public MemberDTO mypage(String member_id) {
		return memberMapper.mypage(member_id);
	}

}
