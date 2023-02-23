package com.collage.wxz.controller;
import com.collage.wxz.entity.Lists;
import com.collage.wxz.service.IListService;
import com.collage.wxz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("list")
public class ListController extends BaseController {
@Autowired
    protected IListService iListService;

    @RequestMapping("addList")
    public JsonResult<Void> addList(HttpSession session, HttpServletRequest request,
                                    @RequestParam(value = "file", required = false) MultipartFile file, Lists lists){
        System.out.println(lists.toString());
//        System.out.println(file);
        lists.setListCreateTime(new Date().toString());
        if (iListService.addList(lists)==1){
            return new JsonResult<>(OK);
        }else{
            return new JsonResult<>(6000 );
        }
    }

    SimpleDateFormat formatter = new SimpleDateFormat("/yyyy/MM/dd/");
    @RequestMapping("/upload")
    public String fileUpload(MultipartFile file, HttpServletRequest request){
        System.out.println(file.toString());
        System.out.println(file.getName());
        System.out.println(file.getResource());
        System.out.println(file.getContentType());
        String time = formatter.format(new Date());
        //图片上传服务器后所在的文件夹
        String realPath = request.getServletContext().getRealPath("/img") + time;
        File folder = new File(realPath);
        if(!folder.exists())
            folder.mkdirs();

        //通常需要修改图片的名字（防止重复）
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));

        try {
            //将文件放到目标文件夹
            file.transferTo(new File(folder, newName));

            //通常还需要返回图片的URL，为了通用性，需要动态获取协议，不要固定写死
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img" + time + newName;
            return returnUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
