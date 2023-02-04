package com.collage.wxz.controller;
import com.collage.wxz.entity.Lists;
import com.collage.wxz.service.IListService;
import com.collage.wxz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@RestController
@RequestMapping("list")
public class ListController extends BaseController {
@Autowired
    protected IListService iListService;

    @RequestMapping("addList")
    public JsonResult<Void> addList(Lists lists){
        if (iListService.addList(lists)==1){
            return new JsonResult<>(OK);
        }else{
            return new JsonResult<>(6000 );
        }
    }
}
