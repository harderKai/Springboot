package com.lukai.firstboot.dao;

import com.lukai.firstboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {


}
