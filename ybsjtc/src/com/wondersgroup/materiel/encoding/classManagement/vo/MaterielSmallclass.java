package com.wondersgroup.materiel.encoding.classManagement.vo;

public class MaterielSmallclass {
    private Integer id;
    
    private String bigcode;

    private Integer bigclassid;

    private String code;

    private String classname;

    private String rules;

    private String remark;

    private String removed;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBigclassid() {
        return bigclassid;
    }

    public void setBigclassid(Integer bigclassid) {
        this.bigclassid = bigclassid;
    }
    

    public String getBigcode() {
		return bigcode;
	}

	public void setBigcode(String bigcode) {
		this.bigcode = bigcode;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}