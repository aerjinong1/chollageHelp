package com.collage.wxz.mapper;

import com.collage.wxz.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
@Autowired
    private UserMapper usermapper;
    @Test
    public void insert(){
        User user = new User();
        user.setStudentId(0007);
        user.setUsername("wxz1");
        user.setPassword("123");
        user.setUserClassification(0);
        usermapper.insert(user);

    }

    @Test
    public void findStudentById(){
        User user = usermapper.findByStudentId(1);
        System.out.println(user);
    }

}
