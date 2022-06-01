package com.lukai.firstboot.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lukai.firstboot.Service.Service.GoodsService;
import com.lukai.firstboot.dao.CategoryDao_;
import com.lukai.firstboot.pojo.Category_;
import com.lukai.firstboot.pojo.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa {

    @Autowired
    CategoryDao_ dao;

    @Test
    public void test() {
        List<Category_> cs= dao.findAll();
        for (Category_ c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }


    }

    @Test
    public void test1() {
        Category_ n = new Category_();
        n.setId(1328);
        n.setName("刘行的爹!!!");
        dao.save(n);
        List<Category_> cs= dao.findAll();
        for (Category_ c : cs) {
            System.out.println(c.getId()+" "+ c.getName());
        }

    }
    @Test
    public void test2(){
        Jedis jedis =new Jedis();
        List<Category_> list = new ArrayList<Category_>();
        Category_ c =new Category_();
        Category_ c1 =new Category_();
        c.setId(1);
        c.setName("t1");
        c1.setId(2);
        c1.setName("t2");
        list.add(c);
        list.add(c1);
        String json_string = JSON.toJSONString(list);
        System.out.println(json_string);
        List<Category_> list1  = JSON.parseArray(json_string, Category_.class);
        System.out.println(list1);

    }
    @Autowired
    GoodsService gs;

    @Test
    public void Test3(){

        Goods g=gs.list().get(0);
        System.out.println("name:"+g.getName()+" price："+g.getPassprice());
    }

}