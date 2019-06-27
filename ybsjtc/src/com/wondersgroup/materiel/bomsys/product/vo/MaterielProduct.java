package com.wondersgroup.materiel.bomsys.product.vo;

import java.util.Date;

public class MaterielProduct {
    private Integer id;

    private String productCode;

    private String productName;

    private String ptype;

    private String smallclass;

    private String unitCost;

    private String compensation;

    private String newCost;

    private String purchUnit;

    private String stockUnit;

    private String smtFlag;

    private Integer createUserid;

    private Date createtime;

    private Integer updateUserid;

    private Date updatetime;

    private String removed;
    
    private String ptypeStr;
    
    private String smallclassStr;
    
    private String createName;
    
    private String updateName;

    private String action;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype == null ? null : ptype.trim();
    }

    public String getSmallclass() {
        return smallclass;
    }

    public void setSmallclass(String smallclass) {
        this.smallclass = smallclass == null ? null : smallclass.trim();
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost == null ? null : unitCost.trim();
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation == null ? null : compensation.trim();
    }

    public String getNewCost() {
        return newCost;
    }

    public void setNewCost(String newCost) {
        this.newCost = newCost == null ? null : newCost.trim();
    }

    public String getPurchUnit() {
        return purchUnit;
    }

    public void setPurchUnit(String purchUnit) {
        this.purchUnit = purchUnit == null ? null : purchUnit.trim();
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit == null ? null : stockUnit.trim();
    }

    public String getSmtFlag() {
        return smtFlag;
    }

    public void setSmtFlag(String smtFlag) {
        this.smtFlag = smtFlag == null ? null : smtFlag.trim();
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }

	public String getPtypeStr() {
		return ptypeStr;
	}

	public void setPtypeStr(String ptypeStr) {
		this.ptypeStr = ptypeStr;
	}

	public String getSmallclassStr() {
		return smallclassStr;
	}

	public void setSmallclassStr(String smallclassStr) {
		this.smallclassStr = smallclassStr;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
}