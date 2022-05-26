package com.lukai.firstboot.mapper;
import java.util.*;

import com.lukai.firstboot.pojo.Category;
import com.lukai.firstboot.pojo.User_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_info_mapper {
    @Select("select * from user_info")
    public List<User_info> getAll();
}
