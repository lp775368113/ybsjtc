package com.wondersgroup.materiel.encoding.vo;

import java.util.Date;

public class MaterielCheck {
    private Integer id;

    private Integer wlid;

    private Integer erpid;

    private String status;

    private String ttype;

    private String invPartNumber;

    private String extraDesc;

    private String prodCodeSellPtr;
    
    private String prodCodeSellPtrStr;
    
    private String prodSupperStr;
    
    private String package_Str;
    
    private String supplierPtrStr;

    private String prodSupper;

    private String package_;

    private String smtFlag;

    private String invPartDescriptionC;

    private String custPartName;

    private String custPartCode;

    private String purchUnitPtr;

    private String stockUnitPtr;

    private String supplierPtr;

    private String stdCost;

    private String stockPurch;

    private String remark;

    private Integer userid;

    private Date starttime;

    private Date endtime;
    
    private String fileidstr;
    
    private String filename;
    
    private String schematic;
    
    private String peVersionDate;
    
    private String peVersion;
    
    private String productType;
    
    public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPeVersionDate() {
		return peVersionDate;
	}

	public void setPeVersionDate(String peVersionDate) {
		this.peVersionDate = peVersionDate;
	}

	public String getPeVersion() {
		return peVersion;
	}

	public void setPeVersion(String peVersion) {
		this.peVersion = peVersion;
	}
    
    
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSchematic() {
		return schematic;
	}

	public void setSchematic(String schematic) {
		this.schematic = schematic;
	}

    public Integer getId() {
        return id;
    }

    public String getProdCodeSellPtrStr() {
		return prodCodeSellPtrStr;
	}

	public void setProdCodeSellPtrStr(String prodCodeSellPtrStr) {
		this.prodCodeSellPtrStr = prodCodeSellPtrStr;
	}

	public String getProdSupperStr() {
		return prodSupperStr;
	}

	public void setProdSupperStr(String prodSupperStr) {
		this.prodSupperStr = prodSupperStr;
	}

	public String getPackage_Str() {
		return package_Str;
	}

	public void setPackage_Str(String package_Str) {
		this.package_Str = package_Str;
	}

	public String getSupplierPtrStr() {
		return supplierPtrStr;
	}

	public void setSupplierPtrStr(String supplierPtrStr) {
		this.supplierPtrStr = supplierPtrStr;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWlid() {
        return wlid;
    }

    public void setWlid(Integer wlid) {
        this.wlid = wlid;
    }

    public Integer getErpid() {
        return erpid;
    }

    public void setErpid(Integer erpid) {
        this.erpid = erpid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype == null ? null : ttype.trim();
    }

    public String getInvPartNumber() {
        return invPartNumber;
    }

    public void setInvPartNumber(String invPartNumber) {
        this.invPartNumber = invPartNumber == null ? null : invPartNumber.trim();
    }

    public String getExtraDesc() {
        return extraDesc;
    }

    public void setExtraDesc(String extraDesc) {
        this.extraDesc = extraDesc == null ? null : extraDesc.trim();
    }

    public String getProdCodeSellPtr() {
        return prodCodeSellPtr;
    }

    public void setProdCodeSellPtr(String prodCodeSellPtr) {
        this.prodCodeSellPtr = prodCodeSellPtr == null ? null : prodCodeSellPtr.trim();
    }

    public String getProdSupper() {
        return prodSupper;
    }

    public void setProdSupper(String prodSupper) {
        this.prodSupper = prodSupper == null ? null : prodSupper.trim();
    }


    public String getPackage_() {
		return package_;
	}

	public void setPackage_(String package_) {
		this.package_ = package_;
	}

	public String getSmtFlag() {
        return smtFlag;
    }

    public void setSmtFlag(String smtFlag) {
        this.smtFlag = smtFlag == null ? null : smtFlag.trim();
    }

    public String getInvPartDescriptionC() {
        return invPartDescriptionC;
    }

    public void setInvPartDescriptionC(String invPartDescriptionC) {
        this.invPartDescriptionC = invPartDescriptionC == null ? null : invPartDescriptionC.trim();
    }

    public String getCustPartName() {
        return custPartName;
    }

    public void setCustPartName(String custPartName) {
        this.custPartName = custPartName == null ? null : custPartName.trim();
    }

    public String getCustPartCode() {
        return custPartCode;
    }

    public void setCustPartCode(String custPartCode) {
        this.custPartCode = custPartCode == null ? null : custPartCode.trim();
    }

    public String getPurchUnitPtr() {
        return purchUnitPtr;
    }

    public void setPurchUnitPtr(String purchUnitPtr) {
        this.purchUnitPtr = purchUnitPtr == null ? null : purchUnitPtr.trim();
    }

    public String getStockUnitPtr() {
        return stockUnitPtr;
    }

    public void setStockUnitPtr(String stockUnitPtr) {
        this.stockUnitPtr = stockUnitPtr == null ? null : stockUnitPtr.trim();
    }

    public String getSupplierPtr() {
        return supplierPtr;
    }

    public void setSupplierPtr(String supplierPtr) {
        this.supplierPtr = supplierPtr == null ? null : supplierPtr.trim();
    }

    public String getStdCost() {
        return stdCost;
    }

    public void setStdCost(String stdCost) {
        this.stdCost = stdCost == null ? null : stdCost.trim();
    }

    public String getStockPurch() {
        return stockPurch;
    }

    public void setStockPurch(String stockPurch) {
        this.stockPurch = stockPurch == null ? null : stockPurch.trim();
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

	public String getFileidstr() {
		return fileidstr;
	}

	public void setFileidstr(String fileidstr) {
		this.fileidstr = fileidstr;
	}

}