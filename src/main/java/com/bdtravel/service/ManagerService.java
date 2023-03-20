package com.bdtravel.service;

import com.bdtravel.entity.Manager;

import java.util.List;

public interface ManagerService {
     //返回影响的行数
     int insertManager(Manager manager);

     //修改用户信息
     int updateManager(Manager manager);

     //删除对象id的管理员
     int deleteManager(String id);

     //通过名字获取Manager对象数据封装到集合  为空则返回所有数据
     List<Manager> getAllManager(String name);

     //查询管理员并返回
     Manager confirmManager(Manager manager);

     Manager getManagerById(String id);

}
