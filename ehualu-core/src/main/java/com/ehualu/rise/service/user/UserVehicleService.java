package com.ehualu.rise.service.user;

import java.util.List;

import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.pojo.user.UserVehicle;

/**
 * 用户绑定机动车接口
 * @author Bright
 *
 */
public interface UserVehicleService {
	/**
	 * 新增用户绑定机动车
	 * @param phone
	 * @return
	 */
	public int insertOrUpdateUserVehicle(UserVehicle userVehicle);
	/**
	 * 查询用户绑定机动车
	 * @param userVehicle
	 * @return
	 */
	public List<UserVehicle> queryUserVehicleByUsername(UserVehicle userVehicle);
	/**
	 * 解绑机动车
	 * @param userVehicle
	 * @return
	 */
	public int unboundUserVehicle(UserVehicle userVehicle);
	/**
	 * 查询用户绑定机动车
	 * @param username
	 * @param hphm
	 * @return
	 */
	public UserVehicle queryUserVehicle(UserVehicle userVehicle);
	
}
