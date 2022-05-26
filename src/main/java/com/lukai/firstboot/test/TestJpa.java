package com.lukai.firstboot.test;

import java.util.List;
import com.lukai.firstboot.dao.CategoryDao;
import com.lukai.firstboot.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa {

    @Autowired
    CategoryDao dao;

    @Test
    public void test() {
        List<Category> cs= dao.findAll();
        for (Category c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }


    }

    @Test
    public void test1() {
        Category n = new Category();
        n.setId(1328);
        n.setName("刘行的爹!!!");
        dao.save(n);
        List<Category> cs= dao.findAll();
        for (Category c : cs) {
            System.out.println(c.getId()+" "+ c.getName());
        }

    }

}