
package com.collage.wxz.service;


import com.collage.wxz.entity.Lists;
import com.collage.wxz.entity.User;
import com.collage.wxz.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ListServiceTests {
    @Autowired
    private IListService listService;

    @Test
    public void acceptList(){
        try{
            Lists lists = new Lists();
            lists.setListId(1);
            lists.setStaffId(1);
            lists.setListCreateTime(new Date().toString());
//        lists.setListCompleteTime(new Date());
            lists.setListState(1);
            Lists lists1 = listService.findListById(1);
            System.out.println(lists1);
            listService.acceptList(lists);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
}
