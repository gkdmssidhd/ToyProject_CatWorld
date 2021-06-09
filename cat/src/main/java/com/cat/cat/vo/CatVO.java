package com.cat.cat.vo;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CatVO {

	private String id;				// 아이디
	private String password;		// 비번
	private String email;			// 이메일
	
	private int no;					// 고양이 번호
	private String name;			// 이름
	private String model;			// 종
	private int age;				// 나이
	private int gender;				// 성별
	private String content;			// 소개
	private int price;				// 가격
	private Timestamp regDate;		// 등록일시
	private Timestamp updateDate;	// 수정일시
	
	private String gubun;			// 저장&수정 작업을 구분하기 위한 변수
	private int returnCnt;			// 작업처리 결과건수(1건이면 1받고, 2건이면 2받고)
	
}