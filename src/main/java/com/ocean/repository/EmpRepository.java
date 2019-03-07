package com.ocean.repository;

import com.ocean.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ocean on 2019/3/7 10:54.
 */
public interface EmpRepository extends JpaRepository<Emp,Integer> {

    //select * from emp where deptno = ?
    @Query("select e from Emp e where e.dept.deptNo=:dn")
    public List<Emp> findByDeptno(@Param("dn") Integer deptno);
}
