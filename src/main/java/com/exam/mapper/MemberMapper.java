package com.exam.mapper;

import java.util.Map;


import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public MemberDTO idCheck(String member_id);
	public int memberAdd(MemberDTO dto);
	
	public MemberDTO login(Map<String, String> map);
	
	public MemberDTO mypage(String member_id);
	public void updateMypage(MemberDTO updateDTO);
	
	public MemberDTO getMemberInfo(String member_id);
}