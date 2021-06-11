package com.cat.cat.service;

import java.util.List;
import com.cat.cat.vo.CatVO;

public interface CatWorldService {

	// 회원가입
	public void joinProc(CatVO catVO) throws Exception;

	// 로그인
	public CatVO loginProc(CatVO catVO) throws Exception;

	// 글 저장
	public CatVO catSave(CatVO catVO) throws Exception;





}
