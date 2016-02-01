package com.generaldms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.generaldms.dao.KnowledgeDao;
import com.generaldms.entity.KmCatalogue;
import com.generaldms.entity.KmItem;
import com.generaldms.mapper.KmCatalogueMapper;
import com.generaldms.mapper.KmItemMapper;

@Repository(value="knowledgeDaoImpl")
public class KnowledgeDaoImpl implements KnowledgeDao {

	@Autowired
	private KmCatalogueMapper kmCatalogueMapper;
	
	@Autowired
	private KmItemMapper kmItemMapper;

	@Override
	public int deleteKmItemByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return kmItemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertKmItem(KmItem record) {
		// TODO Auto-generated method stub
		return kmItemMapper.insert(record);
	}

	@Override
	public int insertKmItemSelective(KmItem record) {
		// TODO Auto-generated method stub
		return kmItemMapper.insertSelective(record);
	}

	@Override
	public KmItem selectKmItemByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return kmItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateKmItemByPrimaryKeySelective(KmItem record) {
		// TODO Auto-generated method stub
		return kmItemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateKmItemByPrimaryKey(KmItem record) {
		// TODO Auto-generated method stub
		return kmItemMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<KmItem> selectAllKmItem() {
		// TODO Auto-generated method stub
		return kmItemMapper.selectAll();
	}

	@Override
	public List<KmItem> selectItemsByParent(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return kmItemMapper.selectItemsByParent(map);
	}

	@Override
	public List<KmCatalogue> selectAllCatalogue() {
		// TODO Auto-generated method stub
		return kmCatalogueMapper.selectAll();
	}

}
