package com.ehualu.rise.pojo.violate;

import java.io.Serializable;
import java.util.Date;

/**
 * 机动车
 * @author Administrator
 *
 */
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String xh;//机动车序号
	private String  hpzl;//号牌种类
	private String  hphm;//号牌号码
	private String  clpp1;//中文品牌
	private String  clxh;//车辆型号 
	private String  clsbdh;//车辆识别代号 
	private String  fdjh;//发动机号 
	private String  cllx;//车辆类型 
	private String  csys;//车身颜色 
	private String  syxz;//使用性质 
	private String  syr;//机动车所有人 
	private Date  ccdjrq;//初次登记日期 
	private Date  yxqz;//检验有效期止 
	private Date  qzbfqz;//强制报废期止 
	private String  zt;//机动车状态 
	private String  fdjxh;//发动机型号 
	private String  rlzl;//燃料种类 
	private double  pl;//排量 
	private double  gl;//功率 
	private double  zs;//轴数 
	private double  zj;//轴距 
	private double  qlj;//前轮距 
	private double  hlj;//后轮距 
	private double  lts;//轮胎数 
	private double  zzl;//总质量 
	private double  zbzl;//整备质量 
	private double  hdzzl;//核定载质量 
	private double  hdzk;//核定载客 
	private Date  ccrq;//出厂日期 
	private int dybj = 0;//抵押标记
	private String vehicleBrandUri;//车辆品牌Uri
	
	
	public String getVehicleBrandUri() {
		return vehicleBrandUri;
	}

	public void setVehicleBrandUri(String vehicleBrandUri) {
		this.vehicleBrandUri = vehicleBrandUri;
	}

	public int getDybj() {
		return dybj;
	}

	public void setDybj(int dybj) {
		this.dybj = dybj;
	}

	public Vehicle(String xh, String hpzl, String hphm, String clpp1,
			String clxh, String clsbdh, String fdjh, String cllx, String csys,
			String syxz, String syr, Date ccdjrq, Date yxqz, Date qzbfqz,
			String zt, String fdjxh, String rlzl, double pl, double gl,
			double zs, double zj, double qlj, double hlj, double lts,
			double zzl, double zbzl, double hdzzl, double hdzk, Date ccrq) {
		super();
		this.xh = xh;
		this.hpzl = hpzl;
		this.hphm = hphm;
		this.clpp1 = clpp1;
		this.clxh = clxh;
		this.clsbdh = clsbdh;
		this.fdjh = fdjh;
		this.cllx = cllx;
		this.csys = csys;
		this.syxz = syxz;
		this.syr = syr;
		this.ccdjrq = ccdjrq;
		this.yxqz = yxqz;
		this.qzbfqz = qzbfqz;
		this.zt = zt;
		this.fdjxh = fdjxh;
		this.rlzl = rlzl;
		this.pl = pl;
		this.gl = gl;
		this.zs = zs;
		this.zj = zj;
		this.qlj = qlj;
		this.hlj = hlj;
		this.lts = lts;
		this.zzl = zzl;
		this.zbzl = zbzl;
		this.hdzzl = hdzzl;
		this.hdzk = hdzk;
		this.ccrq = ccrq;
	}
	
	public Vehicle() {
		super();
	}


	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
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
	public String getClpp1() {
		return clpp1;
	}
	public void setClpp1(String clpp1) {
		this.clpp1 = clpp1;
	}
	public String getClxh() {
		return clxh;
	}
	public void setClxh(String clxh) {
		this.clxh = clxh;
	}
	public String getClsbdh() {
		return clsbdh;
	}
	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}
	public String getFdjh() {
		return fdjh;
	}
	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getSyxz() {
		return syxz;
	}
	public void setSyxz(String syxz) {
		this.syxz = syxz;
	}
	public String getSyr() {
		return syr;
	}
	public void setSyr(String syr) {
		this.syr = syr;
	}
	public Date getCcdjrq() {
		return ccdjrq;
	}
	public void setCcdjrq(Date ccdjrq) {
		this.ccdjrq = ccdjrq;
	}
	public Date getYxqz() {
		return yxqz;
	}
	public void setYxqz(Date yxqz) {
		this.yxqz = yxqz;
	}
	public Date getQzbfqz() {
		return qzbfqz;
	}
	public void setQzbfqz(Date qzbfqz) {
		this.qzbfqz = qzbfqz;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getFdjxh() {
		return fdjxh;
	}
	public void setFdjxh(String fdjxh) {
		this.fdjxh = fdjxh;
	}
	public String getRlzl() {
		return rlzl;
	}
	public void setRlzl(String rlzl) {
		this.rlzl = rlzl;
	}
	public double getPl() {
		return pl;
	}
	public void setPl(double pl) {
		this.pl = pl;
	}
	public double getGl() {
		return gl;
	}
	public void setGl(double gl) {
		this.gl = gl;
	}
	public double getZs() {
		return zs;
	}
	public void setZs(double zs) {
		this.zs = zs;
	}
	public double getZj() {
		return zj;
	}
	public void setZj(double zj) {
		this.zj = zj;
	}
	public double getQlj() {
		return qlj;
	}
	public void setQlj(double qlj) {
		this.qlj = qlj;
	}
	public double getHlj() {
		return hlj;
	}
	public void setHlj(double hlj) {
		this.hlj = hlj;
	}
	public double getLts() {
		return lts;
	}
	public void setLts(double lts) {
		this.lts = lts;
	}
	public double getZzl() {
		return zzl;
	}
	public void setZzl(double zzl) {
		this.zzl = zzl;
	}
	public double getZbzl() {
		return zbzl;
	}
	public void setZbzl(double zbzl) {
		this.zbzl = zbzl;
	}
	public double getHdzzl() {
		return hdzzl;
	}
	public void setHdzzl(double hdzzl) {
		this.hdzzl = hdzzl;
	}
	public double getHdzk() {
		return hdzk;
	}
	public void setHdzk(double hdzk) {
		this.hdzk = hdzk;
	}
	public Date getCcrq() {
		return ccrq;
	}
	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}
	
}
