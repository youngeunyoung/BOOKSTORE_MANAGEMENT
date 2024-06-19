package com.exam.mapper;

import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public MemberDTO idCheck(String member_id);
	public int memberAdd(MemberDTO dto);
	
	public MemberDTO login(Map<String, String> map);
	
	public MemberDTO mypage(String member_id);
	public int updateProfile(@Valid MemberDTO dto);
}
