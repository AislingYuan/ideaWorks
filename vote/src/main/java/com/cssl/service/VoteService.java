package com.cssl.service;

import com.cssl.pojo.VoteItem;
import com.cssl.pojo.VoteOption;
import com.cssl.pojo.VoteSubject;
import com.github.pagehelper.Page;

import java.util.List;

public interface VoteService {
    //查询所有投票
    Page<VoteSubject> allVo(String vsTitle,Integer pageIndex);
    //查询某个投票所有选项
    List<VoteOption> allOps(int vsId);
    //根据vsId获取vsTitle
    VoteSubject findByVsId(int vsId);
    //根据标题查找对象
    VoteOption findByOp(String vo_option);
    //根据vsid与userId查询是否已投过票
    Integer canVote(int vs_id,int userId);
    //计算一个投票的选项数，投票数
    int calOption(int vsId);
    int calVote(int vsId);
    //计算一个投票的每个选项的投票数
    int calOps(int vsId,int voId);
    //增加一次投票
    int addVote(VoteItem vi);
    //删除投票
    int delVo(int vsId);
    //删除投票详情
    int delVotes(int vsId);
    int delVotes2(int vo_id);
    //删除所有选项
    int delOps(int vo_id);
    //新增投票
    int addVo(VoteSubject vs);
    int addOps(VoteOption vOps);
    int selectVsId(String vs_title);
    //修改投票信息
    int updVote(VoteSubject vos);
}
