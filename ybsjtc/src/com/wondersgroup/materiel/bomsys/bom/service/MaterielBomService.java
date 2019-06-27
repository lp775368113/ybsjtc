package com.wondersgroup.materiel.bomsys.bom.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.dingding.util.CheckEcn;
import com.wondersgroup.framework.jxls.JxlsRead;
import com.wondersgroup.framework.pdfutil.Doc2Pdf;
import com.wondersgroup.materiel.bomsys.bom.dao.MaterielBomMapper;
import com.wondersgroup.materiel.bomsys.bom.vo.MaterielBom;
import com.wondersgroup.materiel.bomsys.ecn.dao.MaterielBomEcnMapper;
import com.wondersgroup.materiel.bomsys.ecn.vo.MaterielBomEcn;
import com.wondersgroup.materiel.encoding.dao.Data0017Mapper;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.permission.user.dao.UserMapper;
import com.wondersgroup.permission.user.vo.Dd_User;
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
public class MaterielBomService {
	public static Logger logger = Logger.getLogger(MaterielBomService.class);

	@Autowired
	private MaterielBomMapper materielBomMapper;

	@Autowired
	private Data0017Mapper data0017Mapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	EncodingService encodingService;

	@Autowired
	private MaterielBomEcnMapper materielBomEcnMapper;

	@SuppressWarnings("unchecked")
	public void importBom(MultipartFile[] myfiles, Map<String, Object> paramMap, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
		Integer productid = Integer.parseInt((String) paramMap.get("id"));
		Map<String, Object> beans = new HashMap<String, Object>();
		InputStream inputXML = new BufferedInputStream(
				request.getServletContext().getResourceAsStream("xls/ImportBom.xml"));
		List<MaterielBom> bom = new ArrayList<MaterielBom>();
		beans.put("list", bom);
		Map<String, Object> needData = JxlsRead.ExcelToBean(inputXML, myfiles[0], beans);
		ArrayList<MaterielBom> list = (ArrayList<MaterielBom>) needData.get("list");
		Map<String, String> top = new HashMap<String, String>();// 存储上面贴片位置信息
		Map<String, String> bottom = new HashMap<String, String>();// 存储下面贴片位置信息
		Map<String, Integer> how = new HashMap<String, Integer>();// 存储用量信息
		// 获取文件中贴片位置和用量信息
		for (MaterielBom bean : list) {
			String key = bean.getCustPartCode();
			if (top.containsKey(key)) {
				if ("NO".equals(bean.getSym_mirror())) {
					String topstr = (String) top.get(key);
					if ("".equals(topstr)) {
						top.put(key, bean.getRefdes());
					} else {
						top.put(key, topstr + "," + bean.getRefdes());
					}
				} else {
					String bottomstr = (String) bottom.get(key);
					if ("".equals(bottomstr)) {
						bottom.put(key, bean.getRefdes());
					} else {
						bottom.put(key, bottomstr + "," + bean.getRefdes());
					}
				}
				Integer yongliang = how.get(key);
				how.put(key, yongliang + 1);
			} else {
				if ("NO".equals(bean.getSym_mirror())) {
					top.put(key, bean.getRefdes());
					bottom.put(key, "");
				} else {
					bottom.put(key, bean.getRefdes());
					top.put(key, "");
				}
				how.put(key, 1);
			}
		}
		// 导入BOM表
		for (String key : top.keySet()) {
			Data0017 materiel = data0017Mapper.getMaterielByCustPartCode(key);
			MaterielBom vo = new MaterielBom();
			if (materiel != null) {
				vo.setProductid(productid);
				vo.setInfoid(materiel.getId());
				vo.setCustPartCode(materiel.getCustPartCode());
				vo.setPackage_(materiel.getPackage_());
				vo.setProdSupper(materiel.getProdSupper());
				vo.setInvPartDescriptionC(materiel.getInvPartDescriptionC());
				vo.setBomType(materiel.getTtype());
				vo.setHow(how.get(key));
				vo.setStockUnitPtr(materiel.getStockUnitPtr());
				vo.setSmtFlag(materiel.getSmtFlag());
				vo.setInvPartNumber(materiel.getInvPartNumber());
				vo.setExtraDesc(materiel.getExtraDesc());
				vo.setProdCodeSellPtr(materiel.getProdCodeSellPtr());
				vo.setPurchUnitPtr(materiel.getPurchUnitPtr());
				vo.setEditTime(new Date());
				vo.setEditUserid(user.getId());
				vo.setTop(top.get(key));
				vo.setBottom(bottom.get(key));
				vo.setVersion(0);
				materielBomMapper.insertSelective(vo);
			} else {
				throw new RuntimeException("供应商料号：（" + key + "）系统不存在该物料！");
			}
		}
	}

