package com.ehualu.rise.service.msg.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.pojo.msg.XingeMsg;
import com.ehualu.rise.property.PropertyConfig;
import com.ehualu.rise.service.msg.MsgService;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;
/**
 * 通过信鸽发送消息接口
 * @author Administrator
 *
 */
@Service("msgService")
public class MsgServiceImpl  implements MsgService{

	private static final Logger logger = Logger.getLogger(MsgServiceImpl.class);
	
	/**
	 * 初始化信鸽对象 高级接口专用
	 * @return
	 */
	private XingeApp initXingeApp(){
		long accessId = PropertyConfig.getIntProperty("ACCESS_ID");
		String secretKey = PropertyConfig.getProperty("SECRET_KEY");
		logger.info("accessId:"+accessId+"&secretKey:"+secretKey);
		XingeApp push = new XingeApp(accessId, secretKey);
		return push;
	}
	
	/**
	 * 初始化参数 快捷发送消息专用
	 * @return
	 */
	private XingeMsg initParam(){
		long accessId = PropertyConfig.getIntProperty("ACCESS_ID");
		String secretKey = PropertyConfig.getProperty("SECRET_KEY");
		logger.info("accessId:"+accessId+"&secretKey:"+secretKey);
		XingeMsg xgm = new XingeMsg();
		xgm.setAccessId(accessId);
		xgm.setSecretKey(secretKey);
		return xgm;
	}
	/**
	 * Android平台推送消息给单个设备
	 * @param title 消息标题，Android专属
	 * @param content 消息内容
	 * @param token 接收消息的设备Token
	 * @return
	 */
	public int pushTokenAndroid(String title,String content,String token){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushTokenAndroid(xgm.getAccessId(), xgm.getSecretKey(), title, content, token);
		logger.info("pushTokenAndroid:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android平台推送消息给单个帐号
	 * @param title 消息标题，Android专属
	 * @param content 消息内容
	 * @param account 接收消息的账号
	 * @return
	 */
	public int pushAccountAndroid(String title,String content,String account){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushAccountAndroid(xgm.getAccessId(), xgm.getSecretKey(), title, content, account);
		logger.info("pushAccountAndroid:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android平台推送消息给所有设备
	 * @param title 消息标题，Android专属
	 * @param content 消息内容
	 * @return
	 */
	public int pushAllAndroid(String title,String content){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushAllAndroid(xgm.getAccessId(), xgm.getSecretKey(), title, content);
		logger.info("pushAllAndroid:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android平台推送消息给标签选中设备
	 * @param title 消息标题，Android专属
	 * @param content 消息内容
	 * @param tag 接收消息的设备标签
	 * @return
	 */
	public int pushTagAndroid(String title,String content,String tag){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushTagAndroid(xgm.getAccessId(), xgm.getSecretKey(), title, content, tag);
		logger.info("pushTagAndroid:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android平台推送消息给单个设备(消息Message.TYPE_MESSAGE和通知Message.TYPE_NOTIFICATION)
	 * @param token 推送目标设备token
	 * @param message 定义Android平台推送消息
	 * @return
	 */
	public int pushSingleDevice(String token,Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushSingleDevice(token, message);
		logger.info("pushSingleDevice:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android推送消息给单个账户或别名
	 * @param account 推送目标账号
	 * @param message 定义Android平台推送消息
	 * @return
	 */
	public int pushSingleAccount(String account,Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushSingleAccount(0,account, message);
		logger.info("pushSingleAccount:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android推送消息给多个账户或别名
	 * @param accountList 推送目标账号，账号数量有限制，一次100个
	 * @param message 定义Android平台推送消息
	 * @return
	 */
	public int pushAccountList(List<String> accountList,Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushAccountList(0, accountList, message);
		logger.info("pushAccountList:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android推送消息给单个app的所有设备
	 * @param message 定义Android平台推送消息
	 * @return
	 */
	public int pushAllDevice(Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushAllDevice(0, message);
		logger.info("pushAllDevice:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android推送消息给tags指定的设备
	 * @param tagList 指定推送目标的tag列表，每个tag是一个string
	 * @param tagsOp 多个tag的运算关系，取值为AND或OR
	 * @param message 定义Android平台推送消息
	 * @return
	 */
	public int pushTags(List<String> tagList,String tagsOp,Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushTags(0, tagList, tagsOp, message);
		logger.info("pushTags:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * Android创建大批量推送消息
	 * @param message
	 * @return
	 */
	public int createMultipush(Message message){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.createMultipush(message);
		logger.info("pushTags:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getResult().getPush_id();
	}
	
	/**
	 * iOS平台推送消息给单个设备
	 * @param content 消息内容
	 * @param token 接收消息的设备Token
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushTokenIos(String content,String token,int environment){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushTokenIos(xgm.getAccessId(), xgm.getSecretKey(), content, token, environment);
		logger.info("pushTokenIos:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * iOS平台推送消息给单个帐号
	 * @param content 消息内容
	 * @param account 接收消息的账号
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushAccountIos(String content,String account,int environment){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushAccountIos(xgm.getAccessId(), xgm.getSecretKey(), content, account, environment);
		logger.info("pushAccountIos:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * iOS平台推送消息给所有设备
	 * @param content 消息内容
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushAllIos(String content,int environment){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushAllIos(xgm.getAccessId(), xgm.getSecretKey(), content, environment);
		logger.info("pushAllIos:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * iOS平台推送消息给标签选中设备
	 * @param content 消息内容
	 * @param tag 接收消息的设备标签
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushTagIos(String content,String tag,int environment){
		XingeMsg xgm = initParam();
		JSONObject ret = XingeApp.pushTagIos(xgm.getAccessId(), xgm.getSecretKey(), content, tag, environment);
		logger.info("pushTagIos:"+ret);
		xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS平台推送消息给单个设备
	 * @param token
	 * @param message 定义iOS平台推送消息
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushSingleDeviceIos(String token,MessageIOS messageIos,int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushSingleDevice(token, messageIos, environment);
		logger.info("pushSingleDeviceIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS推送消息给单个账户或别名 
	 * @param account 推送目标账号
	 * @param messageIOS 定义iOS平台推送消息
	 * @return
	 */
	public int pushSingleAccountIos(String account,MessageIOS messageIOS,int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushSingleAccount(0, account, messageIOS, environment);
		logger.info("pushSingleAccountIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS推送消息给多个账户或别名
	 * @param accountList 推送目标账号，账号数量有限制，一次100个
	 * @param messageIOS 定义iOS平台推送消息
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushAccountListIos(List<String> accountList,MessageIOS messageIOS,int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushAccountList(0, accountList, messageIOS, environment);
		logger.info("pushAccountListIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS推送消息给单个app的所有设备
	 * @param messageIOS 定义iOS平台推送消息
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushAllDeviceIos(MessageIOS messageIOS,int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushAllDevice(0, messageIOS, environment);
		logger.info("pushAllDeviceIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS推送消息给tags指定的设备
	 * @param tagList 指定推送目标的tag列表，每个tag是一个string
	 * @param tagsOp 多个tag的运算关系，取值为AND或OR
	 * @param messageIOS 定义iOS平台推送消息
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int pushTagsIos(List<String> tagList,String tagsOp,MessageIOS messageIOS,int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushTags(0, tagList, tagsOp, messageIOS, environment);
		logger.info("pushTagsIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * IOS创建大批量推送消息
	 * @param messageIOS 定义iOS平台推送消息
	 * @param environment 可选值为XingeApp.IOSENV_PROD或者XingeApp.IOSENV_DEV，iOS专属
	 * @return
	 */
	public int createMultipushIos(MessageIOS messageIOS, int environment){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.createMultipush(messageIOS, environment);
		logger.info("createMultipushIos:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(),XingeMsg.class);
		return xgm.getResult().getPush_id();
	}
	
	/**
	 * 推送消息给大批量账号(可多次)
	 * @param pushId createMultipush接口返回的push_id
	 * @param accountList 推送目标账号，账号数量有限制，目前为1000个
	 * @return
	 */
	public int pushAccountListMultiple(int pushId, List<String> accountList){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushAccountListMultiple(pushId, accountList);
		logger.info("pushAccountListMultiple:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * 推送消息给大批量设备(可多次)
	 * @param pushId createMultipush接口返回的push_id
	 * @param deviceList 推送目标token，数量有限制，目前为1000个
	 * @return
	 */
	public int pushDeviceListMultiple(int pushId, List<String> deviceList){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.pushDeviceListMultiple(pushId, deviceList);
		logger.info("pushDeviceListMultiple:"+ret);
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	/**
	 * 查询应用覆盖的设备数
	 * @return
	 */
	public int queryDeviceCount(){
		XingeApp xinge = initXingeApp();
		JSONObject ret = xinge.queryDeviceCount();
		XingeMsg xgm = JSON.parseObject(ret.toString(), XingeMsg.class);
		return xgm.getRet_code();
	}
	
	public static void main(String[] args) {
		Message message1 = new Message();
		message1.setType(Message.TYPE_NOTIFICATION);
		Style style = new Style(1);
		style = new Style(3,1,0,1,0);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_URL);
		action.setUrl("http://10.2.151.63:8081/ehualu-admin/news/show/4");
		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("key1", "value1");
		custom.put("key2", 2);
		message1.setTitle("国内汽油每吨降价220元 柴油每吨降215元");
		message1.setContent("大小");
		message1.setStyle(style);
		message1.setAction(action);
		message1.setCustom(custom);
		
//		Message message2 = new Message();
//		message2.setType(Message.TYPE_NOTIFICATION);
//		message2.setTitle("title");
//		message2.setContent("通知点击执行Intent测试");
//		Style style = new Style(1);
//		ClickAction action = new ClickAction();
//		action.setActionType(ClickAction.TYPE_INTENT);
//		action.setIntent("intent:10086#Intent;scheme=tel;action=android.intent.action.DIAL;S.key=value;end");
//		message2.setStyle(style);
//		message2.setAction(action);
		
		MsgServiceImpl msg = new MsgServiceImpl();
//		msg.pushAllAndroid("国内汽油每吨降价220元 柴油每吨降215元", "http://10.2.151.63:8081/ehualu-admin/news/show/4");
//		msg.queryDeviceCount();
		String token = "e5b35d1369e35e9240e08e9be1f3c56002c7dbf5";
		msg.pushSingleDevice(token, message1);
	}

}
