package com.generaldms.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generaldms.biz.KnowledgeBiz;
import com.generaldms.dao.KnowledgeDao;
import com.generaldms.entity.KmCatalogue;
import com.generaldms.entity.KmItem;

@Service("knowledgeBiz")
public class KnowledgeBizImpl implements KnowledgeBiz {
	
	@Autowired
	private KnowledgeDao knowledgeDao;
	
	@Override
	public int deleteKmItemByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return knowledgeDao.deleteKmItemByPrimaryKey(id);
	}

	@Override
	public int insertKmItem(KmItem record) {
		// TODO Auto-generated method stub
		return knowledgeDao.insertKmItem(record);
	}

	@Override
	public int insertKmItemSelective(KmItem record) {
		// TODO Auto-generated method stub
		return knowledgeDao.insertKmItemSelective(record);
	}

	@Override
	public KmItem selectKmItemByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return knowledgeDao.selectKmItemByPrimaryKey(id);
	}

	@Override
	public int updateKmItemByPrimaryKeySelective(KmItem record) {
		// TODO Auto-generated method stub
		return knowledgeDao.updateKmItemByPrimaryKeySelective(record);
	}

	@Override
	public int updateKmItemByPrimaryKey(KmItem record) {
		// TODO Auto-generated method stub
		return knowledgeDao.updateKmItemByPrimaryKey(record);
	}

	@Override
	public List<KmItem> selectAllKmItem() {
		// TODO Auto-generated method stub
		return knowledgeDao.selectAllKmItem();
	}

	@Override
	public List<KmItem> selectItemsByParent(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return knowledgeDao.selectItemsByParent(map);
	}

	@Override
	public List<KmCatalogue> selectAllCatalogue() {
		// TODO Auto-generated method stub
		return knowledgeDao.selectAllCatalogue();
	}

}
