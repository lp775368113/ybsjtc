package com.wondersgroup.framework.upms.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wondersgroup.framework.upms.comm.CommJson;
import com.wondersgroup.framework.upms.util.SecureUtil;
import com.wondersgroup.framework.upms.util.SecureUtil.ChpMode;
import com.wondersgroup.framework.upms.comm.ErrorMessage;

public class SysUtil {
	protected static Logger logger = LoggerFactory.getLogger(SysUtil.class);

	public static CommJson decryptParam(String sysid, String req, String key) {
		CommJson ret = new CommJson();
		if (StringUtils.isNoneBlank(sysid) && StringUtils.isNoneBlank(req)) {
			if (StringUtils.isNoneBlank(key)) {
				try {
					key = SecureUtil.MD5Encode(sysid + key);
					ret.setResult(SecureUtil.decrypt(ChpMode.AES_CBC_P5, req, key));
					ret.setSuc();
				} catch (Exception e) {
					logger.error("decryptParam==>", e);
					ret.setError();
					ret.setMsg(ErrorMessage.ERR_AUTH);
					ret.setCode("1002");
				}
			} else {
				ret.setError();
				ret.setMsg(ErrorMessage.SYS_UNAUTH);
				ret.setCode("1003");
			}
		} else {
			ret.setError();
			ret.setMsg(ErrorMessage.ERR_UNLEGAL_PARAM);
			ret.setCode("1001");
		}

		return ret;
	}

	public static String encryptResp(String sysid, String resp, String key) {
		String ret = "";
		if (StringUtils.isNoneBlank(sysid) && StringUtils.isNoneBlank(resp)) {
			if (StringUtils.isNoneBlank(key)) {
				try {
					key = SecureUtil.MD5Encode(sysid + key);
					ret = SecureUtil.encrypt(ChpMode.AES_CBC_P5, resp, key);
				} catch (Exception e) {
					logger.error("encryptResp==>", e);
				}
			}
		}

		return ret;
	}
}
