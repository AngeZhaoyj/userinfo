package com.zyj.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zyj.domain.Dept;
import com.zyj.domain.Page;
import com.zyj.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController{
	@Autowired
	private DeptService deptService;

	/**显示机构列表*/
	@RequestMapping(value="/deptList",method=RequestMethod.GET)
	public ModelAndView deptListShow(Dept d){
		ModelAndView mav = new ModelAndView("deptList");
		// 查询所有用户;
		Page page = new Page();
		// 设置总条数
		page.setTotalNumber(deptService.getCount(d));
		page.setCurrentPage(1);
		// dbNumber表示最大能取到的条数
		page.setDbNumber(page.getDbIndex() + page.getPageNumber());
		page.setTotalPage(page.getTotalPage());
		d.setPage(page);
		List<Dept> deptList = deptService.listByCondition(d);
		mav.addObject("deptList", deptList);
		mav.addObject("page", page);
		return mav;
	}
	
	/**显示添加页面*/
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addShow(){
		ModelAndView mav = new ModelAndView("deptAdd");
		return mav;
	}
	
	/**保存添加*/
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(Dept d){
		deptService.addDept(d);
		ModelAndView mav = new ModelAndView("redirect:/dept/deptList");
		return mav;
	}
	
	/**显示修改页面*/
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView updateShow(String id){
		ModelAndView mav = new ModelAndView("deptUpdate");
		Dept dept = deptService.get(id);
		mav.addObject("dept", dept);
		return mav;
	}

	/**保存修改*/
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(Dept d){
		deptService.update(d);
		ModelAndView mav = new ModelAndView("redirect:/dept/deptList");
		return mav;
	}

	/**删除机构*/
	@RequestMapping(value="/delete")
	public ModelAndView delete(String id){
		deptService.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/dept/deptList");
		return mav;
	}
	
	/**分页查询机构*/
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public ModelAndView listByCondition(Dept d,HttpServletRequest req){
		ModelAndView mav = new ModelAndView("deptList");
		mav.addObject("queryDept", d);
		//接收参数   
        String currentPage = req.getParameter("currentPage"); 
        //创建分页对象  
        Page page = new Page();  
        //设置总条数  
        page.setTotalNumber(deptService.getCount(d));    
        if(currentPage == null || Integer.parseInt(currentPage)>page.getTotalPage()){  
            page.setCurrentPage(1);  
        }else {  
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        page.count();
        //dbNumber表示最大能取到的条数  
        page.setDbNumber(page.getPageNumber());  
        d.setPage(page);
        List<Dept> deptList = deptService.listByCondition(d);
        mav.addObject("deptList", deptList);  
        mav.addObject("page", page);  
        return mav;
	}
}
