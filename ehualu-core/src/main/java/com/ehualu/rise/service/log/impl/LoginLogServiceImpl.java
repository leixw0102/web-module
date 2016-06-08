package com.ehualu.rise.service.log.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehualu.rise.dao.log.LoginLogDao;
import com.ehualu.rise.pojo.log.LoginLog;
import com.ehualu.rise.service.log.LoginLogService;
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService{
	
	private LoginLogDao loginLogDao;
	
	public LoginLogDao getLoginLogDao() {
		return loginLogDao;
	}
	@Inject
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}

	@Override
	public int insertLoginLog(LoginLog record) {
		return loginLogDao.insertSelective(record);
	}
	
	@Override
	public Timestamp findLastLoginTime(String phone) {
		// TODO Auto-generated method stub
		return loginLogDao.findLastLoginTime(phone);
	}

}
