package com.bdtravel.dao;

import com.bdtravel.entity.Manager;

import java.util.List;

public interface ManagerMapper {
    //添加manager用户信息
    int insertManager(Manager manager);

    //修改用户信息
    int updateManager(Manager manager);
    //删除对应id的管理员
     int deleteManager(String id);

     //通过管理员名字获取整条数据 为空则返回所有数据
    List<Manager> getAllManager(String name);

    //查询管理员并返回
     Manager confirmManager(Manager manager);
    //根据id获取管理员信息
    Manager getManagerById(String id);

}
