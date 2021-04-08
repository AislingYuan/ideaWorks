package com.cssl.service.impl;

import com.cssl.pojo.Flower;
import com.cssl.mapper.FlowerMapper;
import com.cssl.service.FlowerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerMapper fm;
    @Override
    public Page showAll(int pageIndex,int pageSize) {
        Page<Flower> page = PageHelper.startPage(pageIndex, pageSize);
        List<Flower> flowers = fm.showAll();
        return page;
    }

    @Override
    public int addFlower(Flower flower) {
        return fm.addFlower(flower);
    }
}
