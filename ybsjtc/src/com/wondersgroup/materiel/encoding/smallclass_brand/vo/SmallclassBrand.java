package com.wondersgroup.materiel.encoding.smallclass_brand.vo;

public class SmallclassBrand {
    private Integer id;

    private Integer smallclassid;

    private Integer brandid;

    private String removed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallclassid() {
        return smallclassid;
    }

    public void setSmallclassid(Integer smallclassid) {
        this.smallclassid = smallclassid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }
}