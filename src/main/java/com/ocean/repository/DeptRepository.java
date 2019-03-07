package com.ocean.repository;

import com.ocean.entity.Dept;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ocean on 2019/3/6 15:12.
 */
//JpaRepository 提供了默认的CRUD
public interface DeptRepository extends JpaRepository<Dept,Integer>{

    public List<Dept> findByDName(String dName);

    //JPQL  将*替换别名，表名改为类名，字段名改为属性名
    @Query("select d from Dept d where d.dName=:dName")
    public List<Dept> findDepts(@Param("dName") String dName);
}
