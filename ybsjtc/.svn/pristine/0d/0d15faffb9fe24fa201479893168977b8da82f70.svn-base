package com.wondersgroup.framework.upms.service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import com.wondersgroup.framework.upms.comm.CommJson;
import com.wondersgroup.framework.upms.util.SecureUtil;
import com.wondersgroup.framework.upms.util.SecureUtil.ChpMode;
import com.wondersgroup.framework.upms.comm.ErrorMessage;
import com.wondersgroup.framework.upms.util.SysUtil;
import com.wondersgroup.framework.upms.util.UasUtil;
import com.wondersgroup.framework.upms.vo.UasFuncVO;
import com.wondersgroup.framework.upms.vo.UasJson;
import com.wondersgroup.framework.upms.vo.UasMenuVO;

public class UasUserService {
	protected static Logger logger = LoggerFactory.getLogger(UasUserService.class);

	/**
	 * 获取用户菜单
	 * 
	 * @param userid
	 * @param sysid
	 * @return
	 */
	public static List<UasMenuVO> getMenu(String url, String userid, String authlevel, String sysid, String key) {
		List<UasMenuVO> ret = new ArrayList<UasMenuVO>();

		if (StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(userid) && StringUtils.isNoneBlank(sysid)) {
			try {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("userid", userid);
				url = String.format("%s/menu/getmenu?sysid=%s&req=%s", url, sysid,
						SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
				String getret = UasUtil.httpGet(url);

				if (StringUtils.isNoneBlank(getret)) {
					UasJson getJson = JSON.parseObject(getret, UasJson.class);
					if ("1".equals(getJson.getRet())) {
						if (StringUtils.isNoneBlank(getJson.getResult().toString())) {
							CommJson j = SysUtil.decryptParam(sysid, getJson.getResult().toString(), key);
							if ("1".equals(j.getRet()))
								ret = JSON.parseArray(j.getResult().toString(), UasMenuVO.class);
							else {
								logger.warn("getMenu==>" + j.getMsg());
							}
						}
					} else {
						logger.warn("getMenu==>" + getJson.getMsg());
					}
				}
			} catch (Exception err) {
				logger.error("getMenu==>", err);
			}
		} else {
			logger.warn("getMenu==>传入参数非法");
		}

		return ret;
	}

	public static List<UasFuncVO> getFunc(String url, String userid, String sysid, String key) {
		List<UasFuncVO> ret = new ArrayList<UasFuncVO>();

		if (StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(userid) && StringUtils.isNoneBlank(sysid)) {
			try {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("userid", userid);
				url = String.format("%s/func/getfunc?sysid=%s&req=%s", url, sysid,
						SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
				System.out.println(url);
				String getret = UasUtil.httpGet(url);

				if (StringUtils.isNoneBlank(getret)) {
					UasJson getJson = JSON.parseObject(getret, UasJson.class);
					if ("1".equals(getJson.getRet())) {
						if (StringUtils.isNoneBlank(getJson.getResult().toString())) {
							CommJson j = SysUtil.decryptParam(sysid, getJson.getResult().toString(), key);
							if ("1".equals(j.getRet())) {
								System.out.println(URLDecoder.decode(getJson.getResult().toString(), "UTF-8"));
								ret = JSON.parseArray(URLDecoder.decode(j.getResult().toString(), "UTF-8"),
										UasFuncVO.class);
							}else {
								logger.warn("getFunc==>" + j.getMsg());
							}
						}

					} else {
						logger.warn("getMenu==>" + getJson.getMsg());
					}
				}
			} catch (Exception err) {
				logger.error("getMenu==>", err);
			}
		} else {
			logger.warn("getMenu==>传入参数非法");
		}

		return ret;
	}

	public static CommJson login(String url, String sysid, String key, String loginid, String loginpwd) {
		CommJson ret = new CommJson();

		if (StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(key) && StringUtils.isNoneBlank(sysid)
				&& StringUtils.isNoneBlank(loginid) && StringUtils.isNoneBlank(loginpwd)) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("loginid", loginid);
			try {
				map.put("loginpwd", SecureUtil.encrypt(ChpMode.SHA256, loginpwd, ""));
			} catch (Exception e) {
				e.printStackTrace();
			}
			url = String.format("%s/login/?sysid=%s&req=%s", url, sysid,
					SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
			String getret = UasUtil.httpGet(url);
			if (StringUtils.isNoneBlank(getret)) {
				ret = JSON.parseObject(getret, CommJson.class);
				if ("1".equals(ret.getRet())) {
					if (StringUtils.isNoneBlank(ret.getResult().toString())) {
						CommJson j = SysUtil.decryptParam(sysid, ret.getResult().toString(), key);
						if ("1".equals(j.getRet())) {
							ret.setSuc();
							ret.setResult(j.getResult());
						} else {
							ret = j;
						}
					}
				} else {
					logger.warn("login==>" + ret.getMsg());
				}
			}
		} else {
			ret.setError();
			ret.setMsg(ErrorMessage.ERR_UNLEGAL_PARAM);
		}

		return ret;
	}

	public static boolean checkLogin(String url, String userid, String sysid, String key) {
		boolean ret = false;

		if (StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(userid) && StringUtils.isNoneBlank(sysid)) {
			try {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("userid", userid);
				url = String.format("%s/login/checklogin?sysid=%s&req=%s", url, sysid,
						SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
				String getret = UasUtil.httpGet(url);

				if (StringUtils.isNoneBlank(getret)) {
					UasJson getJson = JSON.parseObject(getret, UasJson.class);
					if ("1".equals(getJson.getRet())) {
						CommJson j = SysUtil.decryptParam(sysid, getJson.getResult().toString(), key);
						if ("1".equals(j.getRet()))
							ret = Boolean.parseBoolean(getJson.getResult().toString());
						else {
							logger.warn("checkLogin==>" + j.getMsg());
						}
					} else {
						logger.warn("checkLogin==>" + getJson.getMsg());
					}
				}
			} catch (Exception err) {
				logger.error("checkLogin==>", err);
			}
		} else {
			logger.warn("checkLogin==>传入参数非法");
		}

		return ret;
	}

	public static String gethdImgurl(String url, String userid, String sysid, String key) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		return String.format("%s/user/userimg?sysid=%s&req=%s", url, sysid,
				SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
	}
	public static CommJson changePwd(String url, String sysid, String key,
			String userid, String loginpwd, String newpwd) {
		CommJson ret = new CommJson();

		if (StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(key)
				&& StringUtils.isNoneBlank(sysid)
				&& StringUtils.isNoneBlank(userid)
				&& StringUtils.isNoneBlank(loginpwd)
				&& StringUtils.isNoneBlank(newpwd)) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("uid", userid);
			try {
				map.put("opwd", loginpwd);
				map.put("npwd", newpwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			url = String.format("%s/user/changepwd?sysid=%s&req=%s", url, sysid,
					SysUtil.encryptResp(sysid, JSON.toJSONString(map), key));
			String getret = UasUtil.httpGet(url);
			if (StringUtils.isNoneBlank(getret)) {
				ret = JSON.parseObject(getret, CommJson.class);
				if ("1".equals(ret.getRet())) {
					ret.setSuc();
				} else {
					logger.warn("login==>" + ret.getMsg());
				}
			}
		} else {
			ret.setError();
			ret.setMsg(ErrorMessage.ERR_UNLEGAL_PARAM);
		}

		return ret;
	}
}
