package com.ehualu.rise.constants;

/**
 * APP常量
 * 
 * @author Administrator
 * 
 */
public class AppConstant {

	// 包头
	public static final String HEAD = "head";
	// 包体
	public static final String BODY = "body";
	// 用户登录-登入
	public static final String USERLOG_STATE_LOGIN = "0";
	// 用户登录-登出
	public static final String USERLOG_STATE_LOGOUT = "1";

	// 用户状态-不可用
	public static final String USER_STATE_INVALID = "0";
	// 用户状态-可用
	public static final String USER_STATE_VALID = "1";

	// 标示 注册-发送验证码
	public static final String REGISTER_SEND_VERIFECODE = "0";
	// 标示 找回密码-发送验证码
	public static final String FINDPWD_SEND_VERIFECODE = "1";
	// 短信验证码固定话术
	public static final String SMS_MESSAGE_KEY = "SMS_MSG";
	// 短信发送成功标志
	public static final String SMS_SEND_SUCCESS = "0";

	/**
	 * 公共执行标记代码 000 至 100为公共号段：
	 */
	public static final class ExecuteFlag {

		// 成功状态
		public static final String STATU_SUCCESS = "000";

		// 协议号错误
		public static final String XYH_IS_NULL = "001";

		// 系统异常
		public static final String SYSTEM_IS_EXCEPTION = "002";

		// 包头错误
		public static final String HEAD_IS_NULL = "003";

		// 包体错误
		public static final String BODY_IS_NULL = "004";

		// 网络错误
		public static final String NETWORK_IS_EXCEPTION = "005";

		// 查询结果集为空
		public static final String RESULT_IS_NULL = "006";

		// 协议解析错误
		public static final String PROTOCOL_IS_ERROR = "007";

		// interface验证签名失败
		public static final String SIGN_VERIFY_WRONG_INTERFACE = "008";

		// appServer验证签名失败
		public static final String SIGN_VERIFY_WRONG_APPSERVER = "009";

		// 用户登录过期
		public static final String SESSION_EXPIRE = "010";
	}

	// 登陆
	public static final class Code_01 {
		// 用户名或密码错误
		public static final String USER_PWD_IS_WRONG = "101";

		// 密码加密错误
		// public static final String PWD_JIAMI_FAIL = "102";
		// 老用户名或密码错误
		public static final String OLD_PWD_IS_WRONG = "102";

		// 手机号已经注册
		public static final String USER_DUPLIREGISTER_ERROR = "103";

		// 验证码发送失败
		public static final String AUTHENCODE_SEND_ERROR = "104";

		// 验证码校验失败
		public static final String AUTHENCODE_ERROR = "105";

		// 用户注册失败
		public static final String USER_REGISTER_ERROR = "106";
		// 老密码与新密码一致
		public static final String OLDPWD_PWD_SAME = "107";
		// 用户不存在
		public static final String USER_NOTEXISTS_ERROR = "108";
		// 用户重置密码失败
		public static final String USER_RESETPWD_ERROR = "109";

		public static final String USER_FEEDBACK_ERROR = "110";

	}

	public static final class Code_03 {
		// 查询条件为空
		public static final String HPHM_HPZL_IS_NULL = "301";

		// 号牌号码为空
		public static final String HPHM_IS_NULL = "302";

		// 号牌种类为空
		public static final String HPZL_IS_NULL = "303";

		// 发动机号为空
		public static final String FDJH_IS_NULL = "304";

		// 号牌种类不匹配
		public static final String HPZL_NO_MATCH = "305";

		// 发动机号不匹配
		public static final String FDJH_NO_MATCH = "306";
		
		// 号牌号码不存在
		public static final String HPHM_NOT_EXIST = "307";
		
		// 用户名不存在
		public static final String USERNAME_NOT_EXIST = "308";

	}

	public static final class Code_04 {
		// 用户名为空
		public static final String USERNAME_IS_NULL = "402";
		// 姓名为空
		public static final String XM_IS_NULL = "403";
		// 档案编号为空
		public static final String DABH_IS_NULL = "404";
		// 驾驶证号为空
		public static final String LICENSE_SFZMHM_IS_NULL = "405";
		// 驾驶证不存在
		public static final String JSZ_IS_NOT_EXISTS = "406";
		// 信息不匹配
		public static final String INFO_NOT_MATCH = "407";

	}

	public static final class Code_06 {
		// 查询条件为空
		public static final String HPHM_HPZL_IS_NULL = "601";

		// 号牌号码为空
		public static final String HPHM_IS_NULL = "602";

		// 号牌种类为空
		public static final String HPZL_IS_NULL = "603";

		// 发动机号为空
		public static final String FDJH_IS_NULL = "604";

		// 号牌种类不匹配
		public static final String HPZL_NO_MATCH = "605";

		// 发动机号不匹配
		public static final String FDJH_NO_MATCH = "606";

		// 结果集中发动机号为空
		public static final String FDJH_RESULT_NULL = "607";
	}

	/** 用户协议 **/
	// 登陆协议
	public static final String SERVICE_CODE_LOGIN = "0101";
	// 修改密码
	public static final String SERVICE_CODE_CHANGEPASSWORD = "0102";
	// 用户注册
	public static final String SERVICE_CODE_REGISTER = "0103";
	// 发送验证码
	public static final String SERVICE_CODE_VERIFICATIONCODE = "0104";
	// 找回密码
	public static final String SERVICE_CODE_FEEDBACK = "0105";
	
	/** 机动车协议 **/
	// 机动车查询
	public static final String SERVICE_CODE_QUERY_JDC_INFO = "0301";
	
	/** 驾驶证协议 **/
	// 驾驶证查询
	public static final String SERVICE_CODE_QUERY_DRIVERLICENSE_INFO = "0401";
	// 驾驶证绑定
	public static final String SERVICE_CODE_DRIVERLICENSE_BOUND = "0402";
	// 驾驶证解除绑定
	public static final String SERVICE_CODE_DRIVERLICENSE_UNBOUND = "0403";
	// 查询用户绑定驾驶证信息
	public static final String SERVICE_CODE_QUERYBOUND_LICENSE = "0404";
	
	/** 咨询广告协议 **/
	// 获取咨询广告
	public static final String SERVICE_CODE_QUERYTOPIC = "0501";
	
	/** 违法查询协议 **/
	// 机动车违法查询
	public static final String SERVICE_CODE_QUERY_JDC_VEHICLE = "0601";

	// 系统错误提示协议
	public static final String SERVICE_CODE_SYSTEM = "9999";
}
