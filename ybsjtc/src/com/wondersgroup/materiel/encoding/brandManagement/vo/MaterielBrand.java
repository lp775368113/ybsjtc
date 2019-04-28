package com.wondersgroup.materiel.encoding.brandManagement.vo;

public class MaterielBrand {
    private Integer id;

    private String brandname;

    private String remark;

    private String removed;

    private String status;
    
    private String _state;
    
    public String get_state() {
		return _state;
	}

	public void set_state(String _state) {
		this._state = _state;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
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