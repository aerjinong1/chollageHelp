package com.collage.wxz.mapper;


import com.collage.wxz.entity.Lists;
import com.collage.wxz.service.ex.ListBeenAccept;
import com.collage.wxz.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
//@MapperScan("com.collage.wxz.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class ListMapperTests {

    @Autowired
    private ListsMapper listmapper;
    @Test
    public void addlist(){
        Lists lists = new Lists();
        lists.setListId(04);
        lists.setStaffId(01);
        lists.setCustomerId(01);
        lists.setStartPoint("a");
        lists.setEndPoint("b");
        lists.setListCreateTime(new Date().toString());
//        lists.setListCompleteTime(new Date());
        lists.setListState(3);

        listmapper.addList(lists);

    }
    @Test
    public void acceptList(){
        try{
            Lists lists = new Lists();
            lists.setListId(1);
            lists.setStaffId(1);
            lists.setListCreateTime(new Date().toString());
//        lists.setListCompleteTime(new Date());
            lists.setListState(1);
            Lists lists1 = listmapper.findListById(1);
            System.out.println(lists1);
            listmapper.acceptList(lists);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void findListById(){
        Lists lists = listmapper.findListById(1);
        System.out.println(lists);
    }

}
