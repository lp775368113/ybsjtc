package com.wondersgroup.permission.button.vo;

import com.wondersgroup.framework.comwork.vo.BaseObject;

public class Button  extends BaseObject{
    private Integer id;

    private String buttonname;

    private String code;

    private String buttonid;

    private String description;

    private String removed;
    
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

    public String getButtonname() {
        return buttonname;
    }

    public void setButtonname(String buttonname) {
        this.buttonname = buttonname == null ? null : buttonname.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getButtonid() {
        return buttonid;
    }

    public void setButtonid(String buttonid) {
        this.buttonid = buttonid == null ? null : buttonid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }
}