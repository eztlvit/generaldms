package com.generaldms.biz;

import java.util.List;
import java.util.Map;

import com.generaldms.entity.KmCatalogue;
import com.generaldms.entity.KmItem;

public interface KnowledgeBiz {
	int deleteKmItemByPrimaryKey(Integer id);

	int insertKmItem(KmItem record);

	int insertKmItemSelective(KmItem record);

	KmItem selectKmItemByPrimaryKey(Integer id);

	int updateKmItemByPrimaryKeySelective(KmItem record);

	int updateKmItemByPrimaryKey(KmItem record);

	List<KmItem> selectAllKmItem();

	List<KmItem> selectItemsByParent(Map<String, Integer> map);

	List<KmCatalogue> selectAllCatalogue();
}
