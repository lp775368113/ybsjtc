package com.wondersgroup.materiel.bomsys.ecn.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MaterielBomEcn {
    private Integer id;

    private String cutDate;

    private String theme;

    private String tryto;

    private String why;

    private String summarize;

    private String remark;

    private Integer userid;

    private String checkStatus;

    private Date createTime;

    private Date checkTime;

    private String removed;
    
    private List<Map<String,Object>> edit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCutDate() {
        return cutDate;
    }

    public void setCutDate(String cutDate) {
        this.cutDate = cutDate == null ? null : cutDate.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getTryto() {
        return tryto;
    }

    public void setTryto(String tryto) {
        this.tryto = tryto == null ? null : tryto.trim();
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why == null ? null : why.trim();
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize == null ? null : summarize.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }

	public List<Map<String, Object>> getEdit() {
		return edit;
	}

	public void setEdit(List<Map<String, Object>> edit) {
		this.edit = edit;
	}
}