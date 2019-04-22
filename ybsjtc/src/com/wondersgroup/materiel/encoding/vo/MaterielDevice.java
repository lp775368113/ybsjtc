package com.wondersgroup.materiel.encoding.vo;

public class MaterielDevice { 
	private String rkey;
	
    private String largeclass;

    private String largeclassname;

    private String smallclass;

    private String smallclassname;

    private String smallinformation;

    private String manufacturer;

    private String erpcode;

    private String valid;
    

    public String getRkey() {
		return rkey;
	}

	public void setRkey(String rkey) {
		this.rkey = rkey;
	}

	public String getLargeclass() {
        return largeclass;
    }

    public void setLargeclass(String largeclass) {
        this.largeclass = largeclass == null ? null : largeclass.trim();
    }

    public String getLargeclassname() {
        return largeclassname;
    }

    public void setLargeclassname(String largeclassname) {
        this.largeclassname = largeclassname == null ? null : largeclassname.trim();
    }

    public String getSmallclass() {
        return smallclass;
    }

    public void setSmallclass(String smallclass) {
        this.smallclass = smallclass == null ? null : smallclass.trim();
    }

    public String getSmallclassname() {
        return smallclassname;
    }

    public void setSmallclassname(String smallclassname) {
        this.smallclassname = smallclassname == null ? null : smallclassname.trim();
    }

    public String getSmallinformation() {
        return smallinformation;
    }

    public void setSmallinformation(String smallinformation) {
        this.smallinformation = smallinformation == null ? null : smallinformation.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getErpcode() {
        return erpcode;
    }

    public void setErpcode(String erpcode) {
        this.erpcode = erpcode == null ? null : erpcode.trim();
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }
}