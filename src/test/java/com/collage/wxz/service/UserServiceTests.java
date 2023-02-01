package com.collage.wxz.service;


import com.collage.wxz.entity.User;
import com.collage.wxz.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserservice userservice;

    @Test
    public void reg(){
        try{
            User user = new User();
            user.setStudentId(6);
            user.setUsername("wxz1");
            user.setPassword("123");
            user.setUserClassification(0);
            userservice.reg(user);
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = new User();
        user.setStudentId(6);
        user.setPassword("123");
        userservice.login(0,"123");
    }
}
