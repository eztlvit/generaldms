package com.generaldms.mapper;

import java.util.List;
import java.util.Map;

import com.generaldms.entity.KmItem;

public interface KmItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KmItem record);

    int insertSelective(KmItem record);

    KmItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KmItem record);

    int updateByPrimaryKey(KmItem record);
    
    List<KmItem> selectAll();

	List<KmItem> selectItemsByParent(Map<String, Integer> map);
}