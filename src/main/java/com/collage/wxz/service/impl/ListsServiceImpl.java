package com.collage.wxz.service.impl;

import com.collage.wxz.entity.Lists;
import com.collage.wxz.mapper.ListsMapper;
import com.collage.wxz.service.IListService;
import com.collage.wxz.service.ex.ListBeenAccept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListsServiceImpl implements IListService {
    @Autowired
    private ListsMapper listsMapper;
    @Override
    public void addList(Lists list) {
        listsMapper.addList(list);
    }

    @Override
    public int acceptList(Lists lists) {
        int id = lists.getListId();
        Lists lists1 = findListById(id);
        System.out.println(lists1);
        int state = lists1.getListState();
        if (state==1){
            throw  new ListBeenAccept("订单已被抢");
        }
        int row = listsMapper.acceptList(lists1);
        System.out.println(row);
        return row;
    }

    @Override
    public Lists findListById(int id) {
        Lists lists1 = listsMapper.findListById(id);
        return lists1;
    }
}
