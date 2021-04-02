package com.cssl.service.impl;

import com.cssl.mapper.VoteMapper;
import com.cssl.pojo.VoteItem;
import com.cssl.pojo.VoteOption;
import com.cssl.pojo.VoteSubject;
import com.cssl.service.VoteService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteMapper vm;

    @Override
    public Page<VoteSubject> allVo(String vsTitle,Integer pageIndex) {
        Page<VoteSubject> page = PageHelper.startPage(pageIndex, 3);
        List<VoteSubject> voteVos = vm.allVo(vsTitle);
        return page;
    }

    @Override
    public List<VoteOption> allOps(int vsId) {
        return vm.allOps(vsId);
    }

    @Override
    public VoteSubject findByVsId(int vsId) {
        return vm.findByVsId(vsId);
    }

    @Override
    public VoteOption findByOp(String vo_option) {
        return vm.findByOp(vo_option);
    }

    @Override
    public Integer canVote(int vs_id, int userId) {
        return vm.canVote(vs_id,userId);
    }

    @Override
    public int calOption(int vsId) {
        return vm.calOption(vsId);
    }

    @Override
    public int calVote(int vsId) {
        return vm.calVote(vsId);
    }

    @Override
    public int calOps(int vsId, int voId) {
        return vm.calOps(vsId,voId);
    }

    @Override
    public int addVote(VoteItem vi) {
        return vm.addVote(vi);
    }

    @Override
    public int delVo(int vsId) {
        return vm.delVo(vsId);
    }

    @Override
    public int delVotes(int vsId) {
        return vm.delVotes(vsId);
    }

    @Override
    public int delVotes2(int vo_id) {
        return vm.delVotes2(vo_id);
    }

    @Override
    public int delOps(int vo_id) {
        return vm.delOps(vo_id);
    }

    @Override
    public int addVo(VoteSubject vs) {
        return vm.addVo(vs);
    }

    @Override
    public int addOps(VoteOption vOps) {
        return vm.addOps(vOps);
    }

    @Override
    public int selectVsId(String vs_title) {
        return vm.selectVsId(vs_title);
    }

    @Override
    public int updVote(VoteSubject vos) {
        return vm.updVote(vos);
    }
}
