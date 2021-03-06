package com.ehualu.rise.service.violate;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.constants.KeyStoreRSA;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.msg.SecurityMsg;
import com.ehualu.rise.pojo.violate.DrivingLicense;
import com.ehualu.rise.pojo.violate.DrivingLicenseEn;
import com.ehualu.rise.security.rsa.RSAUtils;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.util.SecurityUtil;
import com.ehualu.rise.webservice.DrivingLicenseWebService;

/**
 * 驾驶证信息查询
 * 
 * @author Administrator
 * 
 */
public class QueryDrivingLicenseManage implements ServiceInterface{
	private static final Logger logger = Logger
			.getLogger(QueryJdcViolateManager.class);
	
	private DrivingLicenseWebService drivingLicenseWebService;



	public DrivingLicenseWebService getDrivingLicenseWebService() {
		return drivingLicenseWebService;
	}
	@Inject
	public void setDrivingLicenseWebService(
			DrivingLicenseWebService drivingLicenseWebService) {
		this.drivingLicenseWebService = drivingLicenseWebService;
	}

	@Override
	public Map<String, Object> handle(String head, String body) {
		Head header = JSON.parseObject(head, Head.class);
		if (body == null) {
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(header, null);
		}
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		DrivingLicense drivingLicense = JSON.parseObject(body, DrivingLicense.class);
		try {
			
			//姓名为空
			if(drivingLicense.getXm() == null || "".equals(drivingLicense.getXm())){
				header.setZtm(AppConstant.Code_04.XM_IS_NULL);
				return formatResult(header,null);
			}
			//档案编号为空
			if(drivingLicense.getDabh() == null || "".equals(drivingLicense.getDabh())){
				header.setZtm(AppConstant.Code_04.DABH_IS_NULL);
				return formatResult(header,null);
			}
			//身份证号码为空
			if(drivingLicense.getSfzmhm() == null || "".equals(drivingLicense.getSfzmhm())){
			    header.setZtm(AppConstant.Code_04.LICENSE_SFZMHM_IS_NULL);
			    return formatResult(header,null);
			}
			
			//drivingLicense.setSfzmhm(SecurityUtil.md5(drivingLicense.getSfzmhm()));
			body = JSON.toJSONString(drivingLicense);
			byte[] encrypt = RSAUtils.encryptByPublicKey(body.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);

			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);

			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
			msgStr = drivingLicenseWebService.queryEnLicenseBySfzmhm(JSON.toJSONString(message));
			
			SecurityMsg sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
			boolean isOK = RSAUtils.verify(sMsg.getDigest(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
			if (!isOK) {
				// appServer验证签名失败
				header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
				return formatResult(header, null);
			}
			System.out.println("isOK:" + isOK);
			System.out.println("sMsg.getDigest():" + sMsg.getDigest());
			decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			outputStr = new String(decrypt, "gbk");
			System.out.println("outputStr:" + outputStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Msg msg = JSON.parseObject(new String(decrypt), Msg.class);
		if ((msg.getStatuCode()).equals(InterfaceConstant.SIGN_VERIFY_WRONG)) {
			header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_INTERFACE);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(AppConstant.Code_04.JSZ_IS_NOT_EXISTS);
			return formatResult(header, null);
		}
		DrivingLicense license = JSON.parseObject(msg.getMsgBody().toString(), DrivingLicense.class);
		if(!license.getXm().equals(drivingLicense.getXm()) || !license.getDabh().equals(drivingLicense.getDabh())){
			header.setZtm(AppConstant.Code_04.INFO_NOT_MATCH);
			return formatResult(header, null);
		}
		return formatResult(header, msg.getMsgBody());
	}

	@Override
	public Map<String, Object> formatResult(Object head, Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(AppConstant.HEAD, head);
		if (object != null) {
			map.put(AppConstant.BODY, object);
		}

		return map;
	}
}
