DROP TABLE MEMBER;

CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20) PRIMARY KEY,
	MEMBER_PW VARCHAR2(30) NOT NULL,
	MEMBER_NAME VARCHAR2(50) NOT NULL,
	MEMBER_NICK VARCHAR2(20) NOT NULL,
	MEMBER_BIRTH NUMBER NOT NULL,
	MEMBER_EMAIL VARCHAR2(100) NOT NULL,
	MEMBER_ENABLED VARCHAR2(2) DEFAULT ('N') NOT NULL,
	MEMBER_PHONE VARCHAR2(100) NOT NULL,
	MEMBER_ADDR VARCHAR2(50) NOT NULL, 
	MEMBER_ROLE VARCHAR2(20) DEFAULT ('회원') NOT NULL,
	CONSTRAINT MEMBER_NICK_UK UNIQUE (MEMBER_NICK),
	CONSTRAINT MEMBER_EMAIL_UK UNIQUE (MEMBER_EMAIL),
	CONSTRAINT MEMBER_ENABLED_CHK CHECK (MEMBER_ENABLED IN ('Y','N')),
	CONSTRAINT MEMBER_PHONE_UK UNIQUE (MEMBER_PHONE),
	CONSTRAINT MEMBER_ROLE_CHK CHECK (MEMBER_ROLE IN ('관리자','회원'))
);

SELECT * FROM MEMBER;