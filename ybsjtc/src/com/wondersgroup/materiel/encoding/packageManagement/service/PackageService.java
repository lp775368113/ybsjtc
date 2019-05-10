package com.wondersgroup.materiel.encoding.packageManagement.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.util.Base64Util;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielBigclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.dao.MaterielSmallclassMapper;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.packageManagement.dao.MaterielPackageMapper;
import com.wondersgroup.materiel.encoding.packageManagement.vo.MaterielPackage;
import com.wondersgroup.materiel.encoding.vo.MaterielFile;
import com.wondersgroup.permission.user.vo.User;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.sysSetup.paramManage.service]
 * @ClassName: [SysParameterService]
 * @Description: [一句话描述该类的功能]
 * @Author: [wumengfei]
 * @CreateDate: [2018-6-21 下午2:39:59]
 * @UpdateUser: [wumengfei]
 * @UpdateDate: [2018-6-21 下午2:39:59]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
@Service
public class PackageService {
	public static Logger logger = Logger.getLogger(PackageService.class);

	@Autowired
	MaterielPackageMapper materielPackageMapper;

	public Map<String, Object> querybigclass(Map<String, Object> params) {
		List<MaterielBigclass> list = materielPackageMapper.getPage(params);
		Integer count = materielPackageMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public void editpackage(MultipartFile[] images, HttpServletRequest request, MaterielPackage materielPackage)
			throws Exception {
		Integer count=materielPackageMapper.countPackagename(materielPackage);
		if(count!=0) {
			throw new RuntimeException(materielPackage.getPackagename()+"封装已存在！");
		}
		if("add".equals(materielPackage.getAction())) {
			User user = (User) request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			materielPackage.setCreatetime(new Date());
			materielPackage.setCreateuserid(user.getId());
			materielPackage.setRemoved("0");
		}
		for (int i = 0; i < images.length; i++) {
			if(images[i].getSize()>2097152) {
				int j=i+1;
				throw new Exception("图片"+j+"的大小超过2M。");
			}
		}
		if (images[0] != null) {
			for (int i = 0; i < images.length; i++) {
				if (images[i].getSize() != 0) {
					String path = request.getSession().getServletContext().getRealPath("resource/images/package")
							+ File.separator;
					String filename = images[i].getOriginalFilename();
					String saveName = UUID.randomUUID().toString().replaceAll("-", "") + "."
							+ filename.substring(filename.lastIndexOf(".") + 1);
					FileUtils.copyInputStreamToFile(images[i].getInputStream(), new File(path, saveName));
					if (i == 0) {
						materielPackage.setIcon1(saveName);
					} else if (i == 1) {
						materielPackage.setIcon2(saveName);
					} else if (i == 2) {
						materielPackage.setIcon3(saveName);
					} else if (i == 3) {
						materielPackage.setIcon4(saveName);
					} else if (i == 4) {
						materielPackage.setIcon5(saveName);
					}
				}
			}
		}
		if("add".equals(materielPackage.getAction())) {
			materielPackageMapper.insertSelective(materielPackage);
		}else if("edit".equals(materielPackage.getAction())){
			materielPackageMapper.updateByPrimaryKeySelective(materielPackage);
		}
		
	}

	public void delete(MaterielPackage materielPackage) {
		materielPackage.setRemoved("1");
		materielPackageMapper.updateByPrimaryKeySelective(materielPackage);
	}

	public List<MaterielPackage> getAllpackage(Map<String, Object> params) {
		return materielPackageMapper.getPackage(params);
	}

	public MaterielPackage getPackageByName(Map<String, Object> params) {
		List<MaterielPackage> list= materielPackageMapper.getPackage(params);
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

}
