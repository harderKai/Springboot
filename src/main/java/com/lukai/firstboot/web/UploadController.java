package com.lukai.firstboot.web;

import java.io.*;

import com.lukai.firstboot.dao.FileDao;
import com.lukai.firstboot.pojo.File_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    FileDao fdao;


    @RequestMapping("/uploadPage")
    public String toaddPage(){
        return "uploadPage";
    }

@RequestMapping("/upload")
public String toshowPage(@RequestParam("file") MultipartFile file, Model m, HttpServletRequest req){
    try {
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        String destFileName=req.getServletContext().getRealPath("")+"uploaded\\"+fileName;
        File destFile = new File(destFileName);
        File_ f = new File_();
        f.setImg(fileName);
        fdao.save(f);
//文件夹创建并且写入文件
        destFile.getParentFile().mkdirs();
        file.transferTo(destFile);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return "上传失败," + e.getMessage();
    } catch (IOException e) {
        e.printStackTrace();
        return "上传失败," + e.getMessage();
    }

    return "redirect:listAllFile";
}

    @RequestMapping("/listAllFile")
    public String listAllFile(Model m){
        List<File_> f =fdao.findAll();
        m.addAttribute("f",f);
        return "fileShow";
    }
}
