package com.ehualu.rise.webservice;

/**
 * 驾驶证与机动车违法联合查询业务处理
 * @author Administrator
 *
 */
public interface ViolationComplexWebService {

	/**
	 * 机动与驾驶证违法联合处理
	 * @param jsonParam
	 * @return
	 */
	public String queryViolationComplex(String paramJSON);
	
	/**
	 * 机动与驾驶证违法联合处理加密数据
	 * @param paramJSON
	 * @return
	 */
	public String queryEnViolationComplex(String paramJSON);
}