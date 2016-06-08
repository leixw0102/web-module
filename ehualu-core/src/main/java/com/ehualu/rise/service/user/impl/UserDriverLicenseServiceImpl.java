package com.ehualu.rise.service.user.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ehualu.rise.dao.user.UserDriverLicenseDao;
import com.ehualu.rise.pojo.user.UserDriverLicense;
import com.ehualu.rise.service.user.UserDriverLicenseService;

@Service("userDriverLicenseService")
public class UserDriverLicenseServiceImpl implements UserDriverLicenseService{
	
	private UserDriverLicenseDao userDriverLicenseDao;
	
	
	public UserDriverLicenseDao getUserDriverLicenseDao() {
		return userDriverLicenseDao;
	}
	@Inject
	public void setUserDriverLicenseDao(UserDriverLicenseDao userDriverLicenseDao) {
		this.userDriverLicenseDao = userDriverLicenseDao;
	}

	@Override
	public int insertOrUpdateUserDriverLicense(
			UserDriverLicense userDriverLicense) {
		if(userDriverLicense.getId() == null || "".equals(userDriverLicense.getId())){
			return userDriverLicenseDao.insertSelective(userDriverLicense);
		}else{
			return userDriverLicenseDao.updateByPrimaryKeySelective(userDriverLicense);
		}
	}

	@Override
	public List<UserDriverLicense> queryUserDriverLicenseByUsername(
			UserDriverLicense userDriverLicense) {
		return userDriverLicenseDao.queryUserDriverLicenseByUsername(userDriverLicense.getUsername());
	}
	@Override
	public int unboundUserDriverLicense(UserDriverLicense userDriverLicense) {
		return userDriverLicenseDao.deleteSelective(userDriverLicense);
	}
	@Override
	public UserDriverLicense queryUserDriverLicense(UserDriverLicense userLicense) {
		return userDriverLicenseDao.queryUserDriverLicense(userLicense);
	}

}
