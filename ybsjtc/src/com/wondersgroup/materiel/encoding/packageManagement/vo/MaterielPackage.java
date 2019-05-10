package com.wondersgroup.materiel.encoding.packageManagement.vo;

import java.util.Date;

public class MaterielPackage {
    private Integer id;

    private String packagename;

    private String process;

    private String description;

    private String icon1;

    private String icon2;

    private String icon3;

    private String icon4;

    private String icon5;

    private Integer createuserid;

    private Date createtime;

    private String removed;
    
    private String action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename == null ? null : packagename.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1 == null ? null : icon1.trim();
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2 == null ? null : icon2.trim();
    }

    public String getIcon3() {
        return icon3;
    }

    public void setIcon3(String icon3) {
        this.icon3 = icon3 == null ? null : icon3.trim();
    }

    public String getIcon4() {
        return icon4;
    }

    public void setIcon4(String icon4) {
        this.icon4 = icon4 == null ? null : icon4.trim();
    }

    public String getIcon5() {
        return icon5;
    }

    public void setIcon5(String icon5) {
        this.icon5 = icon5 == null ? null : icon5.trim();
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
    
}