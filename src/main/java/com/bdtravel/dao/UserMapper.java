package com.bdtravel.dao;

import com.bdtravel.entity.QueryVo;
import com.bdtravel.entity.User;

import java.util.List;

public interface UserMapper {
    //判断用户是否存在，并返回
    User getUser(User user);

    //插入用户信息，并返回影响行数
    int userRegister(User user);

   int updateUserInfo(User user);

   //修改激活状态 1=激活 0=未激活
   int active(String activeCode);

   //通过用户名查询用户数量
   int checkUsername(String username);

    //总条数
    Integer customerCountByQueryVo(QueryVo vo);
    //结果集进行分页
     List<User> selectCustomerListByQueryVo(QueryVo vo);

     //将state改为0
    int updateStateById(String id);
}
