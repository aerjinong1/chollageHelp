package com.collage.wxz.service;

import com.collage.wxz.entity.User;

public interface IUserservice {

    void reg(User user);


    User login(int studentId,String password);

    User findStudentById(int studentId);

    User getstuId(Integer integer);
}
