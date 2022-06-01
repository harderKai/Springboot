package com.lukai.firstboot.web;

import com.lukai.firstboot.dao.CategoryDao_;
import com.lukai.firstboot.pojo.Category_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryCtrl {
@Autowired
CategoryDao_ dao;

@RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
    start = start<0?0:start;
    Sort sort = new Sort(Sort.Direction.DESC, "id");
    Pageable pageable = new PageRequest(start, size, sort);
    Page<Category_> page =dao.findAll(pageable);
    m.addAttribute("page", page);
    return "listCategory";

}
    @RequestMapping("/addCategory")
    public String addCategory(Model e, Category_ c){
    dao.save(c);
    return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String delCategory(Model e, Category_ c){
        dao.delete(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String editCategory(Model m, Category_ c) throws Exception {
        Category_ one= dao.getOne(c.getId());
        m.addAttribute("c", one);
        return "editCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category_ c) throws Exception {
        dao.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/getOneCategory")
    public String getOneCategory(Model m,@RequestParam("id") int id){
        Category_ c= dao.getOne(id);
        m.addAttribute("c",c);
        return "getOne";
    }

}
