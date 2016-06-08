package com.ehualu.rise.pojo.violate;

import java.io.Serializable;
/**
 * 机动违法加密数据
 * @author Administrator
 *
 */
public class VehicleViolateEn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1726307451857508003L;

	// 序号
	private String xh;
	// 决定书类别
	private String jdslb;
	// 联系方式
	private String lxfs;
	// 号牌种类
	private String hpzl;
	// 机动车所有人
	private String jdcsyr;
	// 号牌号码
	private String hphm;
	// 发动机号
	private String fdjh;
	// 违法地点
	private String wfdd;
	// 违法地址
	private String wfdz;
	// 违法时间
	private String wfsj;
	// 违法编号
	private String wfbh;
	// 违法行为
	private String wfxw;
	// 行政区划
	private String xzqh;
	// 当事人
	private String dsr;
	// 发证机关
	private String fzjg;
	// 电话
	private String dh;
	// 处理时间
	private String clsj;
	// 罚款金额
	private String fkje;
	// 决定书编号
	private String jdsbh;
	// 违法记分数
	private String wfjfs;
	// 违法采集机关
	private String cjjg;
	//处理标记
	private String clbj;
	//车辆识别代号
	private String clsbdh;
	//滞纳金
	private String znj;
	//网上缴款标记
	private String wsjkbj = "";
	//处理方式
	private String clfs = "";
	//通知书号
	private String tzsh = "";
	
	private int page;//页数
	
	private int pageSize;//每页条数
	
	private int endNum;//结束个数
	
	private int beginNum;//开始个数
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getJdslb() {
		return jdslb;
	}
	public void setJdslb(String jdslb) {
		this.jdslb = jdslb;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getJdcsyr() {
		return jdcsyr;
	}
	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getFdjh() {
		return fdjh;
	}
	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}
	public String getWfdd() {
		return wfdd;
	}
	public void setWfdd(String wfdd) {
		this.wfdd = wfdd;
	}
	public String getWfdz() {
		return wfdz;
	}
	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}
	public String getWfsj() {
		return wfsj;
	}
	public void setWfsj(String wfsj) {
		this.wfsj = wfsj;
	}
	public String getWfbh() {
		return wfbh;
	}
	public void setWfbh(String wfbh) {
		this.wfbh = wfbh;
	}
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getClsj() {
		return clsj;
	}
	public void setClsj(String clsj) {
		this.clsj = clsj;
	}
	public String getFkje() {
		return fkje;
	}
	public void setFkje(String fkje) {
		this.fkje = fkje;
	}
	public String getJdsbh() {
		return jdsbh;
	}
	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}
	public String getWfjfs() {
		return wfjfs;
	}
	public void setWfjfs(String wfjfs) {
		this.wfjfs = wfjfs;
	}
	public String getCjjg() {
		return cjjg;
	}
	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}
	public String getClbj() {
		return clbj;
	}
	public void setClbj(String clbj) {
		this.clbj = clbj;
	}
	public String getClsbdh() {
		return clsbdh;
	}
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	public String getZnj() {
		return znj;
	}
	public void setZnj(String znj) {
		this.znj = znj;
	}
	public String getWsjkbj() {
		return wsjkbj;
	}
	public void setWsjkbj(String wsjkbj) {
		this.wsjkbj = wsjkbj;
	}
	public String getClfs() {
		return clfs;
	}
	public void setClfs(String clfs) {
		this.clfs = clfs;
	}
	public String getTzsh() {
		return tzsh;
	}
	public void setTzsh(String tzsh) {
		this.tzsh = tzsh;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getBeginNum() {
		beginNum =  (page-1)*pageSize;
		return beginNum;
	}
	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getEndNum() {
		endNum = ((page-1)*pageSize)+pageSize;
		return endNum;
	}
}
