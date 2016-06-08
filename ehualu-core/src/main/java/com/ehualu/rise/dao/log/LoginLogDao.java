package com.ehualu.rise.dao.log;

import java.sql.Timestamp;

import com.ehualu.rise.pojo.log.LoginLog;


public interface LoginLogDao {
    int deleteByPrimaryKey(int id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
    
    Timestamp findLastLoginTime(String phone);
}