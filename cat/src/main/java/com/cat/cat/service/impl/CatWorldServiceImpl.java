package com.cat.cat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cat.cat.dao.CatWorldDAO;
import com.cat.cat.service.CatWorldService;
import com.cat.cat.vo.CatVO;

@Service("CatWorldService")
public class CatWorldServiceImpl implements CatWorldService {
	private static final Logger logger = LoggerFactory.getLogger(CatWorldDAO.class);
	
	// Dao와 연결
	@Resource(name="CatWorldDAO")
	private CatWorldDAO CatWorldDAO;

	@Override
	public void joinProc(CatVO catVO) throws Exception {
		
		CatWorldDAO.joinProc(catVO);
	}

	@Override
	public CatVO loginProc(CatVO catVO) throws Exception {

		return CatWorldDAO.loginProc(catVO);
	}

	@Override
	public CatVO catSave(CatVO catVO) throws Exception {
		
		int resultCnt = 0;
		
		try {
			if("I".equals(catVO.getGubun())) {
				resultCnt = CatWorldDAO.catSave(catVO);
			} else {
				// resultCnt = CatWorldDAO.catUpdate(catVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		catVO.setReturnCnt(resultCnt);
		
		return catVO;
	}

	@Override
	public List<CatVO> catList() throws Exception {

		List<CatVO> catList = CatWorldDAO.catList();
		
		return catList;
	}

	@Override
	public CatVO catDetail() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatVO catUpdate(CatVO catVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}