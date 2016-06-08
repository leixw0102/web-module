package com.ehualu.rise.pojo.violate;

import java.io.Serializable;
/**
 * 驾驶证违法加密数据
 * @author Administrator
 *
 */
public class ViolationEn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5828753949397411901L;

	private String wfbh;//违法编号
	private String jdslb;//决定书类别
	private String jdsbh;//决定书编号
	private String wsjyw;//文书校验位
	private String ryfl;//人员分类
	private String jszh;//驾驶证号
	private String dabh;//档案编号
	private String fzjg;//发证机关
	private String zjcx;//准驾车型
	private String dsr;//当事人
	private String zsxzqh;//住所行政区划
	private String zsxxdz;//住所详细地址
	private String dh;//电话
	private String lxfs;//联系方式
	private String clfl;//车辆分类
	private String hpzl;//号牌种类
	private String hphm;//号牌号码
	private String jdcsyr;//机动车所有人
	private String syxz;//机动车使用性质
	private String jtfs;//交通方式
	private String wfsj;//违法时间
	private String wfdd;//违法地点
	private String wfdz;//违法地址
	private String wfxw;//违法行为
	private String wfjfs;//违法记分数
	private String fkje;//罚款金额
	private String scz;//实测值
	private String bzz;//标准值
	private String znj;//滞纳金
	private String zqmj;//执勤民警
	private String jkfs;//交款方式
	private String fxjg;//发现机关
	private String fxjgmc;//发现机关名称
	private String cljg;//处理机关
	private String cljgmc;//处理机关名称
	private String cfzl;//处罚种类
	private String clsj;//处理时间
	private String jkbj;//交款标记
	private String jkrq;//交款日期
	private String pzbh;//强制措施凭证号
	private String jsjqbj;//拒收拒签标记
	private String jllx;//记录类型
	private String lrr;//录入人
	private String lrsj;//录入时间
	private String jbr1;//经办人1
	private String jbr2;//经办人2
	private String sgdj;//事故等级 code61
	private String xxly;//信息来源 1-现场处罚，2-非现场处罚
	private String xrms;//写入模式 1-系统写入;2-接口写入;3-内部其他系统写入
	private String jsjg;//接受机关
	private String gxsj;//更新时间
	private String bz;//备注
	
	private int page;//页数
	
	private int pageSize;//每页条数
	
	private int endNum;//结束个数
	
	private int beginNum;//开始个数
	
	
	public String getWfbh() {
		return wfbh;
	}
	public void setWfbh(String wfbh) {
		this.wfbh = wfbh;
	}
	public String getJdslb() {
		return jdslb;
	}
	public void setJdslb(String jdslb) {
		this.jdslb = jdslb;
	}
	public String getJdsbh() {
		return jdsbh;
	}
	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}
	public String getWsjyw() {
		return wsjyw;
	}
	public void setWsjyw(String wsjyw) {
		this.wsjyw = wsjyw;
	}
	public String getRyfl() {
		return ryfl;
	}
	public void setRyfl(String ryfl) {
		this.ryfl = ryfl;
	}
	public String getJszh() {
		return jszh;
	}
	public void setJszh(String jszh) {
		this.jszh = jszh;
	}
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getZjcx() {
		return zjcx;
	}
	public void setZjcx(String zjcx) {
		this.zjcx = zjcx;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getZsxzqh() {
		return zsxzqh;
	}
	public void setZsxzqh(String zsxzqh) {
		this.zsxzqh = zsxzqh;
	}
	public String getZsxxdz() {
		return zsxxdz;
	}
	public void setZsxxdz(String zsxxdz) {
		this.zsxxdz = zsxxdz;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getClfl() {
		return clfl;
	}
	public void setClfl(String clfl) {
		this.clfl = clfl;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getJdcsyr() {
		return jdcsyr;
	}
	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}
	public String getSyxz() {
		return syxz;
	}
	public void setSyxz(String syxz) {
		this.syxz = syxz;
	}
	public String getJtfs() {
		return jtfs;
	}
	public void setJtfs(String jtfs) {
		this.jtfs = jtfs;
	}
	public String getWfsj() {
		return wfsj;
	}
	public void setWfsj(String wfsj) {
		this.wfsj = wfsj;
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
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public String getWfjfs() {
		return wfjfs;
	}
	public void setWfjfs(String wfjfs) {
		this.wfjfs = wfjfs;
	}
	public String getFkje() {
		return fkje;
	}
	public void setFkje(String fkje) {
		this.fkje = fkje;
	}
	public String getScz() {
		return scz;
	}
	public void setScz(String scz) {
		this.scz = scz;
	}
	public String getBzz() {
		return bzz;
	}
	public void setBzz(String bzz) {
		this.bzz = bzz;
	}
	public String getZnj() {
		return znj;
	}
	public void setZnj(String znj) {
		this.znj = znj;
	}
	public String getZqmj() {
		return zqmj;
	}
	public void setZqmj(String zqmj) {
		this.zqmj = zqmj;
	}
	public String getJkfs() {
		return jkfs;
	}
	public void setJkfs(String jkfs) {
		this.jkfs = jkfs;
	}
	public String getFxjg() {
		return fxjg;
	}
	public void setFxjg(String fxjg) {
		this.fxjg = fxjg;
	}
	public String getFxjgmc() {
		return fxjgmc;
	}
	public void setFxjgmc(String fxjgmc) {
		this.fxjgmc = fxjgmc;
	}
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	public String getCljgmc() {
		return cljgmc;
	}
	public void setCljgmc(String cljgmc) {
		this.cljgmc = cljgmc;
	}
	public String getCfzl() {
		return cfzl;
	}
	public void setCfzl(String cfzl) {
		this.cfzl = cfzl;
	}
	public String getClsj() {
		return clsj;
	}
	public void setClsj(String clsj) {
		this.clsj = clsj;
	}
	public String getJkbj() {
		return jkbj;
	}
	public void setJkbj(String jkbj) {
		this.jkbj = jkbj;
	}
	public String getJkrq() {
		return jkrq;
	}
	public void setJkrq(String jkrq) {
		this.jkrq = jkrq;
	}
	public String getPzbh() {
		return pzbh;
	}
	public void setPzbh(String pzbh) {
		this.pzbh = pzbh;
	}
	public String getJsjqbj() {
		return jsjqbj;
	}
	public void setJsjqbj(String jsjqbj) {
		this.jsjqbj = jsjqbj;
	}
	public String getJllx() {
		return jllx;
	}
	public void setJllx(String jllx) {
		this.jllx = jllx;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	public String getJbr1() {
		return jbr1;
	}
	public void setJbr1(String jbr1) {
		this.jbr1 = jbr1;
	}
	public String getJbr2() {
		return jbr2;
	}
	public void setJbr2(String jbr2) {
		this.jbr2 = jbr2;
	}
	public String getSgdj() {
		return sgdj;
	}
	public void setSgdj(String sgdj) {
		this.sgdj = sgdj;
	}
	public String getXxly() {
		return xxly;
	}
	public void setXxly(String xxly) {
		this.xxly = xxly;
	}
	public String getXrms() {
		return xrms;
	}
	public void setXrms(String xrms) {
		this.xrms = xrms;
	}
	public String getJsjg() {
		return jsjg;
	}
	public void setJsjg(String jsjg) {
		this.jsjg = jsjg;
	}
	public String getGxsj() {
		return gxsj;
	}
	public void setGxsj(String gxsj) {
		this.gxsj = gxsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
