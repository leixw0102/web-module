package com.ehualu.rise.service.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.dto.UserDto;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.log.LoginLog;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.service.log.LoginLogService;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.web.SessionContext;

/**
 * 用户登陆
 * 
 * @author Administrator
 * 
 */
public class LoginManager implements ServiceInterface {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private LoginLogService loginLogService;

	public LoginLogService getLoginLogService() {
		return loginLogService;
	}
	@Inject
	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
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
		if (user == null) {
			header.setZtm(AppConstant.Code_01.USER_PWD_IS_WRONG);
			return formatResult(header, null);
		}
		try {
			// if(!SecurityUtil.md5(usr.getPhone(),usr.getPassword()).equals(user.getPassword())){
			// header.setZtm(AppConstant.Code_01.USER_PWD_IS_WRONG);
			// return formatResult(JSON.toJSONString(header), null);
			// }
			if (!usr.getPassword().equals(user.getPassword())) {
				header.setZtm(AppConstant.Code_01.USER_PWD_IS_WRONG);
				return formatResult(header, null);
			}
			userService.updateUserLoginStatus(usr.getPhone(),
					AppConstant.USERLOG_STATE_LOGIN);
			LoginLog record = new LoginLog();
			record.setPhone(usr.getPhone());
			record.setMac(usr.getMac());
			record.setMfrs(usr.getMfrs());
			record.setModel(usr.getModel());
			record.setOptTime(DateUtil.getTimestamp());
			record.setAction(AppConstant.USERLOG_STATE_LOGIN);
			loginLogService.insertLoginLog(record);
			//将用户信息存入session
//			HttpSession session = SessionContext.getSession(usr.getPhone());
//			session.setAttribute("userinfo", user);

		} catch (Exception e) {
			e.printStackTrace();
			header.setZtm(AppConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			return formatResult(header, null);
		}
		UserDto userDto = new UserDto();
		userDto.setPhone(user.getPhone());
		userDto.setNick(user.getNick());
		userDto.setPassword(user.getPassword());
		userDto.setCreateDate(user.getCreateDate());
		
		return formatResult(header, userDto);
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