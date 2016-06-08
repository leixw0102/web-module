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
import com.ehualu.rise.service.violate.ViolationComplexService;
import com.ehualu.rise.webservice.ViolationComplexWebService;
/**
 * 驾驶证与机动车违法联合查询业务处理
 * @author Administrator
 *
 */
@Service("violationComplexWebService")
public class ViolationComplexWebServiceImpl implements ViolationComplexWebService {

	private static final Logger logger = Logger.getLogger(ViolationComplexWebServiceImpl.class);
	
	private ViolationComplexService violationComplexService;
	
	public ViolationComplexService getViolationComplexService() {
		return violationComplexService;
	}

	@Inject
	public void setViolationComplexService(ViolationComplexService violationComplexService) {
		this.violationComplexService = violationComplexService;
	}



	/**
	 * 机动与驾驶证违法联合处理
	 * @param jsonParam
	 * @return
	 */
	public String queryViolationComplex(String paramJSON) {
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
			Msg msg = violationComplexService.queryViolationComplex(outputStr);
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
	 * 机动与驾驶证违法联合处理加密数据
	 * @param paramJSON
	 * @return
	 */
	public String queryEnViolationComplex(String paramJSON){
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
			Msg msg = violationComplexService.queryEnViolationComplex(outputStr);
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
