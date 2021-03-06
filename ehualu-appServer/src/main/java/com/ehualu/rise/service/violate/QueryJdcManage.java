package com.ehualu.rise.service.violate;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.constants.KeyStoreRSA;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.msg.SecurityMsg;
import com.ehualu.rise.pojo.violate.Vehicle;
import com.ehualu.rise.pojo.violate.VehicleEn;
import com.ehualu.rise.security.rsa.RSAUtils;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.util.SecurityUtil;
import com.ehualu.rise.webservice.VehicleWebService;

 public class QueryJdcManage implements ServiceInterface{
	 
	private VehicleWebService vehicleWebService;
	

	public VehicleWebService getVehicleWebService() {
		return vehicleWebService;
	}
	@Inject
	public void setVehicleWebService(VehicleWebService vehicleWebService) {
		this.vehicleWebService = vehicleWebService;
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
		try {
			Vehicle vehicle = JSON.parseObject(body, Vehicle.class);
			//vehicle.setHphm(SecurityUtil.md5(vehicle.getHphm()));
			body = JSON.toJSONString(vehicle);
			//对数据进行加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(body.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);
			//签名
			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			
			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);

			msgStr = vehicleWebService.queryEnVehicleByHphm(JSON.toJSONString(message));
			
			SecurityMsg sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
			boolean isOK = RSAUtils.verify(sMsg.getDigest(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
			//对interface返回信息进行验签
			if(!isOK){
				//appServer验证interface签名失败
				header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
				return formatResult(header, null);
			}
			System.out.println("isOK:" + isOK);
			System.out.println("sMsg.getDigest():" + sMsg.getDigest());
			//对返回信息进行解密
			decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			outputStr = new String(decrypt, "gbk");
			System.out.println("outputStr:" + outputStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//解析返回信息
		Msg msg = JSON.parseObject(new String(decrypt), Msg.class);
		if ((msg.getStatuCode()).equals(InterfaceConstant.SIGN_VERIFY_WRONG)) {
			header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_INTERFACE);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.PARAM_IS_NULL)) {
			header.setZtm(AppConstant.Code_03.HPHM_HPZL_IS_NULL);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPHM_IS_NULL)) {
			header.setZtm(AppConstant.Code_03.HPHM_IS_NULL);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPZL_IS_NULL)) {
			header.setZtm(AppConstant.Code_03.HPZL_IS_NULL);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPZL_NO_MATCH)) {
			header.setZtm(AppConstant.Code_03.HPZL_NO_MATCH);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.FDJH_IS_NULL)) {
			header.setZtm(AppConstant.Code_03.FDJH_IS_NULL);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.FDJH_NO_MATCH)) {
			header.setZtm(AppConstant.Code_03.FDJH_NO_MATCH);
			return formatResult(header, null);
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(AppConstant.Code_03.HPHM_NOT_EXIST);
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
