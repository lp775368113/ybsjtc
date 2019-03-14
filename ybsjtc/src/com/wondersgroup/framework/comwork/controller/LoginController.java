
package com.wondersgroup.framework.comwork.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.redis.PropertyConfigurer;
import com.wondersgroup.framework.redis.RedisCache;
import com.wondersgroup.framework.redis.SerializeUtil;
import com.wondersgroup.framework.upms.comm.CommJson;
import com.wondersgroup.framework.upms.service.UasUserService;
import com.wondersgroup.framework.upms.util.MenuUtil;
import com.wondersgroup.framework.upms.vo.DeptVO;
import com.wondersgroup.framework.upms.vo.UasFuncVO;
import com.wondersgroup.framework.upms.vo.UasMenuVO;
import com.wondersgroup.framework.upms.vo.UasUserVO;
import com.wondersgroup.permission.menu.service.PerMenuService;
import com.wondersgroup.permission.menu.vo.PerMenu;
import com.wondersgroup.permission.user.service.UserService;
import com.wondersgroup.permission.user.vo.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [ybsjtc]
 * @Package: [com.wondersgroup.framework.urm.action]
 * @ClassName: [LoginAction]
 * @Description: [用户登录类]
 * @Author: [Administrator]
 * @CreateDate: [2018年1月8日 下午11:14:54]
 * @UpdateUser: [Administrator]
 * @UpdateDate: [2018年1月8日 下午11:14:54]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

	/**@Fields logger: TODO[用一句话描述这个变量表示什么]   */
	public static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private PerMenuService perMenuService;
	/**
	 * @Title: doLogin
	 * @Description: TODO[系统登录校验和权限]
	 * @param paramMap
	 * @param request
	 * @return
	 * @return_type: ModelAndView
	 */
	@RequestMapping("doLogin")
	public ModelAndView doLogin(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
		String errMsg = "";
		try {
			//获取当前用户登录信息
			String redis_singlelogin = (String) PropertyConfigurer.getContextProperty("redis.singlelogin");
			String  sessid = request.getRequestedSessionId();
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<"+sessid+">>>>>>>>>>>>>>>>>>>>>>>");
			String loginname = paramMap.get("loginname").toString().trim();
			String password = paramMap.get("password").toString().trim();
			if (StringUtils.isEmpty(loginname) || loginname.trim() == "")
				return new ModelAndView("/login").addObject("errMsg", "账号不能为空！");
			if (StringUtils.isEmpty(password) || password.trim() == "")
				return new ModelAndView("/login").addObject("errMsg", "密码不能为空！");
			User user=userService.getUserByLoginname(loginname);
			if(user==null) {
				return new ModelAndView("/login").addObject("errMsg", "帐号不存在！");
			}else if(!password.equals(user.getPassword())) {
				return new ModelAndView("/login").addObject("errMsg", "密码错误！");
			}else {
				request.getSession().setAttribute(SessionConstants.CW_LOGINUSER, user);
			}
			
			//获取菜单权限
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", user.getUid());
			List<PerMenu> listMenu = perMenuService.listUserMenu(map);
			if(listMenu.size()>0){
				HashMap<String, TreeMap<Integer, List<PerMenu>>> tree = MenuUtil.CreateMenuTree(listMenu);
				List<PerMenu> topMenuList = tree.get("1").get(0);
				Map<Integer, List<PerMenu>> topChildMenuList = tree.get("2");
				request.getSession().setAttribute("topMenuList", topMenuList);
				request.getSession().setAttribute("topChildMenuList", topChildMenuList);
			}
			return new ModelAndView("/pages/index");
		} catch (Exception e) {
			errMsg = "系统异常,请联系部门排除!";
			return new ModelAndView("/login").addObject("errMsg", errMsg);
		}
	}

	/**
	 * @Title: doUpdatePwd
	 * @Description: TODO[修改密码]
	 * @param paramMap
	 * @return
	 * @return_type: String
	 */
	@RequestMapping("doUpdatePwd")
	@ResponseBody
	public String doUpdatePwd(@RequestParam Map<String, Object> paramMap) {
		String result;
		try {
			String password1 = paramMap.get("password1").toString();
			String password2 = paramMap.get("password2").toString();
			logger.info("---password1:" + password1);
			if (password1 != null) {
				if (!password1.equals(password2)) {
					result = "{success:false,result:[],errors:[{msg:\"两次输入不一致\"}],exception:[{msg:\"两次输入不一致\"}],target:null}";
				} else {
					paramMap.put("password", DigestUtils.md5Hex(password1));
					//systemService.modUserPassword(paramMap);
					result = "{success:true}";
				}
			} else {
				result = "{success:false,result:[],errors:[{msg:\"密码不可为空\"}],exception:[{msg:\"密码不可为空\"}],target:null}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result = "{success:false,result:[],errors:[{msg:\"修改密码出错\"}],exception:[{msg:\"修改密码出错\"}],target:null}";
		}
		return result;
	}
	/**
	 * @Title: doLoginout
	 * @Description: TODO[退出登录]
	 * @param request
	 * @return
	 * @return_type: ModelAndView
	 */
	@RequestMapping("doLoginout")
	public ModelAndView doLoginout(HttpServletRequest request) {
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
			e.getLocalizedMessage();
			logger.error(e.getMessage(), e);
		}
		return new ModelAndView("/login");
	}

	/**
	 * @Title: captcha
	 * @Description: TODO[生成验证码]
	 * @param request
	 * @param response
	 * @return_type: void
	 */
	@RequestMapping("captcha")
	public void captcha(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 设置页面不缓存
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-catch");
			response.setDateHeader("Expires", 0);
			// 表明生成的响应是图片
			response.setContentType("image/jpeg");
			// 在内存中创建图象
			int width = 100;
			int height = 30;
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			// 创建图象
			Graphics g = image.getGraphics();
			// 生成随机对象
			Random random = new Random();
			// 设置背景色
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);
			// 设置字体
			g.setFont(new Font("黑体", Font.ROMAN_BASELINE, 25));

			// 随机产生干扰线
			g.setColor(getRandColor(160, 200));
			for (int i = 0; i < 255; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, xl, yl);
			}
			// 随机产生认证码,4位数字
			String sRand = "";
			for (int i = 0; i < 6; i++) {
				String rand = String.valueOf(random.nextInt(10));
				sRand += rand;
				// 将认证码显示到图象中
				g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
				g.drawString(rand, 13 * i + 6, 22);
			}

			request.getSession().setAttribute("rCode", sRand);
			// 图像生效
			g.dispose();
			OutputStream output = response.getOutputStream();
			// 输出图象到页面
			ImageIO.write(image, "JPEG", output);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * @Title: getRandColor
	 * @Description: TODO[给定范围获得随机颜色]
	 * @param fc
	 * @param bc
	 * @return
	 * @return_type: Color
	 */
	public Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
