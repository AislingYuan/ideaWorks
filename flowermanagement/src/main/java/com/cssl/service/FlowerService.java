package com.cssl.service;

import com.cssl.pojo.Flower;
import com.github.pagehelper.Page;

public interface FlowerService {
    Page<Flower> showAll(int pageIndex, int pageSize);

    int addFlower(Flower flower);
}
