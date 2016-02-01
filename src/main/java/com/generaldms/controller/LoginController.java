package com.generaldms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generaldms.biz.KnowledgeBiz;
import com.generaldms.biz.UserBiz;
import com.generaldms.entity.KmCatalogue;
import com.generaldms.entity.KmItem;
import com.generaldms.entity.User;

@Controller
public class LoginController {

	@Autowired
	private UserBiz userBiz;
	
	@Autowired
	private KnowledgeBiz knowledgeBiz;

	private List<KmCatalogue> kmCatalogueLst;

	@RequestMapping(value = "/loginPage")
	public String loginPage() {
		return "/login";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response,
			@Param("name") String name, @Param("pwd") String pwd) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("pwd", pwd);
		User user = userBiz.getUserByLogin(map);
//		PrintWriter pw = response.getWriter();
//		if (null!=user) {
//			pw.print("{\"success\":\"true\"}");
//		}else {
//			pw.print("{\"success\":\"false\"}");
//		}
		if (null!=user) {
			request.getSession().setAttribute("user", user);
			return "redirect:/index";
			
		}else {
			return "redirect:/loginPage";
		}
	}
	
	@RequestMapping(value="/index")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		List<KmItem> kmItemLst = new ArrayList<KmItem>();
		kmItemLst = knowledgeBiz.selectAllKmItem();
		kmCatalogueLst = knowledgeBiz.selectAllCatalogue();
//		request.setAttribute("kmCatalogueLst", kmCatalogueLst);
		map.put("kmCatalogueLst", kmCatalogueLst);
		return "/index";
	}
}
