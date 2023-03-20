package com.bdtravel.service;

import com.bdtravel.entity.QueryVo;
import com.bdtravel.entity.Scenic;
import com.bdtravel.utils.Page;

import java.util.List;

public interface ScenicService {
    List<Scenic> selectScenicList();

    //结果集
    Page<Scenic> selectPageByQueryVo(QueryVo vo);
    //新增
    void addScenic(Scenic scenic);

    //根据id删除信息
     void deleteById(Integer id);
     //返回修改后影响的数据行数
    int updateScenic(Scenic scenic);
    Scenic getScenicById(Integer id);
    int updateScenicSales(Integer id);
}
