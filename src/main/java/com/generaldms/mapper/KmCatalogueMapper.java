package com.generaldms.mapper;

import java.util.List;

import com.generaldms.entity.KmCatalogue;

public interface KmCatalogueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KmCatalogue record);

    int insertSelective(KmCatalogue record);

    KmCatalogue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KmCatalogue record);

    int updateByPrimaryKey(KmCatalogue record);
    
    List<KmCatalogue> selectAll();
}