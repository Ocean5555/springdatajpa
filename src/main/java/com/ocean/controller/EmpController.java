package com.ocean.controller;

import com.ocean.entity.Dept;
import com.ocean.entity.Emp;
import com.ocean.repository.EmpRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ocean on 2019/3/7 10:55.
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpRepository empRepository;

    @RequestMapping("/{id}")
    public Emp findById(@PathVariable("id") Integer id){
        Optional<Emp> op = empRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

    @RequestMapping("/findByDeptno")
    public List<Emp> findByDeptno(Integer deptno){
        List<Emp> emps = empRepository.findByDeptno(deptno);
        return emps;
    }
}
