package com.collage.wxz.controller;

import com.collage.wxz.entity.User;
import com.collage.wxz.service.ex.InsertException;
import com.collage.wxz.service.ex.PasswordNotMatchException;
import com.collage.wxz.service.ex.ServiceException;
import com.collage.wxz.service.ex.UsernameDuplicatedException;
import com.collage.wxz.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(5000);
            result.setMessage("用户名被占用");
        } else if (e instanceof InsertException) {
            result.setState(4000);
            result.setMessage("用户创建失败未知异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("密码不正确");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5003);
            result.setMessage("更新数据产生未知异常");
        }
        return result;
    }

    protected final Integer getuidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }



}
