package com.wondersgroup.materiel.centreTimer.vo;

public class MaterielBigclass_cen {
    private int rkey;

    private String groupName;

    private String grpCode;

    private Short erpStatus;


    public int getRkey() {
		return rkey;
	}

	public void setRkey(int rkey) {
		this.rkey = rkey;
	}

	public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGrpCode() {
        return grpCode;
    }

    public void setGrpCode(String grpCode) {
        this.grpCode = grpCode == null ? null : grpCode.trim();
    }

    public Short getErpStatus() {
        return erpStatus;
    }

    public void setErpStatus(Short erpStatus) {
        this.erpStatus = erpStatus;
    }
}