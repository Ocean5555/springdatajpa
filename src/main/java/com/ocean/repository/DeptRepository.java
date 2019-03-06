package com.ocean.repository;

import com.ocean.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ocean on 2019/3/6 15:12.
 */
//JpaRepository 提供了默认的CRUD
public interface DeptRepository extends JpaRepository<Dept,Integer>{
}
