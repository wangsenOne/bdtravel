package com.bdtravel.service;

import com.bdtravel.entity.QueryVo;
import com.bdtravel.entity.User;
import com.bdtravel.utils.Page;

public interface UserService {
    //获取返回的用户对象
    User confirmUser(User user);

    //插入用户信息，并返回影响行数
     int userRegister(User user);

    User showUserDetail(User user);

    int updateUserInfo(User user);

    //返回激活状态码
    int active(String activeCode);

    //得到用户数量
     int checkUsername(String username);

     // 结果集进行分页
     Page<User> selectPageByQueryVo(QueryVo vo);

     void updateStateById(String id);
}
