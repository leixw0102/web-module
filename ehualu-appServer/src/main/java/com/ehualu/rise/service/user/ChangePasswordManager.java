package com.ehualu.rise.service.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.service.ServiceInterface;

public class ChangePasswordManager implements ServiceInterface{
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Map<String, Object> handle(String head, String body) {
		Head header = JSON.parseObject(head, Head.class);
		if (body == null) {
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(header, null);
		}
		User usr = JSON.parseObject(body, User.class);
		User user = userService.queryByUserName(usr.getPhone());

		if (!usr.getPassword().equals(user.getPassword())) {
			header.setZtm(AppConstant.Code_01.OLD_PWD_IS_WRONG);
			return formatResult(header, null);
		}
		if(usr.getNewPassword().equals(user.getPassword())){
			header.setZtm(AppConstant.Code_01.OLDPWD_PWD_SAME);
			return formatResult(header, null);
		}
		userService.updatePasswordByUserName(usr.getPhone(), usr.getNewPassword());
		
		return formatResult(header, null);
	}

	public Map<String, Object> formatResult(Object head, Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(AppConstant.HEAD, head);
		if (object != null) {
			map.put(AppConstant.BODY, object);
		}
		return map;
	}
}
