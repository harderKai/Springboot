package com.lukai.firstboot.dao;

import com.lukai.firstboot.pojo.File_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDao extends JpaRepository<File_,Integer> {
}
