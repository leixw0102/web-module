package com.ehualu.rise.service.user.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehualu.rise.dao.user.UserDao;
import com.ehualu.rise.dao.user.UserFeedBackDao;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.pojo.user.UserFeedBack;
import com.ehualu.rise.service.user.UserService;
/**
 * 
 * @author Administrator
 * 用户接口实现
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserFeedBackDao userFeedBackDao;
	
	

	public UserFeedBackDao getUserFeedBackDao() {
		return userFeedBackDao;
	}
	@Inject
	public void setUserFeedBackDao(UserFeedBackDao userFeedBackDao) {
		this.userFeedBackDao = userFeedBackDao;
	}

	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User queryByUserName(String phone){
		return userDao.queryByUsername(phone);
	}

	@Override
	public int updatePasswordByUserName(String phone,String newPassword) {
		return userDao.updatePasswordByUsername(phone,newPassword);
	}

	@Override
	public int insertUserFeedBack(UserFeedBack feedBack) {
		return userFeedBackDao.insertSelective(feedBack);
	}

	@Override
	public int registerUser(User user) {
		return userDao.insertSelective(user);
	}

	@Override
	public int updateUserLoginStatus(String phone,String status) {
		return userDao.updateUserLoginStatus(phone,status);
	}

	@Override
	public int updateUserPwd(String phone, String newPassword) {
		// TODO Auto-generated method stub
		return userDao.updateUserPwd(phone,newPassword);
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}
}
