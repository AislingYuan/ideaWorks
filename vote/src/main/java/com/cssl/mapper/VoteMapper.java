package com.cssl.mapper;

import com.cssl.pojo.VoteItem;
import com.cssl.pojo.VoteOption;
import com.cssl.pojo.VoteSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoteMapper {

    //查询所有投票(对标题进行模糊查询)
    List<VoteSubject> allVo(String vsTitle);
    //查询某个投票所有选项
    List<VoteOption> allOps(int vsId);
    //根据vsId获取VoteSubject
    VoteSubject findByVsId(int vsId);
    //根据标题查找对象
    VoteOption findByOp(String vo_option);
    //根据vsid与userId查询是否已投过票
    Integer canVote(@Param("vsId")int vsId,@Param("userId")int userId);
    //计算一个投票的选项数，总投票数
    int calOption(int vsId);
    int calVote(int vsId);
    //计算一个投票的每个选项的投票数
    int calOps(@Param("vsId") int vsId, @Param("voId") int voId);
    //增加一次投票
    int addVote(VoteItem vi);
    //删除投票
    int delVo(int vsId);
    //删除投票详情
    int delVotes(int vsId);
    int delVotes2(int vo_id);
    //删除所有选项
    int delOps(int vsId);
    //新增投票
    int addVo(VoteSubject vs);
    int addOps(VoteOption vOps);
    int selectVsId(String vs_title);
    //修改投票信息
    int updVote(VoteSubject vos);

}
