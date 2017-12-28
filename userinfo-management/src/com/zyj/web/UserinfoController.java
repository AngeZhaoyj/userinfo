package com.zyj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zyj.domain.Admin;
import com.zyj.domain.Dept;
import com.zyj.domain.Page;
import com.zyj.domain.Userinfo;
import com.zyj.service.DeptService;
import com.zyj.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController{
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private DeptService deptService;
	
	/**显示添加页面*/
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addShow(){
		ModelAndView mav = new ModelAndView("userinfoAdd");
		List<Dept> deptList = deptService.listDept();
		mav.addObject("deptList", deptList);
		return mav;
	}
	
	/**保存添加*/
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(Userinfo u){
		userinfoService.addUserinfo(u);
		ModelAndView mav = new ModelAndView("redirect:/main");
		return mav;
	}
	
	/**显示修改密码页面*/
	@RequestMapping(value="/updPassword",method=RequestMethod.GET)
	public ModelAndView updPasswordShow(){
		ModelAndView mav = new ModelAndView("updPassword");
		return mav;
	}

	/**保存新密码*/
	@RequestMapping(value="/updPassword",method=RequestMethod.POST)
	public ModelAndView updPassword(Admin a){
		userinfoService.updPassword(a);
		ModelAndView mav = new ModelAndView("redirect:/main");
		return mav;
	}

	/**显示修改页面*/
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView updateShow(String id){
		ModelAndView mav = new ModelAndView("userinfoUpdate");
		List<Dept> deptList = deptService.listDept();
		Userinfo userinfo = userinfoService.get(id);
		mav.addObject("userinfo", userinfo);
		mav.addObject("deptList", deptList);
		return mav;
	}

	/**保存修改*/
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(Userinfo u){
		userinfoService.update(u);
		ModelAndView mav = new ModelAndView("redirect:/main");
		return mav;
	}

	/**删除用户*/
	@RequestMapping(value="/delete")
	public ModelAndView delete(String id){
		userinfoService.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/main");
		return mav;
	}
	
	/**分页查询用户*/
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public ModelAndView listByCondition(Userinfo u,HttpServletRequest req){
		ModelAndView mav = new ModelAndView("main");
		List<Dept> deptList = deptService.listDept();
		mav.addObject("queryUser", u);
		mav.addObject("deptList", deptList);
        //接收参数   
        String currentPage = req.getParameter("currentPage"); 
        //创建分页对象  
        Page page = new Page();  
        //设置总条数  
        page.setTotalNumber(userinfoService.getCount(u));    
        if(currentPage == null || Integer.parseInt(currentPage)>page.getTotalPage()){  
            page.setCurrentPage(1);  
        }else {  
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        page.count();
        //dbNumber表示最大能取到的条数   
        page.setDbNumber(page.getPageNumber());  
        u.setPage(page);
        List<Userinfo> userinfoList = userinfoService.listByCondition(u);
        mav.addObject("userinfoList", userinfoList);  
        mav.addObject("page", page);  
        return mav;
	}
	
	/**查询编号唯一*/
	@RequestMapping(value="/checkCoded",method=RequestMethod.POST)
	public ModelAndView checkCoded(HttpServletRequest request,HttpServletResponse response){
		String coded = request.getParameter("coded");
		//创建map用来表示回调数据data
		Map<String,Object> map = new HashMap<String,Object>();

		int m = userinfoService.checkCoded(coded);
		
		if(m > 0){//编号已存在或编号为空
			map.put("msg", false);//false代表不可用
		}else{//可用
			map.put("msg", true);//true代表可用
		}
		//准备将map变成json 并写到空白页
		//1 设置编码
		response.setContentType("text/html;charset=UTF-8");
		//2获取out
		PrintWriter out;
		try {
			out = response.getWriter();
			//3将map转换成json
			Gson gson = new Gson();
			out.write( gson.toJson(map) );//gson.toJson(map)将map转换成json格式的字符串
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**查询手机号唯一*/
	@RequestMapping(value="/checkTelephone",method=RequestMethod.POST)
	public ModelAndView checkTelephone(HttpServletRequest request,HttpServletResponse response){
		String telephone = request.getParameter("telephone");
		//创建map用来表示回调数据data
		Map<String,Object> map = new HashMap<String,Object>();

		int n = userinfoService.checkTelephone(telephone);
		
		if(n > 0){//手机号已存在或手机号为空
			map.put("msg", false);//false代表不可用
		}else{//可用
			map.put("msg", true);//true代表可用
		}
		//准备将map变成json 并写到空白页
		//1 设置编码
		response.setContentType("text/html;charset=UTF-8");
		//2获取out
		PrintWriter out;
		try {
			out = response.getWriter();
			//3将map转换成json
			Gson gson = new Gson();
			out.write( gson.toJson(map) );//gson.toJson(map)将map转换成json格式的字符串
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
