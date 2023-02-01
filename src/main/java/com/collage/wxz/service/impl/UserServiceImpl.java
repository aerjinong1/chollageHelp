package com.collage.wxz.service.impl;


import com.collage.wxz.entity.User;
import com.collage.wxz.mapper.UserMapper;
import com.collage.wxz.service.IUserservice;
import com.collage.wxz.service.ex.InsertException;
import com.collage.wxz.service.ex.PasswordNotMatchException;
import com.collage.wxz.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserservice {

    @Autowired
    private UserMapper usermapper;

    @Override
    public void reg(User user) {
        int id = user.getStudentId();
        User res = usermapper.findByStudentId(id);
        if (res!=null){
            throw new UsernameDuplicatedException("用户名已被注册");
        }
        Integer rows = usermapper.insert(user);
        if (rows != 1) {
            throw new InsertException("创建用户失败,未知异常请重试");
        }
    }

    @Override
    public User login(int studentId, String password) {
        User res = usermapper.findByStudentId(studentId);
        if (res==null){
            throw new UsernameDuplicatedException("该用户未注册");
        }
        if (!res.getPassword().equals(password)){
            throw new PasswordNotMatchException("密码错误");
        }
        User user = new User();
        user.setStudentId(studentId);
        user.setUsername(res.getUsername());
        return user;

    }

    @Override
    public User findStudentById(int studentId) {
        User res = usermapper.findByStudentId(studentId);
        return res;
    }

    @Override
    public User getstuId(Integer integer) {
        return null;
    }


}
