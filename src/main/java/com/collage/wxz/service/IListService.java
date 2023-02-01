package com.collage.wxz.service;


import com.collage.wxz.entity.Lists;

public interface IListService {

    void addList(Lists list);

    int acceptList(Lists lists);

    Lists findListById(int lists);
}
