package com.ehualu.rise.service.user;

import java.util.List;

import com.ehualu.rise.pojo.user.UserDriverLicense;

/**
 * 用户绑定驾驶证接口
 * @author Bright
 *
 */
public interface UserDriverLicenseService {
	/**
	 * 新增用户绑定驾驶证
	 * @param phone
	 * @return
	 */
	public int insertOrUpdateUserDriverLicense(UserDriverLicense userDriverLicense);
	/**
	 * 通过用户名查询用户绑定的驾驶证信息
	 * @param userDriverLicense
	 * @return
	 */
	public List<UserDriverLicense> queryUserDriverLicenseByUsername(UserDriverLicense userDriverLicense);
	/**
	 * 解绑驾驶证
	 * @param userDriverLicense
	 * @return
	 */
	public int unboundUserDriverLicense(UserDriverLicense userDriverLicense);
	/**
	 * 查询驾驶证绑定
	 * @param userName
	 * @param zjhm
	 * @return
	 */
	public UserDriverLicense queryUserDriverLicense(UserDriverLicense userLicense);
}
