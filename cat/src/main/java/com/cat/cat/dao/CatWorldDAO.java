package com.cat.cat.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cat.cat.vo.CatVO;

@Repository("CatWorldDAO")
public class CatWorldDAO extends AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(CatWorldDAO.class);

	public void joinProc(CatVO catVO) throws Exception {
	
		  try { 
			  insert("cat.insertMember", catVO); 
		  } catch(Exception e) {
			  logger.info("DB Error >>>>>>>>>"); 
			  e.printStackTrace(); 
		  }
	}

	public CatVO loginProc(CatVO catVO) throws Exception{
		
		return (CatVO) select("cat.selectMember", catVO); 
	}


	
}
