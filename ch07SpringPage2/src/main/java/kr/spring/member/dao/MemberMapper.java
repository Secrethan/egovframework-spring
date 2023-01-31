package kr.spring.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.spring.member.vo.MemberVO;

@Mapper
public interface MemberMapper {
	//회원관리 - 일반회원
	@Select("SELECT spmember_seq.nextval FROM dual")
	public int selectMem_num();
	@Insert("INSERT INTO spmember (mem_num,id) VALUES (#{mem_num},#{id})")
	public void insertMember(MemberVO member);
	@Insert("INSERT INTO spmember_detail (mem_num,"
		  + "name,passwd,phone,email,zipcode,address1,"
		  + "address2,hobby) VALUES (#{mem_num},"
		  + "#{name},#{passwd},#{phone},#{email},"
		  + "#{zipcode},#{address1},#{address2},"
		  + "#{hobby})")
	public void insertMember_detail(MemberVO member);
	@Select("SELECT m.mem_num,m.id,m.auth,m.au_id,"
		  + "d.passwd,m.nick_name,d.email FROM "
		  + "spmember m LEFT OUTER JOIN spmember_detail d "
		  + "ON m.mem_num=d.mem_num WHERE m.id=#{id}")
	public MemberVO selectCheckMember(String id);
	public MemberVO selectMember(Integer mem_num);
	public void updateMember(MemberVO member);
	public void updateMember_detail(MemberVO member);
	public void updatePassword(MemberVO member);
	public void deleteMember(Integer mem_num);
	public void deleteMember_detail(Integer mem_num);
	
}
