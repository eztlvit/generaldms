package com.generaldms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generaldms.biz.KnowledgeBiz;
import com.generaldms.entity.KmCatalogue;
import com.generaldms.entity.KmItem;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class KnowledgeController {

	@Autowired
	private KnowledgeBiz knowledgeBiz;
	private List<KmCatalogue> kmCatalogueLst;

	@RequestMapping(value = "/getKnowledgeData")
	public String getKnowledgeData(HttpServletRequest request,
			HttpServletResponse response, ModelMap map,
			@RequestParam("cId") Integer cId,
			@RequestParam("cName") String cName)
			throws UnsupportedEncodingException {
		map.put("cId", cId);
		byte bb[];
		bb = cName.getBytes("ISO-8859-1"); // 以"ISO-8859-1"方式解析name字符串
		cName = new String(bb, "UTF-8"); // 再用"utf-8"格式表示name
		map.put("cName", cName);
		kmCatalogueLst = knowledgeBiz.selectAllCatalogue();
		map.put("kmCatalogueLst", kmCatalogueLst);
		return "/knowledgecenter";
	}

	public void initTreeForBootstrap(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "parentid") int parentId,
			@RequestParam(value = "cid") int cid,
			@RequestParam(value = "cname") String cName) throws IOException {
		byte bb[];
		bb = cName.getBytes("ISO-8859-1"); // 以"ISO-8859-1"方式解析name字符串
		cName = new String(bb, "UTF-8"); // 再用"utf-8"格式表示name
		System.out.println(cName);
		StringBuffer treeNode = new StringBuffer("[ { \"text\": \"" + cName
				+ "\"");
		treeNode.append(",\"expandIcon\": \"glyphicon glyphicon-asterisk\"");
		treeNode.append(",\"showCheckbox\": true");
		treeNode.append(",\"showIcon\": true");

		List<KmItem> items = new ArrayList<KmItem>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("cid", cid);
		map.put("parentid", parentId);
		items = knowledgeBiz.selectItemsByParent(map);
		if (items.size() > 0 && null != items) {
			treeNode.append(",\"nodes\": [ ");
			getTreeData(cid, treeNode, items);
			treeNode.append(" ]");
		}

		treeNode.append(" } ]");
		System.out.println(treeNode.toString());
		response.getWriter().print(treeNode.toString());
	}

	// 递归生成整棵树
	private void getTreeData(int cid, StringBuffer treeNode, List<KmItem> items) {
		for (int i = 0; i < items.size(); i++) {
			treeNode.append(" {\"text\": \"" + items.get(i).getFilename()
					+ "\"");
			if (items.get(i).getType().equalsIgnoreCase("folder")) {
				treeNode.append(",\"nodes\": [");
				Map<String, Integer> tempSubMap = new HashMap<String, Integer>();
				tempSubMap.put("cid", cid);
				tempSubMap.put("parentid", items.get(i).getId());
				List<KmItem> tempSubItems = knowledgeBiz
						.selectItemsByParent(tempSubMap);
				getTreeData(cid, treeNode, tempSubItems);
				treeNode.append("]");
			}
			treeNode.append(" }");
			if ((i + 1) < items.size()) {
				treeNode.append(", ");
			}
		}
	}

	// 异步加载树节点
	@RequestMapping(value = "/initTree")
	public void initTree(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "pid", required = false, defaultValue = "0") int parentId,
			@RequestParam(value = "cid", required = false, defaultValue = "0") int cid,
			@RequestParam(value = "cname", required = false, defaultValue = "J") String cName)
			throws IOException {
		byte bb[];
		bb = cName.getBytes("ISO-8859-1"); // 以"ISO-8859-1"方式解析name字符串
		cName = new String(bb, "UTF-8"); // 再用"utf-8"格式表示name
		List<KmItem> items = new ArrayList<KmItem>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("cid", cid);
		map.put("parentid", parentId);
		items = knowledgeBiz.selectItemsByParent(map);
		StringBuffer nodes = new StringBuffer(" [ ");
		for (int i = 0; i < items.size(); i++) {
			// id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true
			nodes.append(" { ");
			nodes.append("\"id\":\"" + items.get(i).getId() + "\",");
			nodes.append("\"pId\":\"" + items.get(i).getParentid() + "\",");
			nodes.append("\"name\":\"" + items.get(i).getFilename() + "\"");
			if (items.get(i).getType().equalsIgnoreCase("folder")) {
				nodes.append(",\"isParent\":\"true\"");
			}
			nodes.append(" } ");
			if ((i + 1) < items.size()) {
				nodes.append(",");
			}
		}
		 if(items.size()==0&&parentId==0) {
			KmItem kmItem = new KmItem();
			kmItem.setCid(cid);
			kmItem.setType("folder");
			kmItem.setFilename("目录");
			kmItem.setParentid(0);
			kmItem.setCreatedatatime(new Date());
			int count = knowledgeBiz.insertKmItem(kmItem);
			nodes.append(" { ");
			nodes.append("\"id\":\"" + kmItem.getId() + "\",");
			nodes.append("\"pId\":\"" + kmItem.getParentid() + "\",");
			nodes.append("\"name\":\"" + kmItem.getFilename() + "\"");
			if (kmItem.getType().equalsIgnoreCase("folder")) {
				nodes.append(",\"isParent\":\"true\"");
			}
			nodes.append(" } ");
		} 
		nodes.append(" ] ");
		response.getWriter().print(nodes.toString());
	}

	@RequestMapping(value = "/deleteKm")
	public void deleteKm(HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "id") int id,@RequestParam(value = "cid") int cid,@RequestParam(value = "isParent") Boolean isParent)
			throws IOException {
		int count = 0;
		
		try {
			if (isParent) {
				count = deleteKmFolder(id, cid);
			}else {
				count = knowledgeBiz.deleteKmItemByPrimaryKey(id);
			}
			 
			if (count > 0) {
				response.getWriter().print("{\"isDelete\":true}");
			} else {
				response.getWriter().print("{\"isDelete\":false}");
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().print("{\"isDelete\":false}");
		}
	}

	private int deleteKmFolder(int id, int cid) {
		int count;
		Map<String, Integer> tempSubMap = new HashMap<String, Integer>();
		tempSubMap.put("cid", cid);
		tempSubMap.put("parentid", id);
		List<KmItem> deleteKmItems = knowledgeBiz.selectItemsByParent(tempSubMap);
		for (KmItem kmItem : deleteKmItems) {
			if (kmItem.getType().equalsIgnoreCase("folder")) {
				deleteKmFolder(kmItem.getId(),kmItem.getCid());
			}else {
				knowledgeBiz.deleteKmItemByPrimaryKey(kmItem.getId());
			}
		}
		count = knowledgeBiz.deleteKmItemByPrimaryKey(id);
		return count;
	}
	
	@RequestMapping(value = "/addKm")
	public void addKm(HttpServletRequest request, HttpServletResponse response,
			@RequestBody KmItem kmItem) throws IOException {
		kmItem.setCreatedatatime(new Date());
		int count = knowledgeBiz.insertKmItem(kmItem);
		if (count > 0) {
			response.getWriter().print("{\"isInsert\":true}");
		} else {
			response.getWriter().print("{\"isInsert\":false}");
		}
	}
	
	@RequestMapping(value = "/getKmItem")
	public void getKmItem(HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "id") int id) throws JSONException, IOException {
		KmItem kmItem = knowledgeBiz.selectKmItemByPrimaryKey(id);
		if (null!=kmItem) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("content", kmItem.getContent());
			jsonObject.put("filename", kmItem.getFilename());
			jsonObject.put("type", kmItem.getType());
			response.getWriter().print(jsonObject.toString());
		}
	}
	
	@RequestMapping(value = "/updateKm")
	@ResponseBody
	public void updateKm(@RequestBody KmItem kmItem,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int count = knowledgeBiz.updateKmItemByPrimaryKeySelective(kmItem);
		if (count > 0) {
			response.getWriter().print("{\"isUpate\":true}");
		} else {
			response.getWriter().print("{\"isUpate\":false}");
		}
	}
	
}
