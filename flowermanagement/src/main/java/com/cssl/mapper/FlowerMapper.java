package com.cssl.mapper;

import com.cssl.pojo.Flower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FlowerMapper {

    List<Flower> showAll();

    int addFlower(Flower flower);
}
