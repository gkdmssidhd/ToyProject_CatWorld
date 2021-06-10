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

	
}