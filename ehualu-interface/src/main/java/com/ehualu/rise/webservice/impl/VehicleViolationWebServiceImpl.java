package com.ehualu.rise.webservice.impl;


import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constant.KeyStoreRSA;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.msg.SecurityMsg;
import com.ehualu.rise.property.PropertyConfig;
import com.ehualu.rise.security.rsa.RSAUtils;
import com.ehualu.rise.service.violate.VehicleViolateService;
import com.ehualu.rise.webservice.VehicleViolationWebService;
/**
 * 机动车违章查询接口实现
 * @author Administrator
 *
 */
@Service("vehicleViolationWebService")
public class VehicleViolationWebServiceImpl implements VehicleViolationWebService {

	private static final Logger logger = Logger.getLogger(VehicleViolationWebServiceImpl.class);
	private VehicleViolateService vehicleViolateService;
	
	
	public VehicleViolateService getVehicleViolateService() {
		return vehicleViolateService;
	}

	@Inject
	public void setVehicleViolateService(VehicleViolateService vehicleViolateService) {
		this.vehicleViolateService = vehicleViolateService;
	}

	/**
	 * 查询车辆违法信息
	 * @param paramJSON
	 * @return
	 */
	public String queryVehicleViolate(String paramJSON){
		try {
			SecurityMsg sMsg = JSON.parseObject(paramJSON, SecurityMsg.class);
			//验证对方签名
			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PUBLIC_KEY, sMsg.getSignature());
			//验证失败
			if(!isOK){
				//用对方的公钥加密
				Msg msg = new Msg();
				msg.setStatuCode(InterfaceConstant.SIGN_VERIFY_WRONG);
				msg.setMsgBody(PropertyConfig.getProperty("SIGN_VERIFY_WRONG"));
				String meg = JSON.toJSONString(msg);
				byte[] encrypt = RSAUtils.encryptByPublicKey(meg.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
				String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
				SecurityMsg securityMsg = new SecurityMsg();
				securityMsg.setSignature(signzj);
				securityMsg.setDigest(encrypt);
				return JSON.toJSONString(securityMsg);
			}
			//用自己私钥解密
			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			String outputStr = new String(decrypt,"gbk");
			//查询驾驶证信息
			Msg msg = vehicleViolateService.queryVehicleViolate(outputStr);
			String jsonResult = JSON.toJSONString(msg);
			//用对方的公钥加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonResult.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
			logger.info("encrypt======="+encrypt);
			
			//生成自己的签名
			String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			//生成传输对象
			SecurityMsg securityMsg = new SecurityMsg();
			securityMsg.setSignature(signzj);
			securityMsg.setDigest(encrypt);
			return JSON.toJSONString(securityMsg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			return JSON.toJSONString(null);
		}
	}
	
	/**
	 * 根据号牌号码查询机动车违法(通过时间点，结果集数量)
	 * @param paramJson
	 * @return
	 */
	public String queryViolateByHphm(String paramJson){
		try {
			SecurityMsg sMsg = JSON.parseObject(paramJson, SecurityMsg.class);
			//验证对方签名
			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PUBLIC_KEY, sMsg.getSignature());
			//验证失败
			if(!isOK){
				//用对方的公钥加密
				Msg msg = new Msg();
				msg.setStatuCode(InterfaceConstant.SIGN_VERIFY_WRONG);
				msg.setMsgBody(PropertyConfig.getProperty("SIGN_VERIFY_WRONG"));
				String meg = JSON.toJSONString(msg);
				byte[] encrypt = RSAUtils.encryptByPublicKey(meg.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
				String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
				SecurityMsg securityMsg = new SecurityMsg();
				securityMsg.setSignature(signzj);
				securityMsg.setDigest(encrypt);
				return JSON.toJSONString(securityMsg);
			}
			//用自己私钥解密
			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			String outputStr = new String(decrypt,"gbk");
			//查询驾驶证信息
			Msg msg = vehicleViolateService.queryViolateByHphm(outputStr);
			String jsonResult = JSON.toJSONString(msg);
			//用对方的公钥加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonResult.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
			logger.info("encrypt======="+encrypt);
			
			//生成自己的签名
			String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			//生成传输对象
			SecurityMsg securityMsg = new SecurityMsg();
			securityMsg.setSignature(signzj);
			securityMsg.setDigest(encrypt);
			return JSON.toJSONString(securityMsg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			return JSON.toJSONString(null);
		}
	}
	
	/**
	 * 通过号牌号码查询加密机动车违法信息参数为对象
	 * @param paramJson
	 * @return
	 */
	public String queryEnViolateByHphm(String paramJson){
		try {
			SecurityMsg sMsg = JSON.parseObject(paramJson, SecurityMsg.class);
			//验证对方签名
			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PUBLIC_KEY, sMsg.getSignature());
			//验证失败
			if(!isOK){
				//用对方的公钥加密
				Msg msg = new Msg();
				msg.setStatuCode(InterfaceConstant.SIGN_VERIFY_WRONG);
				msg.setMsgBody(PropertyConfig.getProperty("SIGN_VERIFY_WRONG"));
				String meg = JSON.toJSONString(msg);
				byte[] encrypt = RSAUtils.encryptByPublicKey(meg.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
				String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
				SecurityMsg securityMsg = new SecurityMsg();
				securityMsg.setSignature(signzj);
				securityMsg.setDigest(encrypt);
				return JSON.toJSONString(securityMsg);
			}
			//用自己私钥解密
			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			String outputStr = new String(decrypt,"gbk");
			//查询驾驶证信息
			Msg msg = vehicleViolateService.queryEnViolateByHphm(outputStr);
			String jsonResult = JSON.toJSONString(msg);
			//用对方的公钥加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonResult.getBytes(), KeyStoreRSA.APPSERVER_PUBLIC_KEY);
			logger.info("encrypt======="+encrypt);
			
			//生成自己的签名
			String signzj = RSAUtils.sign(encrypt, KeyStoreRSA.INTERFACE_PRIVATE_KEY);
			//生成传输对象
			SecurityMsg securityMsg = new SecurityMsg();
			securityMsg.setSignature(signzj);
			securityMsg.setDigest(encrypt);
			return JSON.toJSONString(securityMsg);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			return JSON.toJSONString(null);
		}
	}
}
