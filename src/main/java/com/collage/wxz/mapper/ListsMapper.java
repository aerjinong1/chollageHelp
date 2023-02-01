package com.collage.wxz.mapper;

import com.collage.wxz.entity.Lists;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ListsMapper {


    Integer addList(Lists list);

    Lists findListById(int listId);

    Integer acceptList(Lists lists);
}
