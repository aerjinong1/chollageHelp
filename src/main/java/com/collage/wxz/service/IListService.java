package com.collage.wxz.service;


import com.collage.wxz.entity.Lists;

public interface IListService {

    int addList(Lists list);

    int acceptList(Lists lists);

    Lists findListById(Integer lists);
}
