package com.wondersgroup.materiel.centreTimer.vo;

import java.util.Date;

public class Data {
    private int id;

    private int rkey;

    private int erpStatus;

    private String invPartNumber;
    
    private String ttype;

    private String extraDesc;

    private String prodCodeSellPtr;

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

    private String peVersionDate;

    private String peVersion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRkey() {
		return rkey;
	}

	public void setRkey(int rkey) {
		this.rkey = rkey;
	}

	public int getErpStatus() {
		return erpStatus;
	}

	public void setErpStatus(int erpStatus) {
		this.erpStatus = erpStatus;
	}

	public String getInvPartNumber() {
		return invPartNumber;
	}

	public void setInvPartNumber(String invPartNumber) {
		this.invPartNumber = invPartNumber;
	}

	public String getExtraDesc() {
		return extraDesc;
	}

	public void setExtraDesc(String extraDesc) {
		this.extraDesc = extraDesc;
	}

	public String getProdCodeSellPtr() {
		return prodCodeSellPtr;
	}

	public void setProdCodeSellPtr(String prodCodeSellPtr) {
		this.prodCodeSellPtr = prodCodeSellPtr;
	}

	public String getProdSupper() {
		return prodSupper;
	}

	public void setProdSupper(String prodSupper) {
		this.prodSupper = prodSupper;
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
		this.smtFlag = smtFlag;
	}

	public String getInvPartDescriptionC() {
		return invPartDescriptionC;
	}

	public void setInvPartDescriptionC(String invPartDescriptionC) {
		this.invPartDescriptionC = invPartDescriptionC;
	}

	public String getCustPartName() {
		return custPartName;
	}

	public void setCustPartName(String custPartName) {
		this.custPartName = custPartName;
	}

	public String getCustPartCode() {
		return custPartCode;
	}

	public void setCustPartCode(String custPartCode) {
		this.custPartCode = custPartCode;
	}

	public String getPurchUnitPtr() {
		return purchUnitPtr;
	}

	public void setPurchUnitPtr(String purchUnitPtr) {
		this.purchUnitPtr = purchUnitPtr;
	}

	public String getStockUnitPtr() {
		return stockUnitPtr;
	}

	public void setStockUnitPtr(String stockUnitPtr) {
		this.stockUnitPtr = stockUnitPtr;
	}

	public String getSupplierPtr() {
		return supplierPtr;
	}

	public void setSupplierPtr(String supplierPtr) {
		this.supplierPtr = supplierPtr;
	}

	public String getStdCost() {
		return stdCost;
	}

	public void setStdCost(String stdCost) {
		this.stdCost = stdCost;
	}

	public String getStockPurch() {
		return stockPurch;
	}

	public void setStockPurch(String stockPurch) {
		this.stockPurch = stockPurch;
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
	

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", rkey=" + rkey + ", erpStatus=" + erpStatus + ", invPartNumber=" + invPartNumber
				+ ", extraDesc=" + extraDesc + ", prodCodeSellPtr=" + prodCodeSellPtr + ", prodSupper=" + prodSupper
				+ ", package_=" + package_ + ", smtFlag=" + smtFlag + ", invPartDescriptionC=" + invPartDescriptionC
				+ ", custPartName=" + custPartName + ", custPartCode=" + custPartCode + ", purchUnitPtr=" + purchUnitPtr
				+ ", stockUnitPtr=" + stockUnitPtr + ", supplierPtr=" + supplierPtr + ", stdCost=" + stdCost
				+ ", stockPurch=" + stockPurch + ", peVersionDate=" + peVersionDate + ", peVersion=" + peVersion + "]";
	}

    
}