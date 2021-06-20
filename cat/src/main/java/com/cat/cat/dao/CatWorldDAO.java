package com.cat.cat.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cat.cat.vo.CatVO;

@Repository("CatWorldDAO")
public class CatWorldDAO extends AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(CatWorldDAO.class);

	// 회원가입
	public void joinProc(CatVO catVO) throws Exception {
	
		  try { 
			  insert("cat.insertMember", catVO); 
		  } catch(Exception e) {
			  logger.info("DB Error >>>>>>>>>"); 
			  e.printStackTrace(); 
		  }
	}

	// 로그인
	public CatVO loginProc(CatVO catVO) throws Exception {
		
		return (CatVO) select("cat.selectMember", catVO); 
	}

	// 저장
	public int catSave(CatVO catVO) throws Exception {

		return (int) insert("cat.insertCat", catVO);
	}

	// 리스트
	public List<CatVO> catList() throws Exception{

		@SuppressWarnings("unchecked")
		List<CatVO> catList = (List<CatVO>) selectList("cat.selectCatList");
		
		return catList;
	}

	public int catUpdate(CatVO catVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
