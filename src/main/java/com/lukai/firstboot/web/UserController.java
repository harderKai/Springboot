package com.lukai.firstboot.web;

import com.lukai.firstboot.dao.User_infoDao;
import com.lukai.firstboot.pojo.User_info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    User_infoDao user_info_mapper;

    @RequestMapping("/listAllUsers")
    public String listAll(Model m) throws Exception {
        List<User_info> all = user_info_mapper.getAll();
        m.addAttribute("list", all);
        return "listUser_info";
    }

    @RequestMapping("/test")
    public String Test(Model m, HttpServletRequest request) {
        String str =request.getParameter("c");
        request.getSession().setAttribute("c",str);
        return "test";
    }
    @RequestMapping("/test1")
    public String Test1(Model m, HttpServletRequest request) {

        return "Test_html";
    }

}
