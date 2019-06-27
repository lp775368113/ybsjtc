package com.wondersgroup.materiel.bomsys.bom.vo;

import java.util.Date;

public class MaterielBom {
    private Integer id;
    
    private Integer ecnid;
    
    private Integer infoid;

    private Integer productid;

    private String custPartCode;

    private String package_;

    private String prodSupper;

    private String invPartDescriptionC;

    private Integer how;

    private String stockUnitPtr;

    private String smtFlag;

    private String bomType;

    private String invPartNumber;

    private String extraDesc;

    private String prodCodeSellPtr;

    private String purchUnitPtr;

    private Date editTime;

    private Integer editUserid;

    private String top;

    private String bottom;

    private Integer version;
    
    private String refdes;
    
    private String sym_mirror;
    
    private String prodCodeSellPtrStr;
    
    private String prodSupperStr;
    
    private String package_Str;
    
    private String smtFlagStr; 
    
    private String editUseridStr; 
    
    private String _state;
    
    private String operation;
    
    private String replacecode;

    private Boolean isLeaf;
    
    private Boolean expanded;
    
    public Integer getId() {
        return id;
    }
    

    public Integer getEcnid() {
		return ecnid;
	}



	public void setEcnid(Integer ecnid) {
		this.ecnid = ecnid;
	}



	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoid() {
		return infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}

	public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getCustPartCode() {
        return custPartCode;
    }

    public void setCustPartCode(String custPartCode) {
        this.custPartCode = custPartCode == null ? null : custPartCode.trim();
    }


    public String getPackage_() {
		return package_;
	}

	public void setPackage_(String package_) {
		this.package_ = package_;
	}

	public String getPackage_Str() {
		return package_Str;
	}

	public void setPackage_Str(String package_Str) {
		this.package_Str = package_Str;
	}

	public String getProdSupper() {
        return prodSupper;
    }

    public void setProdSupper(String prodSupper) {
        this.prodSupper = prodSupper == null ? null : prodSupper.trim();
    }

    public String getInvPartDescriptionC() {
        return invPartDescriptionC;
    }

    public void setInvPartDescriptionC(String invPartDescriptionC) {
        this.invPartDescriptionC = invPartDescriptionC == null ? null : invPartDescriptionC.trim();
    }

    public Integer getHow() {
        return how;
    }

    public void setHow(Integer how) {
        this.how = how;
    }

    public String getStockUnitPtr() {
        return stockUnitPtr;
    }

    public void setStockUnitPtr(String stockUnitPtr) {
        this.stockUnitPtr = stockUnitPtr == null ? null : stockUnitPtr.trim();
    }

    public String getSmtFlag() {
        return smtFlag;
    }

    public void setSmtFlag(String smtFlag) {
        this.smtFlag = smtFlag == null ? null : smtFlag.trim();
    }

    public String getBomType() {
        return bomType;
    }

    public void setBomType(String bomType) {
        this.bomType = bomType == null ? null : bomType.trim();
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

    public String getPurchUnitPtr() {
        return purchUnitPtr;
    }

    public void setPurchUnitPtr(String purchUnitPtr) {
        this.purchUnitPtr = purchUnitPtr == null ? null : purchUnitPtr.trim();
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getEditUserid() {
        return editUserid;
    }

    public void setEditUserid(Integer editUserid) {
        this.editUserid = editUserid;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom == null ? null : bottom.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

	public String getRefdes() {
		return refdes;
	}

	public void setRefdes(String refdes) {
		this.refdes = refdes;
	}

	public String getSym_mirror() {
		return sym_mirror;
	}

	public void setSym_mirror(String sym_mirror) {
		this.sym_mirror = sym_mirror;
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

	public String getSmtFlagStr() {
		return smtFlagStr;
	}

	public void setSmtFlagStr(String smtFlagStr) {
		this.smtFlagStr = smtFlagStr;
	}

	public String getEditUseridStr() {
		return editUseridStr;
	}

	public void setEditUseridStr(String editUseridStr) {
		this.editUseridStr = editUseridStr;
	}

	public String get_state() {
		return _state;
	}

	public void set_state(String _state) {
		this._state = _state;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getReplacecode() {
		return replacecode;
	}

	public void setReplacecode(String replacecode) {
		this.replacecode = replacecode;
	}

	public Boolean getIsLeaf() {
		if("1".equals(bomType)) {
			return true;
		}else {
			return false;
		}
		
	}

	public Boolean getExpanded() {
		return false;
	}

	@Override
	public String toString() {
		return "MaterielBom [id=" + id + ", infoid=" + infoid + ", productid=" + productid + ", custPartCode="
				+ custPartCode + ", package_=" + package_ + ", prodSupper=" + prodSupper + ", invPartDescriptionC="
				+ invPartDescriptionC + ", how=" + how + ", stockUnitPtr=" + stockUnitPtr + ", smtFlag=" + smtFlag
				+ ", bomType=" + bomType + ", invPartNumber=" + invPartNumber + ", extraDesc=" + extraDesc
				+ ", prodCodeSellPtr=" + prodCodeSellPtr + ", purchUnitPtr=" + purchUnitPtr + ", editTime=" + editTime
				+ ", editUserid=" + editUserid + ", top=" + top + ", bottom=" + bottom + ", version=" + version
				+ ", refdes=" + refdes + ", sym_mirror=" + sym_mirror + ", prodCodeSellPtrStr=" + prodCodeSellPtrStr
				+ ", prodSupperStr=" + prodSupperStr + ", package_Str=" + package_Str + ", smtFlagStr=" + smtFlagStr
				+ ", editUseridStr=" + editUseridStr + ", _state=" + _state + ", operation=" + operation
				+ ", replacecode=" + replacecode + ", isLeaf=" + isLeaf + ", expanded=" + expanded + "]";
	}

	
	
	
}