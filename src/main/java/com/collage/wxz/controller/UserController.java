package com.collage.wxz.controller;

import com.collage.wxz.entity.User;
import com.collage.wxz.service.IUserservice;
import com.collage.wxz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@Controller
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    protected final String name = "ad";

    @Autowired
    protected IUserservice userservice;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userservice.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(int studentId, String password, HttpSession session) {
        User res = userservice.login(studentId,password);
        session.setAttribute("studentID", studentId);



        return new JsonResult<User>(OK,res);
    }

    @RequestMapping("tests")
    public String tests(HttpSession session){

        Object studentID = session.getAttribute("studentID");
        String id = studentID.toString();
        return id;
    }


    @RequestMapping("getStuIdBySession")
    public String getStuIdSession(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("studentID");
        String str = obj.toString();
        return str;
    }

    @RequestMapping("findStudentById")
    public JsonResult<User> findStudentById(int id){
        User user = userservice.findStudentById(id);

        return new JsonResult<>(OK,user);

    }
}