	public List<MaterielBom> queryBom(Map<String, Object> params) {
		List<MaterielBom> bom = materielBomMapper.queryBom(params);
		List<MaterielBom> bomedits = materielBomMapper.queryBomEdit(params);
		for (MaterielBom edit : bomedits) {
			if ("added".equals(edit.getOperation())) {
				bom.add(0, edit);
			} else if ("removed".equals(edit.getOperation())) {
				Iterator<MaterielBom> it = bom.iterator();
				while (it.hasNext()) {
					MaterielBom row = it.next();
					if ((edit.getCustPartCode()).equals(row.getCustPartCode())) {
						it.remove();
					}
				}
			} else if ("replace".equals(edit.getOperation())) {
				Iterator<MaterielBom> it = bom.iterator();
				int i = 0;
				while (it.hasNext()) {
					i = i + 1;
					MaterielBom row = it.next();
					if ((edit.getCustPartCode()).equals(row.getCustPartCode())) {
						it.remove();
						break;
					}
				}
				int j = 0;
				Iterator<MaterielBom> it1 = bom.iterator();
				while (it1.hasNext()) {
					j = j + 1;
					MaterielBom row = it1.next();
					if ((edit.getReplacecode()).equals(row.getCustPartCode())) {
						bom.add(j, edit);
						break;
					}
				}
			} else if ("modified".equals(edit.getOperation())) {
				Iterator<MaterielBom> it = bom.iterator();
				int i = 0;
				while (it.hasNext()) {
					i = i + 1;
					MaterielBom row = it.next();
					if ((edit.getCustPartCode()).equals(row.getCustPartCode())) {
						it.remove();
						break;
					}
				}
				bom.add(i - 1, edit);
			}
		}
		return bom;
	}

	@SuppressWarnings("unchecked")
	public void editBom(Map<String, Object> param, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
		Dd_User dd_user = userMapper.getDd_users(String.valueOf((int) user.getId()));
		if (dd_user == null) {
			throw new RuntimeException("您的账户和钉钉未绑定！请联系管理员！");
		}
		String ecnstr = (String) param.get("ecn");
		String editstr = (String) param.get("edit");
		// 保存ecn
		MaterielBomEcn ecn = JSONArray.parseObject(ecnstr, MaterielBomEcn.class);
		ecn.setCreateTime(new Date());
		ecn.setRemoved("0");
		ecn.setCheckStatus("1");// 审核中
		ecn.setUserid(user.getId());
		materielBomEcnMapper.insertSelective(ecn);
		// 保存变更记录
		Map<String, String> obj = (Map<String, String>) JSONObject.parseObject(editstr, HashMap.class);
		List<Map<String, Object>> bomlist = new ArrayList<Map<String, Object>>();
		for (String key : obj.keySet()) {
			if (!"productid".equals(key)) {
				Map<String, Object> bom = new HashMap<String, Object>();
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", Integer.parseInt(key));
				Data0017 mate = encodingService.getOneMaterial(params);
				bom.put("bomCode", mate.getCustPartCode());
				List<Map<String, Object>> editlist = new ArrayList<Map<String, Object>>();
				List<MaterielBom> list = JSON.parseArray(JSON.parseObject(editstr).getString(key), MaterielBom.class);
				Integer version = materielBomMapper.getMaxVersion(Integer.parseInt(key));
				if (version == null) {
					version = 1;
				} else {
					version = version + 1;
				}
				for (MaterielBom edit : list) {
					Map<String, Object> ed = new HashMap<String, Object>();
					ed.put("editCode", edit.getCustPartCode());
					String operation = "";
					if ("added".equals(edit.getOperation())) {
						operation = "新增物料";
					} else if ("removed".equals(edit.getOperation())) {
						operation = "删除物料";
					} else if ("modified".equals(edit.getOperation())) {
						operation = "修改物料贴装参数";
					} else if ("replace".equals(edit.getOperation())) {
						operation = "新增替换料";
					}
					ed.put("operation", operation);
					edit.setVersion(version);
					edit.setEditTime(new Date());
					edit.setEditUserid(user.getId());
					edit.setEcnid(ecn.getId());
					materielBomMapper.insertBomEdit(edit);
					editlist.add(ed);
				}
				bom.put("bomEdit", editlist);
				bomlist.add(bom);
			}
		}
		ecn.setEdit(bomlist);
		// 生成ECN文件  先生成word文档，而后word文档转pdf文件！
		Map<String, Object> dataMap = new HashMap<String, Object>();// 导入文件生成模板的参数
		String filepath = request.getSession().getServletContext().getRealPath("/FILE/" + user.getId());
		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		String pdfpath = filepath;
		filepath = filepath + "/ecn.doc";
		String basefile = "ecn.ftl";
		DocumentHandler mdoc = new DocumentHandler();
		mdoc.createDoc(ecn, filepath, basefile);
		File inf = new File(filepath);
		//转png
		 String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		Doc2Pdf.doc2png(pdfpath,uuid);
		// 发起钉钉ecn审批
		CheckEcn.startProcessInstance(ecn, dd_user,uuid);

	}

	public List<Map> getAllVersion(Map<String, Object> param) {
		List<Map> list = materielBomMapper.getAllVersion(param);
		Map<String, String> v0 = new HashMap<String, String>();
		v0.put("version", "0");
		list.add(v0);
		return list;
	}

	public Boolean canImportBom(Map<String, Object> param) {
		Integer count = materielBomMapper.canImportBom(param);
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
}
