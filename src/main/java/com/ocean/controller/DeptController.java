package com.ocean.controller;

import com.ocean.entity.Dept;
import com.ocean.repository.DeptRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ocean on 2019/3/6 15:16.
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptRepository deptRepository;

    @RequestMapping("/{id}")
    public Dept findById(@PathVariable("id") Integer id ){
        Dept dept = null;
        Optional<Dept> optional = deptRepository.findById(id);
        optional.isPresent();       //代表是否存在这个对象
        if(optional.isPresent()){
            dept = optional.get();
        }
        return dept;
    }

    @RequestMapping("/create")
    public Dept create(){
        Dept dept = new Dept();
        dept.setdName("tranning");
        dept.setLocaltion("New York");
        deptRepository.save(dept);
        return dept;
    }

    @RequestMapping("/findByDname")
    public List<Dept> findByDName(String dName){
        List<Dept> depts = deptRepository.findDepts(dName);
        return depts;
    }


}
