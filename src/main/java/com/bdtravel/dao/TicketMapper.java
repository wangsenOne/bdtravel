package com.bdtravel.dao;

import com.bdtravel.entity.QueryVo;
import com.bdtravel.entity.Ticket;

import java.util.List;

public interface TicketMapper {
    List<Ticket> selectTicketList(Integer id);

    //总条数
    Integer postCountByQueryVo(QueryVo vo);

    //结果集
    List<Ticket> selectPostListByQueryVo(QueryVo vo);

    //删除门票
    void deleteById(Integer id);

    //添加门票
    void addTicket(Ticket ticket);

    //修改门票信息
    int updateTicket(Ticket ticket);

    Ticket getTicketById(Integer id);
    double selectPriceByFid(Integer id);
}
