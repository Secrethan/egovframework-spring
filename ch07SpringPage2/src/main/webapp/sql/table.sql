--회원관리
create table spmember(
 mem_num number,
 id varchar2(12) unique not null,
 nick_name varchar2(30),
 auth number(1) default 2 not null, --0탈퇴회원,1정지회원,2일반회원,9관리자
 au_id varchar2(36), --자동 로그인에 사용되는 식별값
 constraint spmember_pk primary key (mem_num)
);

create table spmember_detail(
 mem_num number,
 name varchar2(30) not null,
 passwd varchar2(35) not null,
 phone varchar2(15) not null,
 email varchar2(50) not null,
 zipcode varchar2(5) not null,
 address1 varchar2(90) not null,
 address2 varchar2(90) not null,
 hobby varchar2(300),
 photo blob,
 photo_name varchar2(100),
 reg_date date default sysdate not null,
 modify_date date,
 constraint spmember_detail_pk primary key (mem_num),
 constraint spmember_detail_fk1 foreign key (mem_num)
                          references spmember (mem_num)
);

create sequence spmember_seq;








