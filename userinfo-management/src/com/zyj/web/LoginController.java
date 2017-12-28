package com.zyj.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zyj.domain.Admin;
import com.zyj.domain.Dept;
import com.zyj.domain.Page;
import com.zyj.domain.Userinfo;
import com.zyj.service.DeptService;
import com.zyj.service.UserinfoService;

@Controller
public class LoginController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private DeptService deptService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	/**显示登录页面*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginShow() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	/**验证登录数据*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, Admin param) {
		ModelAndView mav = new ModelAndView();
		Admin admin = userinfoService.queryForLogin(param);
		if (admin == null) {
			mav.addObject("message", "账号密码不匹配！");
			mav.setViewName("login");
			return mav;
		}
		session.setAttribute("session_user", admin);
		mav.setViewName("redirect:/index");
		return mav;
	}

	/**显示顶部菜单栏*/
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public ModelAndView topShow() {
		ModelAndView mav = new ModelAndView("top");
		return mav;
	}

	/**显示左侧导航栏*/
	@RequestMapping(value = "/navigation", method = RequestMethod.GET)
	public ModelAndView navShow() {
		ModelAndView mav = new ModelAndView("navigation");
		return mav;
	}

	/**分页显示用户列表*/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView mainShow(Userinfo u) {
		ModelAndView mav = new ModelAndView("main");
		// 查询所有用户;
		Page page = new Page();
		// 设置总条数
		page.setTotalNumber(userinfoService.getCount(u));
		page.setCurrentPage(1);
		// dbNumber表示最大能取到的条数
		page.setDbNumber(page.getDbIndex() + page.getPageNumber());
		page.setTotalPage(page.getTotalPage());
		u.setPage(page);
		List<Userinfo> userinfoList = userinfoService.listByCondition(u);
		mav.addObject("userinfoList", userinfoList);
		mav.addObject("page", page);
		// 查询所有机构
		List<Dept> deptList = deptService.listDept();
		mav.addObject("deptList", deptList);
		return mav;
	}

}
